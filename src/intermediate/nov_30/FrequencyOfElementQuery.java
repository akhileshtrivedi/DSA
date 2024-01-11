package intermediate.nov_30;

import java.util.*;

public class FrequencyOfElementQuery {
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Map<Integer,Integer> mp = new HashMap<>();
       // mp.getOrDefault(5, 0);
        for (int i=0;i<A.size();i++){
            mp.put(A.get(i), mp.get(A.get(i)) == null ? 1 : mp.get(A.get(i)) + 1);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i=0;i<B.size();i++) {
           ans.add(mp.getOrDefault(B.get(i),0));
        }
        return ans;
    }
    public static void main(String[] args) {
       // ArrayList<Integer> A = new  ArrayList<Integer>(Arrays.asList(1, 2, 1, 1));
       // ArrayList<Integer> B = new  ArrayList<Integer>(Arrays.asList(1, 2));
        ArrayList<Integer> AA = new  ArrayList<Integer>(Arrays.asList(6, 3, 3, 6, 7, 8, 7, 3, 7 ));
        ArrayList<Integer> BB = new  ArrayList<Integer>(Arrays.asList(10, 9, 8 ));
      //  System.out.println(""+solve(A,B));
        System.out.println(""+solve(AA,BB));
    }
}
