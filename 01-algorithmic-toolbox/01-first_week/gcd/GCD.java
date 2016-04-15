import java.util.Scanner;

class GCD {
  public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      int a = s.nextInt();
      int b = s.nextInt();
      System.out.println(GCD(a,b));
  }

  static int GCD(int a, int b) {
      if(b == 0)
          return a;
      int r = a % b;
      return GCD(b, r);    
  }
}
