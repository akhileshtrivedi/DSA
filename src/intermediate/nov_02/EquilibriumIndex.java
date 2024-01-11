package intermediate.nov_02;

import java.util.ArrayList;

public class EquilibriumIndex {
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

    private static int[] getPSumArray2(int arr[]) {
        int pSumArr[] = new int[arr.length];
        System.out.println(" ");
        for (int i = arr.length - 1, j = 0; i >= 0; i--, j++) {
            // System.out.print(" "+ arr[i]);
            if (j == 0) {
                pSumArr[j] = arr[i];
            } else {
                pSumArr[j] = pSumArr[j - 1] + arr[i];
            }
        }
        return pSumArr;
    }

    private static int[] getEquilibriumIndex(int arr[]) {
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

    private static int normalWay(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum = leftSum + arr[j];
            }

            int rightSum = 0;
            for (int k = i + 1; k < arr.length; k++) {
                rightSum = rightSum + arr[k];
            }
            if (leftSum == rightSum) {

                count++;
            }

        }

        return count == 0 ? -1 : count;
    }


    private static int optimizedWay(int arr[]) {

        int pSumArr[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                pSumArr[i] = arr[i];
            } else {
                pSumArr[i] = pSumArr[i - 1] + arr[i];
            }
        }

        for (int j = 0; j < pSumArr.length; j++) {
            int size = pSumArr.length;
            int leftSum = 0;
            int rightSum = 0;
//            if (j != 0) {
//                leftSum = pSumArr[j - 1];
//                rightSum = pSumArr[size - 1] - pSumArr[j];
//
//            } else if (j == 0) {
//                leftSum = 0;
//                rightSum = pSumArr[size - 1] - pSumArr[j];
//            }
            if (j != 0) {
                leftSum = pSumArr[j - 1];
            }
            rightSum = pSumArr[size - 1] - pSumArr[j];

            if (leftSum == rightSum) {
                System.out.println(j + " leftSum-->" + leftSum + " rightSum--" + rightSum);
                return j;
                //  count++;
            }
        }
        return -1;
    }


    private static int countEvenNumberPF(int[] arr, int[] Q) {
        int count = 0;
        int pfArr[] = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            if (arr[0] % 2 == 0) {
                pfArr[0] = 1;
            } else {
                pfArr[0] = 0;
            }

            if (arr[i] % 2 == 0) {
                pfArr[i] = pfArr[i - 1] + 1;
            } else {
                pfArr[i] = pfArr[i - 1] + 0;
            }
        }
        System.out.println(" ");
        for (int i = 0; i < pfArr.length; i++) {
            System.out.print(pfArr[i] + " ");
        }
        System.out.println(" ");
        int L = Q[0];
        int R = Q[1];
        for (int i = 0; i < Q.length; i++) {
            if (L == 0) {
                count = pfArr[R];

            } else {
                count = pfArr[R] - pfArr[L - 1];

            }


        }
        return count;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int count = 0;
        int pfArr[] = new int[A.size()];
        for (int i = 1; i < A.size(); i++) {
            if (A.get(0) % 2 == 0) {
                pfArr[0] = 1;
            } else {
                pfArr[0] = 0;
            }

            if (A.get(i) % 2 == 0) {
                pfArr[i] = pfArr[i - 1] + 1;
            } else {
                pfArr[i] = pfArr[i - 1] + 0;
            }
        }
        System.out.println(" ");
        for (int i = 0; i < pfArr.length; i++) {
            System.out.print(pfArr[i] + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> col = B.get(i);
            int L = col.get(0);
            int R = col.get(1);

            if (L == 0) {
                count = pfArr[R];

            } else {
                count = pfArr[R] - pfArr[L - 1];
            }
            al.add(count);
        }
        return al;
    }

    public static void main(String[] args) {
        // int myArr[] = {2, 4, 5, 6, 7, 8};
        int myArr[] = {1, 2, 3, 4, 5};
        int Q[] = {0, 2};
        int Q2[] = {1, 4};
        System.out.println("countEvenNumberPF--> " + countEvenNumberPF(myArr, Q));
        System.out.println("countEvenNumberPF--> " + countEvenNumberPF(myArr, Q2));


        // A : [ 1, 2, 3, 7, 1, 2, 3 ]
        int A[] = {1, 2, 3, 7, 1, 2, 3};  //3
        int AA[] = {1, 2, 3};  //3
        int arr[] = {-7, 1, 5, 2, -4, 3, 0};
//
        int[] pSumArray = getPSumArray(arr);

        for (int i = 0; i < pSumArray.length; i++) {
            System.out.print(pSumArray[i] + " ");
        }
//
//        int[] pSumArray2 = getPSumArray2(arr);
//
//        for (int i = 0; i < pSumArray2.length; i++) {
//            System.out.print(" " + pSumArray2[i]);
//        }
        System.out.println("Total EquilibriumIndex is " + normalWay(A));
        System.out.println("Total EquilibriumIndex is " + optimizedWay(A));
//        for (int i=0; i< arr.length;i++){
//
//        }
    }
}
