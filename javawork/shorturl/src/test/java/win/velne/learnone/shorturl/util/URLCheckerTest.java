package win.velne.learnone.shorturl.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class URLCheckerTest {

    @ParameterizedTest
    @MethodSource
    void testCheck(boolean validity, String url) {
        assertEquals(validity, URLChecker.check(url));
    }

    static Stream<Arguments> testCheck() {
        return Stream.of(
                //
                Arguments.of(true, "http://foo.com/blah_blah"),
                //
                Arguments.of(true, "http://foo.com/blah_blah/"),
                //
                Arguments.of(true, "http://www.example.com/wpstyle/?p=364"),
                //
                Arguments.of(true, "https://www.example.com/foo/?bar=baz&inga=42&quux"),
                //
                Arguments.of(true, "http://www.✪.com/wpstyle/?p=364"),
                //
                Arguments.of(true, "http://localhost"),
                //
                Arguments.of(true, "http://➡.ws/䨹")
        );
    }

}
