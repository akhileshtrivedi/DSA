package advanced.feb_03;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixMedian {

  static int binaryMedian(int m[][], int r, int c) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < r; i++) {
      if (m[i][0] < min) {
        min = m[i][0];
      }

      if (m[i][0] > max) {
        max = m[i][0];
      }
    }

    int desired = (r * c + 1) / 2;
    while (min < max) {
      int mid = min + (max - min) / 2;
      int place = 0;
      int get = 0;
      for (int i = 0; i < r; ++i) {
        get = Arrays.binarySearch(m[i], mid);
        if (get < 0) {
          get = Math.abs(get) - 1;
        } else {
          while (get < m[i].length
              && m[i][get] == mid) {
            get += 1;
          }
        }

        place = place + get;
      }

      if (place < desired) {
        min = mid + 1;
      } else {
        max = mid;
      }
    }
    return min;
  }
  public static int upper_bound(ArrayList<Integer> ar,int k)
  {
    int s=0;
    int e=ar.size();
    while (s !=e)
    {
      int mid = s+e>>1;
      if (ar.get(mid) <=k)
      {
        s=mid+1;
      }
      else
      {
        e=mid;
      }
    }
    if(s==ar.size())
    {
      return -1;
    }
    return s;
  }
  private static int binarySearch(int[][] matrix, int r, int low, int high, int requiredIndx) {
    if(high > low) {
      int mid =(high + low) / 2, currentIndx = 0;
      for(int i = 0; i < r; i++) {
        // to compute count of numbers less than mid in each row
        int temp = 0;
        temp = Arrays.binarySearch(matrix[i], mid);
        if(temp < 0) {
          temp = Math.abs(temp) - 1;
        } else {
          while(temp < matrix[i].length && matrix[i][temp] <= mid) {
            temp += 1;
          }
        }
        currentIndx += temp;
      }
      if(currentIndx < requiredIndx) {
        return binarySearch(matrix, r, mid + 1, high, requiredIndx);
      } else {
        return binarySearch(matrix, r, low, mid, requiredIndx);
      }
    }
    return low;
  }
  private static int calculateMedianOfMatrix(int[][] matrix) {
    int rowSize = matrix.length, columnSize = matrix[0].length;
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
    for(int i = 0; i < rowSize; i++) {
      if(matrix[i][0] < low) {
        low = matrix[i][0];
      }
      if(matrix[i][columnSize - 1] > high) {
        high = matrix [i][columnSize - 1];
      }
    }
    int requiredIndx =(rowSize * columnSize + 1) / 2;
    return binarySearch(matrix, rowSize, low, high, requiredIndx);
  }

  public static void main(String[] args) {
    int r = 3, c = 3;
    int m[][]
        = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
   // System.out.println("Median is " + binaryMedian(m, r, c));
    System.out.println("Median is " + calculateMedianOfMatrix(m));
  }
}

