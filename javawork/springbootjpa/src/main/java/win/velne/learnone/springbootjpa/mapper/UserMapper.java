package win.velne.learnone.springbootjpa.mapper;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import win.velne.learnone.springbootjpa.entity.User;

@Repository
public interface UserMapper extends JpaRepository<User, Long> {

    User findByAccount(String account);

    @Transactional
    void deleteByAccount(String account);

}
