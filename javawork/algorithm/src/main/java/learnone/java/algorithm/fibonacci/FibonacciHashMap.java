package learnone.java.algorithm.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;

public class FibonacciHashMap implements FibCalculable {

    private HashMap<Integer, BigInteger> memo = new HashMap<>();

    @Override
    public BigInteger calc(int n) {
        memo.put(0, BigInteger.valueOf(0));
        memo.put(1, BigInteger.valueOf(1));
        memo.put(2, BigInteger.valueOf(1));
        memo.put(3, BigInteger.valueOf(2));
        return f2(n);
    }

    /**
     * formula: <BR/>
     * f(2n) = f(n)*[f(n+1)+f(n-1)] <BR/>
     * f(2n+1) = f(n)*f(n)+f(n+1)*f(n+1) <BR/>
     */
    private BigInteger f2(int n) {
        if (!memo.containsKey(n)) {
            if (n % 2 == 0) {
                memo.put(n, f2(n / 2).multiply(f2(n / 2 + 1).add(f2(n / 2 - 1))));
            } else {
                memo.put(n, f2(n / 2).pow(2).add(f2(n / 2 + 1).pow(2)));
            }
        }
        return memo.get(n);
    }
}
