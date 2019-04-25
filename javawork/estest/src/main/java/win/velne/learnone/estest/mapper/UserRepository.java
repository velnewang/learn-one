package win.velne.learnone.estest.mapper;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import win.velne.learnone.estest.entity.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

}