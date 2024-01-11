package intermediate.oct_31;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseArray {
    // Running program
    private static ArrayList<Integer> reverseArrayWithRange(ArrayList<Integer> A, int B, int C) {
        // Collections.reverseOrder();
        System.out.println("");
        A.forEach(
                (temp) -> System.out.print(" " + temp));
        System.out.println(" B===>" + B + " C===>" + C);
        int[] array = A.stream().mapToInt(id -> id).toArray();
        for (; B <= C; B++, C--) {
            int aux = array[B];
            array[B] = array[C];
            array[C] = aux;
        }
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(array).boxed().collect(Collectors.toList());
        return list;
    }

    // Option B is here for Reverse Array With Range
//    Time Limit Exceeded
//    Your submission didn't complete in the allocated time limit.
//    Your submission failed for the following input
    private static ArrayList<Integer> reverseArrayWithRange2(ArrayList<Integer> A, int B, int C) {
        // Arraylist for storing reversed elements
        LinkedList<Integer> revArrayList = new LinkedList<Integer>(A);
        for (; B <= C; B++, C--) {
            revArrayList.set(B, A.get(C));
            System.out.println("A.get(B)===>"+A.get(B));
            revArrayList.set(C, A.get(B));
            System.out.println("A.get(C)===>"+A.get(C));
        }
        return new ArrayList<>(revArrayList);
    }

    private static ArrayList<Integer> reverseArrayWithRangeSubmitted(ArrayList<Integer> A, int B, int C) {
        for (; B <= C; B++, C--) {
            int temp = A.get(B);
            A.set(B, A.get(C));
            A.set(C, temp);
        }
        return A;
    }

    private static void swap(LinkedList<Integer> list,
                             int ele1, int ele2, int index1, int index2) {
        System.out.println(ele1 + "<---ele1   ele2-->" + ele2);
        System.out.println("\n before linkedlist-->" + list);
        // Getting the positions of the elements
        // int index1 = list.indexOf(ele1);
        // int index2 = list.indexOf(ele2);

        // Returning if the element is not present in the
        // LinkedList
//        if (index1 == -1 || index2 == -1) {
//            return;
//        }

        // Swapping the elements
        list.set(index1, ele2);
        list.set(index2, ele1);
        System.out.println("\n after linkedlist-->" + list);
    }

    private static void solveNew(int[] A, int B, int C) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }

        for (; B <= C; B++, C--) {
            int aux = A[B];
            A[B] = A[C];
            A[C] = aux;
        }
        System.out.println("");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i]);
        }

    }

    // Reverse Constant Array
    private static ArrayList<Integer> reverseConstantArray(List<Integer> A, int B, int C) {
        ArrayList<Integer> tmpList = new ArrayList<>(A);
        Collections.reverse(tmpList);
        // ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(array).boxed().collect(Collectors.toList());
        return tmpList;
    }

    public static void main(String[] args) {
//        A : [ 6, 7, 10, 3, 10, 10, 3, 10 ]
//        B : 0
//        C : 4
//        10 3 10 7 6 10 3 10
        List<Integer> aList = new ArrayList<>();
        aList.add(6);
        aList.add(7);
        aList.add(10);
        aList.add(3);
        aList.add(10);
        aList.add(10);
        aList.add(3);
        aList.add(10);


//        List<Integer> aList = new ArrayList<>();
//        aList.add(1);
//        aList.add(2);
//        aList.add(3);
//        aList.add(4);
//
//        List<Integer> aqList = new ArrayList<>();
//        aqList.add(2);
//        aqList.add(5);
//        aqList.add(6);

        // aList.add(5);

        // System.out.println("  " + c.solve((ArrayList<Integer>) aList));
//        solveNew(a,2, 3 );
//        System.out.println("");
//        solveNew(aa,0, 2 );
        List<Integer> myList = reverseArrayWithRange((ArrayList<Integer>) aList, 0, 4);
        myList.stream().forEach(
                (temp) -> System.out.print(" " + temp));
        System.out.println("");


        System.out.println(" \n Option B is here for Reverse Array With Range");
        List<Integer> myList11 = reverseArrayWithRangeSubmitted((ArrayList<Integer>) aList, 0, 4);
        myList11.stream().forEach(
                (temp) -> System.out.print(" " + temp));


//        List<Integer> myList1 = reverseConstantArray((ArrayList<Integer>) aqList, 0, 2);
//        myList1.forEach(
//                (temp) -> System.out.print(temp));
        // int[] b = IntStream.rangeClosed(4, a.length).map(i -> a[a.length-i]).toArray();
        //System.out.println(b);


//        System.out.println("");
//        for (int i=0;i<b.length;i++){
//            System.out.print(b[i]);
//        }

    }
}
