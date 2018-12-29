package win.velne.learnone.shorturl.util;

import java.util.regex.Pattern;

public class URLChecker {

    private static final String REGEXP_URL;
    private static final Pattern PATTERN_URL;

    static {
        REGEXP_URL = "https?:/{2}[^\\s]*";
        PATTERN_URL = Pattern.compile(REGEXP_URL);
    }

    public static boolean check(String url) {
        return PATTERN_URL.matcher(url).matches();
    }

}
