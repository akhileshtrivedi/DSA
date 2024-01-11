package intermediate.oct_31;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PairSum {
    public int printpairs(ArrayList<Integer> A, int B)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < A.size(); ++i) {
            int temp = B - A.get(i);
            if (s.contains(temp)) {
                System.out.println("Yes");
                return 1;
            }
            s.add(A.get(i));
        }
        return 0;
    }
    public static void main(String[] args) {
        List<Integer> aList=  new ArrayList<>();
        aList.add(1);
        aList.add(2);
        aList.add(3);
        aList.add(4);
        // aList.add(5);

        PairSum ps = new PairSum();
        System.out.println("  " + ps.printpairs((ArrayList<Integer>) aList, 7));



    }
}
