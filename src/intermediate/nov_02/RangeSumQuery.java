package intermediate.nov_02;

import java.util.ArrayList;

public class RangeSumQuery {
    private static int rangeSumPF(int[] arr, int[] Q) {

        int count = 0;
        int pfArr[] = new int[arr.length];
        pfArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                pfArr[i] = pfArr[i - 1] + arr[i];
            }
        }

        int L = Q[0] - 1;
        int R = Q[1] - 1;

        if (L == 0) {
            count = pfArr[R];
        } else {
            count = pfArr[R] - pfArr[L - 1];

        }
        return count;
    }

    //  TestCase - Hard Failed
//    Time Limit Exceeded
//    Your submission didn't complete in the allocated time limit.
//    Your submission failed for the following input
    public static ArrayList<Long> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> prefixSum = new ArrayList<>(A.size());
        prefixSum.add(Long.valueOf(A.get(0)));

        for (int i = 1; i < A.size(); i++) {
            prefixSum.add(Long.valueOf(prefixSum.get(i-1) + A.get(i)));
        }
        System.out.println("prefixSum-->"+prefixSum);
        ArrayList<Long> rangSum = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            // System.out.println(B);
            ArrayList<Integer> range = B.get(i);
            int left = range.get(0) -1 ;
            int right = range.get(1) -1 ;
            System.out.println(left+"  "+right);
            long count = 0;
            if (left == 0) {
                count = prefixSum.get(right);
            } else {
                count = prefixSum.get(right)- prefixSum.get(left-1);
            }
            System.out.println(count);
            rangSum.add(count);
        }
        return rangSum;
    }

    public static void main(String[] args) {


//        A = [1, 2, 3, 4, 5]
//        B = [[1, 4], [2, 3]]
        // int myArr[] = {2, 4, 5, 6, 7, 8};
        int myArr[] = {1, 2, 3, 4, 5};
        int myArr2[] = {2, 2, 2};

//        A : [ 7, 3, 1, 5, 5, 5, 1, 2, 4, 5 ]
//        B :
//[
//  [7, 10]
//  [3, 10]
//  [3, 5]
//  [1, 10]
//]
        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(7);
        aList.add(3);
        aList.add(1);
        aList.add(5);
        aList.add(5);
        aList.add(5);
        aList.add(1);
        aList.add(2);
        aList.add(4);
        aList.add(5);
        ArrayList<Integer> qList = new ArrayList<>();
        qList.add(7);
        qList.add(10);
        ArrayList<Integer> q2List = new ArrayList<>();
        q2List.add(3);
        q2List.add(10);
        ArrayList<Integer> q3List = new ArrayList<>();
        q3List.add(3);
        q3List.add(5);
        ArrayList<Integer> q4List = new ArrayList<>();
        q4List.add(1);
        q4List.add(10);

        ArrayList  q=  new ArrayList<>();
        q.add(qList);
        q.add(q2List);
        q.add(q3List);
        q.add(q4List);

        int Q[] = {1, 4};
        int Q2[] = {2, 3};
        int R[] = {1, 1};
        int R2[] = {2, 3};
       // System.out.println("rangeSumPF--> " + rangeSumPF(myArr, Q)); //10
       // System.out.println("rangeSumPF--> " + rangeSumPF(myArr, Q2)); //5

       // System.out.println("rangeSumPF--> " + rangeSumPF(myArr2, R)); //2
       // System.out.println("rangeSumPF--> " + rangeSumPF(myArr2, R2)); //4
//        System.out.println(q2List+"---"+qList);
//        System.out.println(aList+"---"+q);0 2 2 5
        System.out.println("rangeSumPF--> " + solve((ArrayList<Integer>) aList, q)); //12 28 11 38

    }
}
