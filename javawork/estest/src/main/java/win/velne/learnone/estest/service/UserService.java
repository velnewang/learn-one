package win.velne.learnone.estest.service;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import win.velne.learnone.estest.entity.User;
import win.velne.learnone.estest.mapper.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public long count() {
        return userRepository.count();
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
//        userRepository.deleteById(user.getId());
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public List<User> getByName(String name) {
        List<User> list = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<User> iterableResualt = userRepository.search(matchQueryBuilder);
        iterableResualt.forEach(u -> list.add(u));
        return list;
    }

    public Page<User> pageQuery(Integer page, Integer size, String keyWord) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(
                QueryBuilders.matchPhraseQuery("name", keyWord)
        ).withPageable(PageRequest.of(page, size)).build();
        return userRepository.search(searchQuery);
    }

}
