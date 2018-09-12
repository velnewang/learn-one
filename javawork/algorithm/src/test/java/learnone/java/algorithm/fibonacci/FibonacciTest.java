package learnone.java.algorithm.fibonacci;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

class FibonacciTest {

    static int ordinal = 5000000;

    @Test
    void test() {
        doCalc(new FibonacciArray(), ordinal);
        doCalc(new FibonacciHashMap(), ordinal);
//        doCalc(new FibonacciArray(), ordinal);
    }

    static void doCalc(FibCalculable fib) {
        doCalc(fib, ordinal);
    }

    static void doCalc(FibCalculable fib, int ordinal) {
        long s = System.currentTimeMillis();
        BigInteger r = fib.calc(ordinal);
        long e = System.currentTimeMillis();
        System.out.printf("%-16s  %4d  %4d ns\n", fib.getClass().getSimpleName(), r.toString().length(), e - s);
    }
}
