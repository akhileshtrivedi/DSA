package advanced.jan_6;

import java.util.ArrayList;

class RowWithMaximumNumberOfOnes {

  //static int R = 4, C = 4;

  // Function that returns index of row
  // with maximum number of 1s.
  static int rowWithMax1s(int mat[][]) {
    // Initialize first row as row with max 1s
    int j, max_row_index = 0;
    int R=mat.length;
    int C=mat[0].length;
    j = C - 1;

    for (int i = 0; i < R; i++) {
      // Move left until a 0 is found
      while (j >= 0 && mat[i][j] == 1) {
        j = j - 1; // Update the index of leftmost 1
        // seen so far
        max_row_index = i; // Update max_row_index
      }
    }
    if (max_row_index == 0 && mat[0][C - 1] == 0) {
      return -1;
    }
    return max_row_index;
  }

  public int solve(ArrayList<ArrayList<Integer>> A) {
    int j, max_row_index = 0;
    int R=A.size();
    int C=A.get(0).size();
    j = C - 1;

    for (int i = 0; i < R; i++) {
      while (j >= 0 && A.get(i).get(j) == 1) {
        j = j - 1;
        max_row_index = i;
      }
    }
    if (max_row_index == 0 && A.get(0).get(C-1) == 0) {
      return -1;
    }
    return max_row_index;
  }

  // Driver Code
  public static void main(String[] args) {
    int mat[][] = {{0, 0, 0, 1},
        {0, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}};

    int mat2[][] = {{0, 1, 1},
        {0, 0, 1},
        {0, 1, 1}};

    int mat3[][] = {{0, 0, 0,0},
        {0, 1, 1,1}};
    ;
    System.out.println("Index of row with maximum 1s is " + rowWithMax1s(mat2));
    System.out.println("Index of row with maximum 1s is " + rowWithMax1s(mat3));
  }
}

// This code is contributed by 'Rishabh Chauhan'.
