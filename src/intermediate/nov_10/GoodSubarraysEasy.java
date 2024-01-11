package intermediate.nov_10;

import java.util.ArrayList;
import java.util.Arrays;

public class GoodSubarraysEasy {
    private static int solve(ArrayList<Integer> A, int B) {
        int ans=0;
        int n =A.size();
        for(int i=0; i<n; i++) { // for all i
            int sum=0;
            int j=i;
            while(j<n && sum+A.get(j)<B){ // find the longest subarray
                sum+=A.get(j++);
            }
            while(j<n && sum+A.get(j)<B){ // find the longest subarray
                sum+=A.get(j++);
            }
            ans+=(j-i); // count up its length
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(" I am here for Good subArrays"+solve(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)),4));
    }
}
