package win.velne.learnone.springcloudconfigclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

    @Value("${foo}")
    String foo;

    @RequestMapping("/")
    public String getFoo() {
        return foo;
    }

}
