package win.velne.learnone.shorturl.util;

public class Radix62Utils {

    private static final String DIGITS_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char[] DIGITS = DIGITS_STRING.toCharArray();
    private static final int RADIX = DIGITS.length;

    public static String toRadix(long decNumber) {
        // check.
        if (decNumber < 0 || decNumber > 839299365868340223L) {
            return null;
        }
        // calculate.
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(DIGITS[(int) (decNumber % RADIX)]);
            decNumber = decNumber / RADIX;
        } while (decNumber != 0);
        return sb.reverse().toString();
    }

    public static long toDecimal(String radixNumber) {
        // check: null.
        if (radixNumber == null) {
            return -1L;
        }
        // check: length
        if (radixNumber.length() == 0 || radixNumber.length() > 10) {
            return -2L;
        }
        //
        char[] radixChars = radixNumber.toCharArray();
        // check: illegal. (Could be optimized)
        boolean charIllegal;
        for (char radixChar : radixChars) {
            charIllegal = true;
            for (int i = 0; i < RADIX; i++) {
                if (radixChar == DIGITS[i]) {
                    charIllegal = false;
                    break;
                }
            }
            if (charIllegal) {
                return -3L;
            }
        }
        // reverse char array.
        char[] chars = new char[radixChars.length];
        for (int i = 0; i < radixChars.length; i++) {
            chars[i] = radixChars[radixChars.length - i - 1];
        }
        // calculate.
        long result = 0;
        for (int finger = 0; finger < chars.length; finger++) {
            for (int i = 0; i < RADIX; i++) {
                if (DIGITS[i] == chars[finger]) {
                    result += i * (long) Math.pow(RADIX, finger);
                }
            }
        }
        return result;
    }

}
