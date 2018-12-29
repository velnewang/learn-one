package win.velne.learnone.shorturl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public Shorturl redirect(@PathVariable String key) {
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String generate(@RequestBody String url) {
        System.out.println(url);
        long id = shorturlService.create("http://example/");
        if (id < 0L) {
            if (id == Stat.ILLEGAL_URL) {
                return "Stat.ILLEGAL_URL";
            }
            if (id == Stat.HASH_COLLISION) {
                return "Stat.HASH_COLLISION";
            }
        }
        return KeyConverter.id2Key(id);
    }

}
