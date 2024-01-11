package intermediate.nov_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingSort {


    static void countSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> A) {
//        Integer[] arr = new Integer[A.size()];
//        arr = A.toArray(arr);
  int len=A.size();
        int max = Collections.max(A);
        int min =Collections.min(A);
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[len];
        for (int i = 0; i < len; i++) {
            count[A.get(i) - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = len- 1; i >= 0; i--) {
            output[count[A.get(i) - min] - 1] = A.get(i);
            count[A.get(i) - min]--;
        }

        for (int i = 0; i < len; i++) {
            A.set(i, output[i]);
        }
       return A;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10};
        int[] A = {1, 3, 1};

        int[] AA = {4, 2, 1, 3};
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1, 3, 1))));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(4, 2, 1, 3))));
        // Function call
//        countSort(arr);
//        printArray(arr);
//        countSort(A);
//        printArray(A);
//        countSort(AA);
//        printArray(AA);
    }
}