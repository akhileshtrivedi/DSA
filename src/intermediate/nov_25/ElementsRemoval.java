package intermediate.nov_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ElementsRemoval {
    private static int solve(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        int count=0;
        for(int i=0;i<A.size();i++){
            count = count + A.get(i)*(i+1);
            System.out.println("Count is here-->"+count);
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(2,1));//4
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(5));//5
        ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(8,0,10)); //26
        System.out.println("solve-->"+solve(al));
        System.out.println("solve-->"+solve(al2));
        System.out.println("solve-->"+solve(al3));

    }
}
