package intermediate.nov_25;

import java.util.*;


class LargestNumberFormed {

    static String printLargestNew(final List<Integer> A) {
        System.out.println("A size()---" + A.size());
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer X, Integer Y) {
                String XY = Integer.toString(X) + Integer.toString(Y);
                String YX = Integer.toString(Y) + Integer.toString(X);
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator it = A.iterator();
        StringBuilder builder = new StringBuilder();
        while (it.hasNext()) {
            builder.append(it.next());
        }
        if (builder.charAt(0) == '0')
            return "0";

        return builder.toString();
    }

    static void printLargest(Vector<String> arr) {

        Collections.sort(arr, new Comparator<String>() {
            // A comparison function which is used by
            // sort() in printLargest()
            @Override
            public int compare(String X, String Y) {
                System.out.println(X + "X --- Y" + Y);
                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;
                System.out.println(XY + " XY---YX " + YX);
                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }

    // Driver code
    public static void main(String[] args) {
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0)); // "9534330"
        // ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9)); // "9534330"
        // ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 3, 9, 0));// "9320"
        // output should be 6054854654
       /* Vector<String> arr;
        arr = new Vector<>();

        // output should be 6054854654
        arr.add("3");
        arr.add("30");
        arr.add("5");
        arr.add("9");
        printLargest(arr); */
        System.out.println("Now-->" + printLargestNew(arr3));
        // System.out.println("Now-->" + printLargestNew(arr2));
        // printLargestNew(arr);
        // printLargestNew(arr2);
    }
}


