package win.velne.learnone.shorturl;

public class Radix62Converter {

    private static final String DIGITS_STRING = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final char[] DIGITS = DIGITS_STRING.toCharArray();
    private static final int RADIX = DIGITS.length;

    public static String toRadix(int decNumber) {
        // check.
        if (decNumber < 0 || decNumber > 916132831) {
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

    public static int toDecimal(String radixNumber) {
        // check: null.
        if (radixNumber == null) {
            return -1;
        }
        // check: length
        if (radixNumber.length() == 0 || radixNumber.length() > 5) {
            return -2;
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
                return -3;
            }
        }
        // reverse char array.
        char[] chars = new char[radixChars.length];
        for (int i = 0; i < radixChars.length; i++) {
            chars[i] = radixChars[radixChars.length - i - 1];
        }
        // calculate.
        int result = 0;
        for (int figure = 0; figure < chars.length; figure++) {
            for (int i = 0; i < RADIX; i++) {
                if (DIGITS[i] == chars[figure]) {
                    result += i * (int) Math.pow(RADIX, figure);
                }
            }
        }
        return result;
    }

}
