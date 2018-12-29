package win.velne.learnone.shorturl.util;

/**
 * :Alphabet of 62 </br>
 * 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ </br>
 * :Range </br>
 * 2^27 / (10*62^4) ≈ 90.83% </br>
 * :Critical Value </br>
 * MAX: ("9ZZZZ")62 = (147763359)10 = (10*62^4-1) </br>
 * MIN: ("0UPPW")62 = (13545632)10 = (10*62^4-1) - (2^27-1) </br>
 * RANGE: 2^27-1 = 134217727 </br>
 */
public class KeyConverter {

    /**
     * MIN: "0UPPW" : 13545632 = (10*62^4-1) - (2^27-1)
     */
    public static final long MIN_SHORTURL = 13545632L;

    public static String id2Key(long id) {
        // unchecked
        String key = Radix62Utils.toRadix(id + MIN_SHORTURL);
        return key;
    }

    public static long key2Id(String key) {
        // unchecked
        long id = Radix62Utils.toDecimal(key) - MIN_SHORTURL;
        return id;
    }

}
