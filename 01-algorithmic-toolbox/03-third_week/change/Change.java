import java.util.Scanner;

public class Change {
    private static int getChange(int n) {
    	int[] coins = {10, 5, 1};
        int coinsUsed = 0;

        for(int i = 0; i <= 2; i++) {
            int currentCoin = coins[i];
            int coinsToUse = n / currentCoin;
            coinsUsed += coinsToUse;
            n -= coinsToUse * currentCoin;
        }

        return coinsUsed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(getChange(n));

    }
}

