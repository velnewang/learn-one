package win.velne.learnone.shorturl.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Radix62Test {

    @ParameterizedTest
    @MethodSource
    void testToRadix(long decimal, String radix62) {
        if (decimal < 0 || decimal > Integer.MAX_VALUE * Radix62.RADIX) {

            assertEquals(radix62, assertThrows(RuntimeException.class, () -> Radix62.toRadix(decimal)).getMessage());

        } else {

            assertEquals(radix62, Radix62.toRadix(decimal));

        }
    }

    static Stream<Arguments> testToRadix() {
        return Stream.of(
                //
                Arguments.of(Long.MIN_VALUE, "[Exception]Negative number."),
                //
                Arguments.of(-1, "[Exception]Negative number."),
                //
                Arguments.of(0, "0"),
                //
                Arguments.of(1, "1"),
                //
                Arguments.of(61, "Z"),
                //
                Arguments.of(62, "10"),
                //
                Arguments.of(Integer.MAX_VALUE * Radix62.RADIX, "2lkCB10"),
                //
                Arguments.of(Integer.MAX_VALUE * Radix62.RADIX + 1, "[Exception]More than the digits."),
                //
                Arguments.of(Long.MAX_VALUE, "[Exception]More than the digits."));
    }

}
