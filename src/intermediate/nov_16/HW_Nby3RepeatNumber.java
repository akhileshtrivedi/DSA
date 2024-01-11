package intermediate.nov_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW_Nby3RepeatNumber {
   private static int appearsNBy3(final List<Integer> a)
    {
        Integer[] arr = new Integer[a.size()];
        arr = a.toArray(arr);
        int n =a.size();
        int count1 = 0, count2 = 0;

        int first =  Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (first == arr[i])
                count1++;

            else if (second == arr[i])
                count2++;

            else if (count1 == 0) {
                count1++;
                first = arr[i];
            }

            else if (count2 == 0) {
                count2++;
                second = arr[i];
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == first)
                count1++;

            else if (arr[i] == second)
                count2++;
        }

        if (count1 > n / 3)
            return first;

        if (count2 > n / 3)
            return second;

        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 1, 2, 3, 1, 1 };
        int n = arr.length;
        System.out.println(appearsNBy3(new ArrayList<>(Arrays.asList(1, 2, 3, 1, 1 ))));

    }
}