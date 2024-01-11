package advanced.april_19;

public class CuttingARod {


  public static int cutRod(int prices[])
  {
    int n = prices.length;
    int mat[][] = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          mat[i][j] = 0;
        }
        else {
          if (i == 1) {
            mat[i][j] = j * prices[i - 1];
          }
          else {
            if (i > j) {
              mat[i][j] = mat[i - 1][j];
            }
            else {
              mat[i][j] = Math.max(
                  prices[i - 1]
                      + mat[i][j - i],
                  mat[i - 1][j]);
            }
          }
        }
      }
    }

    return mat[n][n];
  }
  public static void main(String[] args)
  {

    int prices[]
        = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };


    System.out.println("Maximum obtained value is "
        + cutRod(prices));
  }
}
