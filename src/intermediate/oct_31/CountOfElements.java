package intermediate.oct_31;

import java.util.ArrayList;
import java.util.List;

public class CountOfElements {

    private int solveNewWay(int arr[]) {
        int max = arr[0];
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == max) {
                count++;
            } else if (arr[i] > max) {
                count = 0;
                max = arr[i];
            }
        }

        return len - count;
    }

    private int solveNewWay(ArrayList<Integer> A) {
        int max = A.get(0);
        int len = A.size();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (A.get(i) == max) {
                count++;
            } else if (A.get(i) > max) {
                count = 1;
                max = A.get(i);
            }
        }
        return len - count;
    }


    private int solve(ArrayList<Integer> A) {
        int second = 0;
        int len = A.size();
        int count = 0;
        for (int i = 0; i < len; i++) {

            if (A.get(i) > second) {
                second = A.get(i);
            }
        }
        for (int i = 0; i < len; i++) {
            // System.out.println(A.get(i)+" ----"+second);
            if (A.get(i) < second) {
                count++;
            }
        }
        return count;
    }

    private int solve(int arr[]) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {

            if (arr[i] > first) {
                second = first;
                first = arr[i];

            } else if (arr[i] > second) {
                second = arr[i];

            }
        }
        for (int i = 0; i < len; i++) {
            if (arr[i] < second) {
                count++;
            }
        }
        return count;
    }

    static void findElements(int arr[], int n) {

        int second = 0;

        for (int i = 0; i < n - 1; i++) {
            System.out.println(arr[i]);
            if (arr[i] > arr[i + 1]) {
                second = arr[i];
            } else {
                second = arr[i + 1];
            }
        }
        for (int i = 0; i < n; i++)
            if (arr[i] < second)
                System.out.println(arr[i] + " ");
    }

    public static void main(String[] args) {
        // int arr[] = {6, 3, 2, 1, 4, 5, 7};
        int arr[] = {7, 4, 2, 10, 5};
        //  A : [ 2, 9, 2, 4 ]
        List<Integer> aList = new ArrayList<>();
        aList.add(2);
        aList.add(9);
        aList.add(2);
        aList.add(4);
        // aList.add(5);

        CountOfElements c = new CountOfElements();
        System.out.println("  " + c.solve((ArrayList<Integer>) aList));
        System.out.println("  " + c.solveNewWay((ArrayList<Integer>) aList));
        //  findElements(arr, arr.length);

    }
}
