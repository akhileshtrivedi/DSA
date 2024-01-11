package intermediate.nov12;

import java.util.ArrayList;
import java.util.Arrays;

public class SlidingWindow {
    private static int solve(ArrayList<Integer> A, int B, int C) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < B; i++)
            sum = sum + A.get(i);

        if(A.size() == 1 && C== sum )
            count=1;

        int osum=sum, start=1, end=B;
        while(end<A.size()){
            sum = sum-A.get(start-1)+A.get(end);
            if(sum==C){
                count=1;
            }
            if(sum>osum) {
                osum = sum;
            }
            start++;
            end++;;
        }
        return count;
    }


    public static void main(String[] args) {
        //A : [ 6, 3, 3, 6, 7, 8, 7, 3, 7 ]
        ArrayList<Integer> noes = new ArrayList<>(Arrays.asList(6, 3, 3, 6, 7, 8, 7, 3, 7 )); //length, sum
        ArrayList<Integer> noes2 = new ArrayList<>(Arrays.asList(4, 2, 2));
        System.out.println("Count is " + solve(noes, 2, 10)); //1
       // System.out.println("Count is " + solve(noes2, 2, 8)); //0
        // B = 2
        // C = 5

        //B = 2
        //C = 8


    }
}
