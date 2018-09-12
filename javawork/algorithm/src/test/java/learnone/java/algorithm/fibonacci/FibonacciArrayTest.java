package learnone.java.algorithm.fibonacci;

import org.junit.jupiter.api.Test;

import learnone.java.algorithm.utils.MemoryInfo;

class FibonacciArrayTest {

    @Test
    void testCalc() {
        FibonacciTest.doCalc(new FibonacciArray());
        MemoryInfo.print();
        FibonacciTest.doCalc(new FibonacciArray());
        MemoryInfo.print();
    }

}
