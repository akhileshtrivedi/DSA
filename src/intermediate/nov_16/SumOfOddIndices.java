package intermediate.nov_16;

import java.util.ArrayList;
import java.util.Arrays;

class SumOfOddIndices {

    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList sumOfOddIndices = new ArrayList();
        for (int i = 0; i < B.size(); i++) {
            int start_index = B.get(i).get(0);
            int end_index = B.get(i).get(1);
            int sum = 0;
            for (int j = start_index; j <= end_index; j++) {
                if (j% 2 == 1) {
                    sum = sum + A.get(j);
                }
            }
            sumOfOddIndices.add(sum);
        }
        return sumOfOddIndices;
    }

    private static ArrayList<Integer> solveNew(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> sumOfOddIndices = new ArrayList();
        ArrayList<Integer> PFo = new ArrayList();
        PFo.add(0);

        for (int i = 1; i <A.size(); i++) {
            if (i% 2 == 1) {
                PFo.add(PFo.get(i-1)+A.get(i));
            }else{
                PFo.add(PFo.get(i-1));
            }
        }

        for (int i = 0; i < B.size(); i++) {
            int start_index = B.get(i).get(0);
            int end_index = B.get(i).get(1);
            if(start_index==0){
                sumOfOddIndices.add(PFo.get(end_index)) ;
            }else{
                sumOfOddIndices.add(PFo.get(end_index)-PFo.get(start_index-1)) ;
            }
        }

        return sumOfOddIndices;
    }

    public static void main(String[] args) {
        ArrayList result = new ArrayList(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        ArrayList q1 = new ArrayList(Arrays.asList(0, 2));
        ArrayList q2 = new ArrayList(Arrays.asList(1, 4));
        B.add(q1);
        B.add(q2);
        ArrayList result2 = new ArrayList(Arrays.asList(2, 1, 8, 3, 9));
        ArrayList<ArrayList<Integer>> B2 = new ArrayList<ArrayList<Integer>>();
        ArrayList qq1 = new ArrayList(Arrays.asList(0, 3));
        ArrayList qq2 = new ArrayList(Arrays.asList(2, 4));
        B2.add(qq1);
        B2.add(qq2);
        System.out.println("solve-->" + solveNew(result, B));
        System.out.println("solve-->" + solveNew(result2, B2));
    }
}

// This code is contributed by vt_m.
