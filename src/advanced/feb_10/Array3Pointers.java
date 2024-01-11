package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array3Pointers {

  private static int checkMax(int a, int b, int c){
    int max = a;
    if(max < b){
      max = b;
    }
    if(max < c){
      max = c;
    }

    return max;
  }
  private static int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
    int i = 0, j = 0, k = 0;
    int ans = Integer.MAX_VALUE;
    int temp, temp1, temp2, temp3;

    while(i < A.size() || j < B.size() || k < C.size()){
      ans = Math.min(ans, checkMax(Math.abs(A.get(i) - B.get(j)), Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i))));
     // sol =      min(sol, checkMax(abs(           A[i] - B[j]),            abs(B[j] - C[k]), abs(C[k] - A[i])));
      if(i+1 < A.size()){
        temp1 = checkMax(Math.abs(A.get(i+1) - B.get(j)), Math.abs(B.get(j) - C.get(k)), Math.abs(C.get(k) - A.get(i+1)));
      }
      else{
        temp1 = Integer.MAX_VALUE;
      }
      if(j+1 < B.size()){
        temp2 = checkMax(Math.abs(A.get(i) - B.get(j+1)), Math.abs(B.get(j+1) - C.get(k)), Math.abs(C.get(k) - A.get(i)));
      }
      else{
        temp2 = Integer.MAX_VALUE;
      }
      if(k+1 < C.size()){
        temp3 = checkMax(Math.abs(A.get(i) - B.get(j)), Math.abs(B.get(j) - C.get(k+1)), Math.abs(C.get(k+1) - A.get(i)));
      }
      else{
        temp3 = Integer.MAX_VALUE;
      }

      temp = Math.min(temp1, temp2);
      temp = Math.min(temp, temp3);

      if(temp == Integer.MAX_VALUE){
        return ans;
      }
      else if(temp == temp1){
        i++;
      }
      else if(temp == temp2){
        j++;
      }
      else{
        k++;
      }

    }
    return ans;
  }
  public static void main(String[] args) {
List<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 10));
List<Integer> B = new ArrayList<>(Arrays.asList(2, 15, 20));
List<Integer> C = new ArrayList<>(Arrays.asList(10, 12));
    System.out.println(""+minimize(A,B,C));
  }

}
