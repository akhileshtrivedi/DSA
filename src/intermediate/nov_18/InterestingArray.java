package intermediate.nov_18;

import java.util.ArrayList;
import java.util.Arrays;

public class InterestingArray {
    private static String solve(ArrayList<Integer> A) {
        //if(A.size()<=1){
        //     return "No";
        // }
        //int xor = A.get(0) ^ A.get(1);
        //int firstPart = xor / 2;
        //int secondPart = firstPart;
        //int merge = firstPart ^ secondPart;
        int n = A.size();
        // variable to store the value of XOR
        int xor = 0;
        // traversing the array
        for (int i = 0; i < n; i++) {
            xor ^= A.get(i);
        }
        if (xor % 2 == 0) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public static void main(String[] args) {
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(9, 17))));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1))));
    }

}
