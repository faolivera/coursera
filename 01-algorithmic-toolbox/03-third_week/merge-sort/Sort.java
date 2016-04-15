import java.util.Scanner;

public class Sort {


	public static void sort(int[] arr, int l, int r) {
		
	}


    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(values, 0, n - 1));
    }
}