package win.velne.learnone.shorturl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import win.velne.learnone.shorturl.entity.Shorturl;
import win.velne.learnone.shorturl.mapper.ShorturlMapper;
import win.velne.learnone.shorturl.util.HashUtils;
import win.velne.learnone.shorturl.util.StampUtils;
import win.velne.learnone.shorturl.util.Stat;
import win.velne.learnone.shorturl.util.URLChecker;

@Component
public class ShorturlService {

    @Autowired
    private ShorturlMapper shorturlMapper;

    public Shorturl find(long id) {
        Shorturl shorturl = shorturlMapper.getById(id);
        if (shorturl == null) {
            return null;
        }
        shorturl.setCounts(shorturl.getCounts() + 1);
        shorturl.setLastTime(StampUtils.current());
        shorturlMapper.update(shorturl);
        return shorturl;
    }

    public long create(String url) {
        if (!URLChecker.check(url)) {
            return Stat.ILLEGAL_URL;
        }
        long id = HashUtils.sha27(url);
        Shorturl shorturl = shorturlMapper.getById(id);
        if (shorturl != null) {
            if (url.equals(shorturl.getUrl())) {
                // WARN: Repeat URL.
                System.out.println("+++ REPEAT URL: " + url);
                return id;
            } else {
                System.out.println("+++!!! HASH COLLISION: " + url);
                return Stat.HASH_COLLISION;
            }
        } else if (shorturl == null) {
            shorturl = new Shorturl(id, url, 0, StampUtils.current(), StampUtils.current());
            shorturlMapper.insert(shorturl);
        }
        return id;
    }

}
