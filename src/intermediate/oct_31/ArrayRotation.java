package intermediate.oct_31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayRotation {
    private static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {

        Collections.rotate(A, B);
        return A;
    }

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        aList.add(4);
        List<Integer> aList2 = new ArrayList<>();
        aList2.add(2);
        aList2.add(5);
        aList2.add(6);
        List<Integer> l = solve((ArrayList<Integer>) aList, 2);
        List<Integer> l2 = solve((ArrayList<Integer>) aList2, 1);
    }
}
