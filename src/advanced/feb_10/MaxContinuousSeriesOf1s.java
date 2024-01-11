package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOf1s {
  private static  ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
    int wL = 0, wR = 0;
    int nZero = 0;
    int bestWindowWidth = -1;
    ArrayList<Integer> result = new ArrayList<>();
    int start = 0, end = 0;
    while (wR < A.size())
    {
      if (nZero <= B){
        if (A.get(wR) == 0)
          ++nZero;
        ++wR;
      }
      if (nZero > B){
        if (A.get(wL) == 0) --nZero;
        ++wL;
      }
      if (wR - wL + 1 > bestWindowWidth){
        bestWindowWidth = wR - wL + 1;
        start = wL;
        end = wR;
      }
    }
    for (int i = start; i<end; ++i)
      result.add(i);
    return result;
  }

  public static void main(String[] args) {
ArrayList<Integer> input= new ArrayList<>(Arrays.asList(1, 1, 0 ,1 ,1 ,0, 0 ,1 ,1 ,1));
    System.out.println(""+maxone(input,1));
  }

}
