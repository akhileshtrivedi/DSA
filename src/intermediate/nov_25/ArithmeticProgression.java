package intermediate.nov_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArithmeticProgression {
    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int preDiff = 0, diff = 0;
        int firstNumber = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            diff = firstNumber - A.get(i);
            if (i > 1 && preDiff != diff) {
                return 0;
            } else {
                preDiff = diff;
                firstNumber =A.get(i);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(3, 5, 1));//1
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(2, 4, 1));//5
        // ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(8,0,10)); //26
        System.out.println("solve-->" + solve(al));
        System.out.println("solve-->" + solve(al2));
    }
}
