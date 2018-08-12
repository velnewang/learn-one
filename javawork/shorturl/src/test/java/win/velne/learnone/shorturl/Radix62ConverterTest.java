package win.velne.learnone.shorturl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Radix62ConverterTest {

    @ParameterizedTest
    @MethodSource
    void testToRadix(long decimal, String radix62) {
        assertEquals(Radix62Converter.toRadix(decimal), radix62);
    }

    @ParameterizedTest
    @MethodSource
    void testToDecimal(String radix62, long decimal) {
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
                Arguments.of(0L, "0"),
                //
                Arguments.of(1L, "1"),
                //
                Arguments.of(61L, "Z"),
                //
                Arguments.of(62L, "10"),
                //
                Arguments.of(3843L, "ZZ"),
                //
                Arguments.of(238327L, "ZZZ"),
                //
                Arguments.of(14776335L, "ZZZZ"),
                //
                Arguments.of(916132831L, "ZZZZZ"),
                //
                Arguments.of(Integer.MAX_VALUE, "2lkCB1"),
                //
                Arguments.of(56800235583L, "ZZZZZZ"),
                //
                Arguments.of(13984563473216086L, "1234567890"),
                //
                Arguments.of(839299365868340223L, "ZZZZZZZZZZ"),
                //
                Arguments.of(839299365868340223L + 1L, null),
                //
                Arguments.of(Long.MAX_VALUE, null)

        // Arguments.of(Long.MAX_VALUE, "aZl8N0y58M7"),
        );
    }

    static Stream<Arguments> testToDecimal() {
        return Stream.of(
                //
                Arguments.of("+", -3L),
                //
                Arguments.of("", -2L),
                //
                Arguments.of(null, -1L),
                //
                Arguments.of("0", 0L),
                //
                Arguments.of("1", 1L),
                //
                Arguments.of("Z", 61L),
                //
                Arguments.of("10", 62L),
                //
                Arguments.of("ZZ", 3843L),
                //
                Arguments.of("ZZZ", 238327L),
                //
                Arguments.of("ZZZZ", 14776335L),
                //
                Arguments.of("ZZZZZ", 916132831L),
                //
                Arguments.of("2lkCB1", Integer.MAX_VALUE),
                //
                Arguments.of("ZZZZZZ", 56800235583L),
                //
                Arguments.of("1234567890", 13984563473216086L),
                //
                Arguments.of("ZZZZZZZZZZ", 839299365868340223L),
                //
                Arguments.of("10000000000", -2L),
                //
                Arguments.of("12345678901", -2L),
                //
                Arguments.of("+-+-+-+-+-+", -2L)

        // Arguments.of("aZl8N0y58M7", Long.MAX_VALUE),
        );
    }

}
