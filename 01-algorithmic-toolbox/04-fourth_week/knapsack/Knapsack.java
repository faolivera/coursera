import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] items) {

        int[][] value = new int[W + 1][items.length + 1];

        for(int i = 0; i <= items.length; i++)
            value[0][i] = 0;

        for(int i = 0; i <= W; i++)
            value[i][0] = 0;

        for(int i = 1; i <= items.length; i++) {
            for(int w = 0; w <= W; w++) {
                value[w][i] = value[w][i - 1];
                if(items[i-1] <= w) {
                    int val = value[w - items[i-1]][i - 1] + items[i-1];
                    if(value[w][i] < val)
                        value[w][i] = val;
                }
            }
        }

        return value[W][items.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

