package win.velne.learnone.springsecurity.controller;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RootController {

    @GetMapping(path = { "/", "/user", "/admin" })
    public Map<String, String> getMOTD(HttpServletRequest req, Principal principal) {
        Map<String, String> motd = new LinkedHashMap<String, String>();
        motd.put("motd", "Hello Spring Security!");
        motd.put("principal", principal.getName());
        motd.put("uri", req.getRequestURI());
        motd.put("url", req.getRequestURL().toString());
        return motd;
    }

}
