package intermediate.nov12;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumSwap {
    private static int solve(ArrayList<Integer> A, int B) {
        // sub array for elements which are less than or equal to B
        int k = 0;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) <= B) {
                k++;
            }
        }
        System.out.println("Count is " + k);
        // Check the size of subarray
        if (k == 0 || k == 1 || k == A.size()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (A.get(i) > B) {
                count++;
            }
        }
        System.out.println("Count is " + count);
        // Find the minimum swap here
        int omin = count;
        int s = 1, e = k;
        while (e < A.size()) {
            if (A.get(s - 1) > B) {
                count--;
            }
            if (A.get(e) > B) {
                count++;
            }
            s++;
            e++;
            if(count<omin){
                omin= count;
            }
        }
        return omin;
    }

    public static void main(String[] args) {
        // A = [1, 12, 10, 3, 14, 10, 5]
        // B = 8
        // A = [5, 17, 100, 11]
        // B = 20
        ArrayList<Integer> noes = new ArrayList<>(Arrays.asList(52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27,
                48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52,
                47, 87, 33, 87, 70)); //length, sum
      //  ArrayList<Integer> noes2 = new ArrayList<>(Arrays.asList(5, 17, 100, 11));
        System.out.println("Count is " + solve(noes, 19)); //1
      //  System.out.println("Count is " + solve(noes2, 20)); //1
    }
}
