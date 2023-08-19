import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ques2 {
    public static void main(String[] args) {
        int[] A = {13, 18, 1, 3, 4, 5, 50, 29, 30, 41};
        int X = 200;
        
        int sumOfPrimes = calculateSumOfPrimes(A);
        int[] B = calculateAbsoluteDifference(A, sumOfPrimes);
        int[] C = filterNonPrimes(B);
        int count = countSubArrays(C, X);
        System.out.println(sumOfPrimes);
        System.out.println(B);
        System.out.println(C);
        System.out.println("--------------------");
        System.out.println("Count of sub-arrays: " + count);
    }
    
    public static int calculateSumOfPrimes(int[] A) {
        int sum = 0;
        
        for (int num : A) {
            if (isPrime(num)) {
                System.out.println("adding : "+num);
                sum += num;

            }
        }
        
        return sum;
    }
    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <=Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static int[] calculateAbsoluteDifference(int[] A, int num) {
        int[] B = new int[A.length];
        
        for (int i = 0; i < A.length; i++) {
            B[i] = Math.abs(A[i] - num);
        }
        
        return B;
    }
    
    public static int[] filterNonPrimes(int[] A) {
        List<Integer> nonPrimes = new ArrayList<>();
        
        for (int num : A) {
            if (!isPrime(num)) {
                nonPrimes.add(num);
            }
        }
        
        int[] C = new int[nonPrimes.size()];
        for (int i = 0; i < nonPrimes.size(); i++) {
            C[i] = nonPrimes.get(i);
        }
        
        Arrays.sort(C);
        return C;
    }
    
    public static int countSubArrays(int[] A, int X) {
        int count = 0;
        int sum = 0;
        
        for (int i = 0; i < A.length; i++) {
            sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum < X) {
                    count++;
                } else {
                    break;
                }
            }
        }
        
        return count;
    }
}
