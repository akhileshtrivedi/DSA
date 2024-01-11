package intermediate.nov_02;

import java.util.ArrayList;
import java.util.List;

public class PrefixSum {
    private static int solve(int arr[], int l, int r) {
        int sum = 0;
        for (; l <= r; l++) {
            sum = sum + arr[l];
        }

        return sum;
    }

    private static int[] getPSumArray(int arr[]) {
        int pSumArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                pSumArr[i] = arr[i];
            } else {
                pSumArr[i] = pSumArr[i - 1] + arr[i];
            }
        }
        return pSumArr;
    }

    private static ArrayList<Integer> getPSumArrayList(ArrayList<Integer> A) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {

            if (i == 0) {
                al.add(A.get(i));
            } else {
                al.add(al.get(i - 1) + A.get(i));
            }
        }
        return al;
    }

    private static int solveWithoutLoop(int arr[], int l, int r) {

        int sum = 0;
        if (l == 0) {
            return arr[r];
        } else {

            return arr[r] - arr[l - 1];
        }
    }

    public static void main(String[] args) {
        int arr[] = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
        List<Integer> aList = new ArrayList<>();
        aList.add(-3);
        aList.add(6);
        aList.add(2);
        aList.add(4);
        aList.add(5);
        aList.add(2);
        aList.add(8);
        aList.add(-9);
        aList.add(3);
        aList.add(1);
        System.out.println("Sum of L to R " + solve(arr, 5, 9));
//        int[] pSumArray = getPSumArray(arr);
////
////        for (int i = 0; i < pSumArray.length; i++) {
////            System.out.print(pSumArray[i] + " ");
////
////        }
        System.out.println("" + getPSumArrayList((ArrayList<Integer>) aList));
        //  System.out.println("\n Sum of L to R " + solveWithoutLoop(pSumArray, 5, 9));
    }
}
