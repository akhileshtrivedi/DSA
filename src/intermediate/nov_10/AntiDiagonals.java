package intermediate.nov_10;

import java.util.ArrayList;

public class AntiDiagonals {

    // function to print the diagonals
    void diagonal(int A[][])
    {

        int N = A.length;

        // For each column start row is 0
        for (int col = 0; col < N; col++) {

            int startcol = col, startrow = 0;

            int countZero=0;
            while (startcol >= 0 && startrow < N) {
                countZero++;
                System.out.println(startcol+"<---startcol0- startrow--->"+startrow);
                System.out.print(A[startrow][startcol]
                        + " ");

                startcol--;

                startrow++;
            }
            System.out.println(""+countZero);
            System.out.println();
        }

        // For each row start column is N-1
      /*  for (int row = 1; row < N; row++) {
            int startrow = row, startcol = N - 1;

            while (startrow < N && startcol >= 0) {
                System.out.print(A[startrow][startcol]
                        + " ");

                startcol--;

                startrow++;
            }
            System.out.println();
        }*/
    }

    static void diagonalArrayList(int[][] A)
    {
        int n = A.length;
        int N = 2 * n - 1;

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < N; i++)
            result.add(new ArrayList<>());

        // Push each element in the result vector
        for(int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result.get(i + j).add(A[i][j]);

        for(int i = 0; i < result.size(); i++) {
            int len = result.get(i).size();
              for (int j = len ; j < n; j++) {
                  result.get(i).add(0);
            }
        }


        // Print the diagonals
        for(int i = 0; i < result.size(); i++)
        {
            System.out.println();
            for(int j = 0; j < result.get(i).size(); j++)
                System.out.print(result.get(i).get(j) + " ");
        }
    }


    // Driver code
    public static void main(String args[])
    {

        // matrix initialisation
        int A[][]
                = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int AA[][]
                = { { 1, 2 }, { 3, 4} };
        diagonalArrayList(A);
       // AntiDiagonals m = new AntiDiagonals();

       // m.diagonal(A);
    }
}
