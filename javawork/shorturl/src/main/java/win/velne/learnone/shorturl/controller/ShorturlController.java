package win.velne.learnone.shorturl.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import win.velne.learnone.shorturl.entity.Shorturl;
import win.velne.learnone.shorturl.service.ShorturlService;
import win.velne.learnone.shorturl.util.KeyConverter;
import win.velne.learnone.shorturl.util.Stat;

@RestController
public class ShorturlController {

    @Autowired
    private ShorturlService shorturlService;

    @RequestMapping("/{key:^[0-9][0-9a-zA-Z]{4}$}")
    public void redirect(@PathVariable String key, HttpServletResponse response) throws IOException {
        long id = KeyConverter.key2Id(key);
        if (id < 0 || id > 134217727) {
            // ERROR: Out of range.
            response.sendRedirect("http://short.velne.win/");
            return;
        }
        String url = shorturlService.find(id).getUrl();
        response.sendRedirect(url);
        return;
    }

    public Shorturl getShortInfo(@PathVariable String key) {
        long id = KeyConverter.key2Id(key);
        if (id < 0 || id > 134217727) {
            // ERROR: Out of range.
            return null;
        }
        return shorturlService.find(id);
    }

    @RequestMapping(value = "/create")
    public String generate() {
        System.out.println("common");
        return null;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String generate(@RequestParam String url) {
        try {
            url = URLDecoder.decode(url, "utf-8");
            System.out.println("generate: " + url);
//            return url;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        long id = shorturlService.create("http://example/");
        long id = shorturlService.create(url);
        if (id < 0L) {
            if (id == Stat.ILLEGAL_URL) {
                return "Stat.ILLEGAL_URL";
            }
            if (id == Stat.HASH_COLLISION) {
                return "Stat.HASH_COLLISION";
            }
        }
//        throw new RuntimeException("Ex.");
        return KeyConverter.id2Key(id);
    }

}
