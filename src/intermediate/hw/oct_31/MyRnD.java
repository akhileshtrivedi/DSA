package intermediate.hw.oct_31;

import java.util.ArrayList;

public class MyRnD {
    private static int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int max_so_far = Integer.MIN_VALUE, max_ending
                = 0;
        for (int i = 0; i < A; i++) {
            max_ending = max_ending + C.get(i);
            if (max_so_far < max_ending)
                max_so_far = max_ending;
            System.out.println("max_so_far in if --->"+max_so_far);
            if (i == 0 && B < max_so_far) {
                return 0;
            }
            if (max_ending < 0)
                max_ending = 0;
        }
        System.out.println("max_so_far--->"+max_so_far);
        if (B < max_so_far )
            return B;
        return max_so_far;

    }
/*
    private static int maxSubArraySum(int a[], int maxSum) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here
                = 0;

        for (int i = 0; i < size; i++) {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (maxSum > max_so_far)
                return maxSum;
            if (i == 0 && maxSum < max_so_far)
                return 0;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    } */


   private static int findMaxSubarraySum( int A, int B,  ArrayList<Integer> C)
    {
        int curr_sum = C.get(0), max_sum = 0, start = 0;
        for (int i = 1; i < A; i++) {
            if (curr_sum <= B)
                max_sum = Math.max(max_sum, curr_sum);
                while (curr_sum + C.get(i) > B && start < i) {
                    curr_sum -= C.get(start);
                    start++;
                }
                curr_sum += C.get(i);
            }
            if (curr_sum <= B)
                max_sum = Math.max(max_sum, curr_sum);

            return max_sum;
        }

    public static void main(String[] args) {
        System.out.println("test");
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        ArrayList<Integer> al3 = new ArrayList<>();
        ArrayList<Integer> al4 = new ArrayList<>();
        ArrayList<Integer> al5 = new ArrayList<>();
        al.add(2);
        al.add(2);
        al.add(3);
        al.add(4); // 1, 3
        al.add(5);
        al.add(13);

        al2.add(2);
        al2.add(2);
        al2.add(2);

        al3.add(4);//0,1


        al4.add(7);
        al4.add(1);
        al4.add(8);
        al4.add(5); // 1, 3
        al4.add(8);
        al4.add(5);
        al4.add(3); // 1, 3
        al4.add(3);
        al4.add(5); //45
//7, 10, 3, 1
        al5.add(7);
        al5.add(10);
        al5.add(3);
        al5.add(1);
         System.out.println("maxSubArraySum ->" + findMaxSubarraySum(al.size(), 12, al));
         System.out.println("maxSubArraySum -->" + findMaxSubarraySum(al2.size(), 1, al2));
         System.out.println("maxSubArraySum -->" + findMaxSubarraySum(al3.size(), 75, al3));
         System.out.println("maxSubArraySum -->" + findMaxSubarraySum(al4.size(), 78, al4));
         System.out.println("maxSubArraySum -->" + findMaxSubarraySum(al5.size(), 11, al5));

//        int[] a = {2, 1, 3, 4, 5,13};
//
//        int[] b = {2, 2,2};
//        System.out.println("maxSubArraySum ->"+maxSubArraySum(a,12));
//        System.out.println("maxSubArraySum -->"+maxSubArraySum(b, 1));
    }
}
