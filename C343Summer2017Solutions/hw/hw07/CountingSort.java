// Counting Sort, sample solution C343 Summer 2017
import java.util.Arrays;

public class CountingSort {

    public int[] sort (int[] A) {
        // input: A is an unsorted array of integers
        int m = A[0];
        int i;
        for (i = 1; i < A.length; i ++) {
            if (A[i] > m) m = A[i]; 
        }
                
        System.out.println("max key in input array A : " + m);

        // first stage:
        //   count the number of records with each key value,
        //   and save the result to intermediate array B
        //   i.e. B is built as a histogram
        int[] B = new int[m + 1];          // here we use m + 1 instead of m -- easier to read
        for (i = 0; i < A.length; i++) {
            B[A[i]] = B[A[i]] + 1;         // compute histogram value for key found in A[i]
        }
        // second stage:
        //   recompute the array B as a lookup table for the output array C:
        for (i = 1; i <= m; i++) {         // (every element between 1 and m, inclusive)
            B[i] += B[i-1];                // to find lookup value, add histogram value at previous key
        }                                  //      to histogram value at current key
        
        // third stage:
        //   use the lookup table information from B,
        //   to place the items in order, saved to a new array C
        //   (C is the output)
        int[] C = new int[A.length];
        int j;
        for (i = A.length-1; i >= 0; i--) {
            j = B[A[i]] - 1;
            C[j] = A[i];
        }
        
        return C;
    }
    public static void main(String[] argv) {
        // create an unsorted input array of integers to test
        // the counting algorithm
        int[] nums = {4, 0, 20, 1, 2, 3, 0, 6};
        CountingSort sorter = new CountingSort();
        int[] sorted = sorter.sort(nums);
        System.out.println("input array: " + Arrays.toString(nums));
        System.out.println("sorted array: " + Arrays.toString(sorted));
    }
}
