package intermediate.nov_04;

import java.util.ArrayList;

public class ClosestMinMax {
    public static int solve(ArrayList<Integer> A) {

        int minValue = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) < minValue) {
                minValue = A.get(i);
            }
        }

        int maxValue = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > maxValue) {
                maxValue = A.get(i);
            }
        }

        int pos_min = -1, pos_max = -1, result = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == minValue) {
                pos_min = i;
            }
            if (A.get(i) == maxValue) {
                pos_max = i;
            }

            if (pos_min != -1 && pos_max != -1) {
                result = Math.min(result, Math.abs(pos_min - pos_max) + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        al.add(1);
        al.add(3);
        al2.add(2);
        System.out.println("I am here" + solve(al));
        System.out.println("I am here" + solve(al2));
    }
}
