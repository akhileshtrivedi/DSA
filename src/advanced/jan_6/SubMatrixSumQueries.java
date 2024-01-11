package advanced.jan_6;

class SubMatrixSumQueries {


  static int preProcess(int mat[][], int aux[][]) {
    int M = mat.length;
    int N = mat[0].length;
    System.out.println("MN" + mat[0].length);
    // Copy first row of mat[][] to aux[][]
    for (int i = 0; i < N; i++) {
      aux[0][i] = mat[0][i];
    }

    // Do column wise sum
    for (int i = 1; i < M; i++) {
      for (int j = 0; j < N; j++) {
        aux[i][j] = mat[i][j] +
            aux[i - 1][j];
      }
    }

    // Do row wise sum
    for (int i = 0; i < M; i++) {
      for (int j = 1; j < N; j++) {
        aux[i][j] += aux[i][j - 1];
      }
    }

    return 0;
  }

  static int sumQuery(int aux[][], int tli,
      int tlj, int rbi, int rbj) {

    int res = aux[rbi][rbj];

    if (tli > 0) {
      res = res - aux[tli - 1][rbj];
    }

    if (tlj > 0) {
      res = res - aux[rbi][tlj - 1];
    }

    if (tli > 0 && tlj > 0) {
      res = res + aux[tli - 1][tlj - 1];
    }

    return res;
  }

  // Driver code
  public static void main(String[] args) {
    int mat[][] = {{1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}};
    int[] B = {1, 2};
    int[] C = {1, 2};
    int[] D = {2, 3};
    int[] E = {2, 3};

  /*  int mat[][] = {{1, 2, 3, 4, 6},
        {5, 3, 8, 1, 2},
        {4, 6, 7, 5, 5},
        {2, 4, 8, 9, 4}};*/

    int M = mat.length;
    int N = mat[0].length;

    int aux[][] = new int[M][N];

    preProcess(mat, aux);

    int tli = 2, tlj = 2, rbi = 3, rbj = 4;
    System.out.print("\nQuery1: "
        + sumQuery(aux, tli, tlj, rbi, rbj));

    tli = 0;
    tlj = 0;
    rbi = 1;
    rbj = 1;
    System.out.print("\nQuery2: "
        + sumQuery(aux, tli, tlj, rbi, rbj));

    tli = 1;
    tlj = 2;
    rbi = 3;
    rbj = 3;
    System.out.print("\nQuery3: "
        + sumQuery(aux, tli, tlj, rbi, rbj));
  }
}


