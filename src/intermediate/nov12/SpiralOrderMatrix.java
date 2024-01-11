package intermediate.nov12;

import java.util.ArrayList;

public class SpiralOrderMatrix {
    private static int getPrintBoundary(ArrayList<ArrayList<Integer>> at, int N, int i, int j, int lastNum) {
        int num = lastNum;
        for (int k = 1; k <= N - 1; k++) {
            at.get(i).set(j, num);
            num++;
            j++;
        }
        for (int k = 1; k <= N - 1; k++) {
            at.get(i).set(j, num);
            i++;
            num++;
        }
        for (int k = 1; k <= N - 1; k++) {
            at.get(i).set(j, num);
            j--;
            num++;
        }
        for (int k = 1; k <= N - 1; k++) {
            at.get(i).set(j, num);
            i--;
            num++;
        }
        return num;
    }

    private static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        if (A > 0) {
            int element = 1;
            for (int i = 0; i < A; i++) {
                ArrayList<Integer> col = new ArrayList<>();
                for (int j = 0; j < A; j++) {
                    col.add(element);
                    element++;
                }
                al.add(col);
            }
        }
        int i = 0, j = 0;
        int lastNum = 1;
        while (A > 1) {
            lastNum = getPrintBoundary(al, A, i, j, lastNum);
            i++;
            j++;
            A -= 2;
        }
        if (A == 1) {
            al.get(al.size() / 2).set(al.size() / 2, lastNum);
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println("Final list-->" + generateMatrix(1));
        System.out.println("Final list-->" + generateMatrix(2));
        System.out.println("Final list-->" + generateMatrix(5));

    }
}
