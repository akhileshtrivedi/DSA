package intermediate.nov_14;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTest {


    // Function to calculate the length of the
    // longest consecutive 1's
    static int maximum_one(String A) {
        int n = A.length();
        int countOne = 0, maxCount = 0, temp = 0;

        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                countOne++;
                temp++;
            } else {
                maxCount = Math.max(maxCount, temp);
                temp = 0;
            }
        }
        maxCount = Math.max(maxCount, temp);

        // To store cumulative 1's
        int[] left = new int[n];
        int right[] = new int[n];

        if (A.charAt(0) == '1')
            left[0] = 1;
        else
            left[0] = 0;

        if (A.charAt(n - 1) == '1')
            right[n - 1] = 1;
        else
            right[n - 1] = 0;

        for (int i = 1; i < n; i++) {
            if (A.charAt(i) == '1')
                left[i] = left[i - 1] + 1;

            else
                left[i] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (A.charAt(i) == '1')
                right[i] = right[i + 1] + 1;

            else
                right[i] = 0;
        }

        for (int i = 1; i < n - 1; i++) {
            if (A.charAt(i) == '0') {

                int sum = left[i - 1] + right[i + 1];

                if (sum < countOne)
                    maxCount = Math.max(maxCount, sum + 1);

                else
                    maxCount = Math.max(maxCount, sum);
            }
        }

        return maxCount;
    }

    private static int getCountIncreasingTriplets(ArrayList<Integer> A) {
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                for (int k = j + 1; k < A.size(); k++) {
                    if (A.get(i) < A.get(j) && A.get(j) < A.get(k))
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // string
        //int arr2[] = {1,2,4,3};
       // int arr3[] = {2,1,2,3};
        String s = "111011101";
ArrayList<Integer> aList = new ArrayList<>(Arrays.asList(1,2,4,3));
        ArrayList<Integer> aList2 = new ArrayList<>(Arrays.asList(2,1,2,3));
        System.out.println("aList--->"+getCountIncreasingTriplets(aList));
        System.out.println("aList2--->"+getCountIncreasingTriplets(aList2));
        //System.out.println(maximum_one(s));
    }
}

