package win.velne.learnone.shorturl.util;

import org.apache.commons.codec.digest.DigestUtils;

public class HashUtils {

    public static long sha27(String data) {
        String hashSHA1 = DigestUtils.sha1Hex(data);
        long hash27 = Integer.parseInt(hashSHA1.substring(0, 7), 16) >> 1;
        return hash27;
    }

}
