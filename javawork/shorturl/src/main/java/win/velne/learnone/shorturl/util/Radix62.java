package win.velne.learnone.shorturl.util;

/**
 * Radix Converter.<br />
 * Convert decimal and radix62.<br />
 * Map [0-133143986114] to ["0"-"2lkCB10"].<br />
 * Critical number:<br />
 * 0->"0"<br />
 * 61->"Z"<br />
 * 133143986114->"2lkCB10"<br />
 * 
 * @author Velne
 * @since 2018/08/08
 */
public class Radix62 {

    private static String NOTATIONS_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final char[] DIGIT = NOTATIONS_STRING.toCharArray();
    public static final long RADIX = NOTATIONS_STRING.length();

    public static String toRadix(long decimal) {
        if (decimal < 0) {
            throw new RuntimeException("[Exception]Negative number.");
        }
        if (decimal > Integer.MAX_VALUE * RADIX) {
            throw new RuntimeException("[Exception]More than the digits.");
        }
        StringBuffer sb = new StringBuffer();
        do {
            sb.append(DIGIT[(int) (decimal % RADIX)]);
            decimal = decimal / RADIX;
        } while (decimal != 0);
        return sb.reverse().toString();
    }

    public static long toDecimal(String radix) {
        // TODO
        return 0;
    }
}
