import java.util.*;

public class PrimitiveCalculator {

    public static List<Integer> optimalSequence(int n) {
        int N = n + 1;
        int[] nOperations = new int[N]; 

        nOperations[1] = 0;
        for(int i = 2; i < N; i++) {
            int nOps = nOperations[i - 1];

            if(i % 3 == 0 &&
               nOperations[i / 3] < nOps) {
                nOps = nOperations[i / 3];
            } 

            if(i % 2 == 0 &&
               nOperations[i / 2] < nOps) {
                nOps = nOperations[i / 2];
            }
            nOperations[i] = nOps + 1;
        }

        List<Integer> sequence = new ArrayList<Integer>();
        while(n > 1) {
            sequence.add(n);

            int i = n - 1;
            int nOps = nOperations[n - 1];

            if(n % 3 == 0 &&
               nOperations[n / 3] < nOps) {
                nOps = nOperations[n / 3];
                i = n / 3; 
            } 

            if(n % 2 == 0 &&
               nOperations[n / 2] < nOps) {
                i = n / 2; 
            }
            n = i;
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimalSequence(n);


        System.out.println(sequence.size() - 1);
        
        
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

