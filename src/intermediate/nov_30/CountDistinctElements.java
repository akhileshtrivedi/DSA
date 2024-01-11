package intermediate.nov_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctElements {
    private static int solve(ArrayList<Integer> A) {
        if(A.size()<=1){
            return A.size();
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.size();i++){
            set.add(A.get(i));
        }
       return set.size();
    }
    public static void main(String[] args) {
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(3, 4, 3, 6, 6))));
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(3, 3, 3, 9, 0, 1, 0))));
    }
}
