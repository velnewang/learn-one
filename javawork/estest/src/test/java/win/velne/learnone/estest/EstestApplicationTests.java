package win.velne.learnone.estest;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import win.velne.learnone.estest.entity.User;
import win.velne.learnone.estest.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstestApplicationTests {

    @Autowired
    private UserService userService;

    @Before
    public void testAdd() {
        User user = new User();
        user.setId("001");
        user.setName("没有名字");
        user.setAge(500);
        userService.add(user);
        user = new User();
        user.setId("002");
        user.setName("有名字");
        user.setAge(500);
        userService.add(user);
    }

    @After
    public void testDelete() {
        User user = new User();
        user.setId("001");
        userService.delete(user);
        user = new User();
        user.setId("002");
        userService.delete(user);
    }

    @Test
    public void testGetAll() {
        Iterable<User> iterable = userService.getAll();
        System.out.print("testGetAll(): ");
        iterable.forEach(System.out::println);
    }

    @Test
    public void testGetByName() {
        List<User> list = userService.getByName("没有名字");
        System.out.println("testGetByName(): " + list.toString());
    }

    @Test
    public void testPage() {
        Page<User> page = userService.pageQuery(1, 1, "名字");
        System.out.println("page.getTotalPages(): " + page.getTotalPages());
        System.out.println("page.getNumber(): " + page.getNumber());
        System.out.println("page.getContent(): " + page.getContent());
    }

}
