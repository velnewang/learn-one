package win.velne.learnone.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import win.velne.learnone.springbootjpa.entity.User;
import win.velne.learnone.springbootjpa.mapper.UserMapper;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/start")
    public void start() {
        User user = new User();
        user.setName("甲");
        user.setAccount("jia");
        user.setPassword("jia123");
        userMapper.save(user);
    }

    @RequestMapping("/end")
    public void end() {
        userMapper.deleteByAccount("jia");
    }

    @RequestMapping("/list")
    public List<User> getUser() {
        return userMapper.findAll();
    }

}
