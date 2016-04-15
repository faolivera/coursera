import java.util.Scanner;
import java.util.HashMap;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int c = capacity;
        double value = 0;
        HashMap<Double, Integer> densitiesMap = new HashMap<Double, Integer>();
        int size = values.length;
        double[] densities = new double[size];

        for(int i = 0; i < size; i++) {
            double density = (double)values[i] / weights[i];
            densities[i] = density;
            densitiesMap.put(density, i);
        }

        MergeSort.sort(densities, 0, size - 1);

        for(int i = size - 1; i >= 0; i--) {
            int idx = densitiesMap.get(densities[i]);
            int v = values[idx];
            int w = weights[idx];
            if(w <= c) {
                value += v;
                c -= w;
            } else if(c > 0) {
                value += ((double) c / w) * v;
                c = 0;
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(String.format( "%.4f", getOptimalValue(capacity, values, weights)));
        
    }


    static class MergeSort {


        static void merge(double[] arr, int l, int m, int r) {

            int sizeLeft = m - l + 1;
            int sizeRight = r - m;

            double[] L = new double[sizeLeft];
            double[] R = new double[sizeRight];

            for (int i=0; i < sizeLeft; i++)
                L[i] = arr[l + i];
            for (int j=0; j < sizeRight; j++)
                R[j] = arr[m + 1 + j];

            int i = 0;
            int j = 0;
            int k = l;

            while(i < sizeLeft && j < sizeRight) {
                if(L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            while(i < sizeLeft) {
                arr[k] = L[i];
                i++;
                k++;
            }

            while(j < sizeRight) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        static void sort(double[] arr, int l, int r) {

            if (l < r) {
                int m = (l + r) / 2;

                sort(arr, l, m);
                sort(arr, m + 1, r);

                merge(arr, l, m, r);
            }
        }
    }
} 