package win.velne.learnone.shorturl;

import org.junit.jupiter.api.Test;

import win.velne.learnone.shorturl.util.Radix62Utils;
import win.velne.learnone.shorturl.util.URLChecker;

public class CodecTest {

    @Test
    public void test() {
        String url = "https://www.cnblogs.com/ggjucheng/p/3423731.html";
        System.out.println(url);
        System.out.println(URLChecker.check(url));
//        System.out.println(Radix62Converter.toRadix(147763359));
//        int shortHash = Integer.parseInt("ffffffffff".substring(0, 7), 16) >> 1;
//        System.out.println(Integer.toString(shortHash, 2));
//        System.out.println(hash2Short("ffffffffff"));
//        System.out.println(hash2Short("0000000eee"));
//        System.out.println(hash2Short("0000002eee"));
//        System.out.println(hash2Short("fffffffeee"));

    }

    /**
     * MIN: "0UPPW" : 13545632 = (10*62^4-1) - (2^27-1)
     */
    public static final int MIN_SHORTURL = 13545632;

    public static String hash2Short(String hash) {
        int shortHash = Integer.parseInt(hash.substring(0, 7), 16) >> 1;
        String shortURL = Radix62Utils.toRadix(MIN_SHORTURL + shortHash);
        return shortURL;
    }

}
