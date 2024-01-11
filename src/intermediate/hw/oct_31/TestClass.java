package intermediate.hw.oct_31;

import java.util.ArrayList;
import java.util.Arrays;

public class TestClass {
    private static boolean check(String str) {
        int n = str.length();

        // Empty string
        if (n == 0)
            return false;

        // If there is single digit
        if (n == 1)
            return ((str.charAt(0) - '0') % 8 == 0);

        // If there is double digit
        if (n == 2)
            return (((str.charAt(n - 2) - '0') * 10 + (str.charAt(n - 1) - '0')) % 8 == 0);

        // If number formed by last three digits is
        // divisible by 8.
        int last = str.charAt(n - 1) - '0';
        int second_last = str.charAt(n - 2) - '0';
        int third_last = str.charAt(n - 3) - '0';
        System.out.println(last + "--->last---" + second_last + "---second_last---" + third_last);
        return ((third_last * 100 + second_last * 10 + last) % 8 == 0);
    }

    private static int getSecondLargestElement(ArrayList<Integer> A) {
        int i, first, second;
        int len = A.size();
        if (len < 2) {
            return -1;
        }

        first = second = Integer.MIN_VALUE;

        for (i = 0; i < len; i++) {
            /* If current element is greater than
            first then update both first and second */
            if (A.get(i) > first) {
                second = first;
                first = A.get(i);
            }

            /* If arr[i] is in between first and
               second then update second  */
            else if (A.get(i) > second && A.get(i) != first)
                second = A.get(i);
        }

        if (second == Integer.MIN_VALUE)
            return -1;
        else
            return second;

    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(20,12));
        System.out.println("getSecondLargestElement ===>" + getSecondLargestElement(A));

//        String str = "76952";
//
//        int st = str.charAt(0)-'0';
//        System.out.println("--->"+st);
        //System.out.println((str.charAt(0)-'0')%8);

//        if(check(str))
//            System.out.println("Yes");
//        else
//            System.out.println("No");


    }
}
