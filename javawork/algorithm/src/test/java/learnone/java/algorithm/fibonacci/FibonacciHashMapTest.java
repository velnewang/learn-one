package learnone.java.algorithm.fibonacci;

import org.junit.jupiter.api.Test;

import learnone.java.algorithm.utils.MemoryInfo;

class FibonacciHashMapTest {

    @Test
    void testCalc() {
        FibonacciTest.doCalc(new FibonacciHashMap());
        MemoryInfo.print();
        FibonacciTest.doCalc(new FibonacciHashMap());
        MemoryInfo.print();
    }

}
