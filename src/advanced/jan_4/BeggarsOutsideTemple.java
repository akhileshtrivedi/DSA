package advanced.jan_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BeggarsOutsideTemple {

  private static int[] solveOLD(int A, int[][] B) {

    // Queries - no of rows
    int[] output = new int[A];
    int rows = B.length;

    //System.out.println("rows : "+ rows);
    // update the queries
    for (int i = 0; i < rows; i++) {
      int L = B[i][0] - 1; // -1 coz 1 based indexing
      int R = B[i][1] - 1; // -1 coz 1 based indexing
      int data = B[i][2];
      //System.out.println("L : " + L + " R: " + R + " data :" + data);

      // keep updating values in the output until N-1
      if (R < A - 1) {
        output[L] += data;
        output[R + 1] -= data;
      } else { // for last index A-1 // only update L
        output[L] += data;
      }
      //System.out.println("Prefix Sum: " + Arrays.toString(output));
    }

    //output
    for (int i = 1; i < A; i++) // will start with 1 coz already covered 0 above
    {
      output[i] = output[i - 1] + output[i];
    }

    return output;
  }

  private static int[] solve(int A, int[][] B) {

    int[] result = new int[A + 1];

    for (int i = 0; i < B.length; i++) {
      System.out.println(" B[i][2]-->"+ B[i][2]);
      int amount = B[i][2];
      result[B[i][0] - 1] += amount;
      System.out.println("B[i][0] - 1 -->"+ (B[i][0] - 1));
      result[B[i][1]] -= amount;
      System.out.println("B[i][1]-->"+ (B[i][1]));
    }
    for (int i = 1; i < A; i++) {
      result[i] += result[i - 1];
    }
    System.out.println("---"+Arrays.toString(result));
    result = Arrays.copyOf(result, result.length - 1);
    return result;

  }

  private static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
    int size = A + 1;
    ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(size, 0));
    for (int i = 0; i < B.size(); i++) {
      int amount = B.get(i).get(2);
      int startIndex = (B.get(i).get(0)) - 1;
      int endIndex = (B.get(i).get(1));

      result.set(startIndex, amount + result.get(startIndex));
      result.set(endIndex, -amount + result.get(endIndex));

    }

    for (int j = 1; j < A; j++) {
      result.set(j, result.get(j) + result.get(j - 1));
    }
    result.remove(A);
    return result;
  }


  public static void main(String[] args) {
    int[][] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
    int A = 5;
    int[] resultHere = solve(A, B);
    System.out.println(" Arrays--->" + Arrays.toString(resultHere));
    ArrayList al = new ArrayList<>();
    al.add(new ArrayList<Integer>(Arrays.asList(1, 2, 10)));
    al.add(new ArrayList<Integer>(Arrays.asList(2, 3, 20)));
    al.add(new ArrayList<Integer>(Arrays.asList(2, 5, 25)));
    System.out.println("solve--->" + solve(5, al));

 /*   int [] result = new int [A+1];

    for(int i = 0; i < B.length; i++) {
      int amount = B[i][2];
      result[B[i][0] - 1] += amount;
      result[B[i][1]] -= amount;
    }
    for(int i = 1; i < A; i++) {
      result[i] += result[i - 1];
    }
    result = Arrays.copyOf(result, result.length-1);
    System.out.println(Arrays.toString(result));*/
  }

}
