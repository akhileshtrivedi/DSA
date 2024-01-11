package intermediate.nov_28;

import java.util.ArrayList;
import java.util.Arrays;

public class Isalphanumeric {
    private static int solve(ArrayList<Character> A) {
        int ans=0;
        for(int i=0;i<A.size();i++) {
            char character =A.get(i);
            if ((character >= '0' && character <= '9') || (character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
              ans=1;
            } else {
                return 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       // System.out.println(""+solve(new ArrayList<Character>(Arrays.asList('S', 'c', 'a', 'l', 'e', 'r', 'A', 'c', 'a', 'd', 'e', 'm', 'y', '2', '0', '2', '0'))));
        System.out.println(""+solve(new ArrayList<Character>(Arrays.asList('S', 'c', 'a', 'l', 'e', 'r', '#', '2', '0', '2', '0'))));
    }
}
