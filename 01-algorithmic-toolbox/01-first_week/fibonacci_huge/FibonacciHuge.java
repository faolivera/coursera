import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciHuge {
    private static BigInteger getFibonacciHuge(long n, int m) {
        int period = 2;
        long p_2 = 0;
        long p_1 = 1;

        for(int i = 2; ; i++) {
            long fib = Fibo.hugeFib(i).mod(BigInteger.valueOf(m)).longValue();
            p_2 = p_1;
            p_1 = fib;

            if(p_2 == 0 && p_1 == 1) {
                period = i - 1;
                break;
            }

        }
        return Fibo.hugeFib(n % period).mod(BigInteger.valueOf(m));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHuge(n, m).toString());
    }

    static BigInteger hugeFib(long n) {
        if(n < 2) {
            return BigInteger.valueOf(n);
        } else {
            BigInteger n_2 = BigInteger.ZERO;
            BigInteger n_1 = BigInteger.ONE;

            for(long i = 2; i <= n; i++) {
                BigInteger sum = n_1.add(n_2);
                n_2 = n_1;
                n_1 = sum;
            }
            return n_1;
        }
    }

}


final class Fibo {

    private Fibo() { }

    public static long hugeFib(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("The fibo value cannot be negative");
        }

        if (n <= 1) return n;

        long[][] result = {{1, 0}, {0, 1}}; // identity matrix.
        long[][] fiboM = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n%2 == 1) {
                multMatrix(result, fiboM);
            }
            n = n / 2;
            multMatrix(fiboM, fiboM);
        }

        return result[1][0];
    }

    private static void multMatrix(long[][] m, long [][] n) {
        long a = m[0][0] * n[0][0] +  m[0][1] * n[1][0];
        long b = m[0][0] * n[0][1] +  m[0][1] * n[1][1];
        long c = m[1][0] * n[0][0] +  m[1][1] * n[0][1];
        long d = m[1][0] * n[0][1] +  m[1][1] * n[1][1];

        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c;
        m[1][1] = d;
    }

}