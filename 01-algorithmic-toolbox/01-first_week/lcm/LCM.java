import java.util.*;

public class LCM {
  private static long lcm(int a, int b) {
    return (long)a * b / GCD.GCD(a,b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm(a, b));
  }
}

class GCD {
  static int GCD(int a, int b) {
      if(b == 0)
          return a;
      int r = a % b;
      return GCD(b, r);    
  }
}