package intermediate.nov12;

import java.util.ArrayList;
import java.util.Arrays;

public class Homework {
    private static int getSubarrayWithLeastAverageFinal(ArrayList<Integer> A, int B) {
        int minIndex = 0;

        int k = B;

        int s = 1, e = k;
        ArrayList<Float> al = new ArrayList();
        while (e <= A.size()) {
            float avg = 0;
            int sum = 0;
            for (int i = s - 1; i < e; i++) {
                sum = sum + A.get(i);
            }

            avg = (float)sum / k;
            al.add(avg);

            s++;
            e++;
        }
        float minimum = al.get(0);
        for (int i = 1; i < al.size(); i++) {
            if (minimum > al.get(i)) {
                minimum = al.get(i);
                minIndex = i;
            }
        }

        return minIndex;
    }


    private static int getSubarrayWithLeastAverage(ArrayList<Integer> A, int B) {
        int minIndex = 0;

        int k = B;

        // for(int i=0;i<A.size();i++){
        int s = 1, e = k;
        ArrayList<Float> al = new ArrayList();
        while (e <= A.size()) {
            float avg = 0;
            System.out.println("Starting index" + s + " Ending index " + e);
            int sum = 0;
            for (int i = s - 1; i < e; i++) {
                sum = sum + A.get(i);
            }
            System.out.println("sum---" + sum);
            avg = (float)sum / k;
            al.add(avg);
            System.out.println("Avg index" + avg);
//                if (A.get(s - 1) > B) {
//                    count--;
//                }
//                if (A.get(e) > B) {
//                    count++;
//                }
            s++;
            e++;
//                if(count<omin){
//                    omin= count;
//                }
        }
        float minimum = al.get(0);
        for (int i = 1; i < al.size(); i++) {
            if (minimum > al.get(i)) {
                minimum = al.get(i);
                minIndex = i;
            }
        }
        System.out.println("minimum-->" + minIndex);
        //  }

        return minIndex;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(3, 7, 90, 20, 10, 50, 40));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(3, 7, 5, 20, -10, 0, 12));
        ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(15, 7, 11, 7, 9, 8, 18, 1, 16, 18, 6, 1, 1, 4, 18));
        ArrayList<Integer> al4 = new ArrayList<>(Arrays.asList(20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11));
        ArrayList<Integer> al5 = new ArrayList<>(Arrays.asList(5, 15, 7, 6, 3, 4, 18, 14, 13, 7, 3, 7, 2, 18));
                                                               // 20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11
        System.out.println("getSubarrayWithLeastAverage==>" + getSubarrayWithLeastAverageFinal(al, 3));
        System.out.println("getSubarrayWithLeastAverage--->" + getSubarrayWithLeastAverageFinal(al2, 2));
        System.out.println("getSubarrayWithLeastAverage--->" + getSubarrayWithLeastAverageFinal(al3, 6));
        System.out.println("getSubarrayWithLeastAverage--->" + getSubarrayWithLeastAverageFinal(al4, 9));
        System.out.println("getSubarrayWithLeastAverage--->" + getSubarrayWithLeastAverageFinal(al5, 6));
    }
}
