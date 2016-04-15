import java.util.Scanner;

public class FibonacciLastDigit {
  private static long getFibonacciLastDigit(int n) {
    if(n < 2) {
        return n;
    } else {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= n; i++) {
          fib[i] = (fib[i-2] + fib[i-1]) % 10;
        }
        return fib[n];
    }

  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(getFibonacciLastDigit(n));
  }
}
