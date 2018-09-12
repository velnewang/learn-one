package learnone.java.algorithm.fibonacci;

import java.math.BigInteger;

public class FibonacciArray implements FibCalculable {

    private BigInteger memo[];

    @Override
    public BigInteger calc(int ordinal) {
        memo = new BigInteger[ordinal + 1];
        memo[0] = BigInteger.valueOf(0);
        memo[1] = BigInteger.valueOf(1);
        memo[2] = BigInteger.valueOf(1);
        memo[3] = BigInteger.valueOf(2);
        return f2(ordinal);
    }

    /**
     * formula: <BR/>
     * f(2n) = f(n)*[f(n+1)+f(n-1)] <BR/>
     * f(2n+1) = f(n)*f(n)+f(n+1)*f(n+1) <BR/>
     */
    private BigInteger f2(int n) {
        if (memo[n] == null) {
            if (n % 2 == 0) {
                memo[n] = f2(n / 2).multiply(f2(n / 2 + 1).add(f2(n / 2 - 1)));
            } else {
                memo[n] = f2(n / 2).pow(2).add(f2(n / 2 + 1).pow(2));
            }
        }
        return memo[n];
    }
}
