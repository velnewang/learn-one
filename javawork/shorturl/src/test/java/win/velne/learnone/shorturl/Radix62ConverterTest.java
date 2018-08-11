package win.velne.learnone.shorturl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Radix62ConverterTest {

    @ParameterizedTest
    @MethodSource
    void testToRadix(int decimal, String radix62) {
        assertEquals(Radix62Converter.toRadix(decimal), radix62);
    }

    @ParameterizedTest
    @MethodSource
    void testToDecimal(String radix62, int decimal) {
        assertEquals(Radix62Converter.toDecimal(radix62), decimal);
    }

    static Stream<Arguments> testToRadix() {
        return Stream.of(
                //
                Arguments.of(Integer.MIN_VALUE, null),
                //
                Arguments.of(-3, null),
                //
                Arguments.of(-2, null),
                //
                Arguments.of(-1, null),
                //
                Arguments.of(0, "0"),
                //
                Arguments.of(1, "1"),
                //
                Arguments.of(61, "Z"),
                //
                Arguments.of(62, "10"),
                //
                Arguments.of(3843, "ZZ"),
                //
                Arguments.of(238327, "ZZZ"),
                //
                Arguments.of(14776335, "ZZZZ"),
                //
                Arguments.of(916132831, "ZZZZZ"),
                //
                Arguments.of(916132831 + 1, null),
                //
                Arguments.of(Integer.MAX_VALUE, null)

        );
        // Arguments.of(Integer.MAX_VALUE, "2lkCB1"),
        // Arguments.of(56800235583L,"ZZZZZZ"),
        // Arguments.of(839299365868340223L, "ZZZZZZZZZZ"),
        // Arguments.of(Long.MAX_VALUE, "aZl8N0y58M7"),
    }

    static Stream<Arguments> testToDecimal() {
        return Stream.of(
                //
                Arguments.of("+", -3),
                //
                Arguments.of("", -2),
                //
                Arguments.of(null, -1),
                //
                Arguments.of("0", 0),
                //
                Arguments.of("1", 1),
                //
                Arguments.of("Z", 61),
                //
                Arguments.of("10", 62),
                //
                Arguments.of("ZZ", 3843),
                //
                Arguments.of("ZZZ", 238327),
                //
                Arguments.of("ZZZZ", 14776335),
                //
                Arguments.of("ZZZZZ", 916132831),
                //
                Arguments.of("100000", -2),
                //
                Arguments.of("123456", -2),
                //
                Arguments.of("+-+-+-", -2)

        );
        // Arguments.of("2lkCB1", Integer.MAX_VALUE),
        // Arguments.of("ZZZZZZ", 56800235583L),
        // Arguments.of("ZZZZZZZZZZ", 839299365868340223L),
        // Arguments.of("aZl8N0y58M7", Long.MAX_VALUE),
    }

}
