package advanced.jan_20;

public class FindIfTwoTectanglesOverlap {

  private static int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
    if(B>=H || F>=D)
      return 0;
    if(A>=G || E>=C)
      return 0;

    return 1;
  }

  public static void main(String[] args) {
   int A = 0,B = 0, C = 4 ,D = 4, E = 2, F = 2, G = 6, H = 6;
    System.out.println( ""+solve(A,  B,  C,  D,  E,  F,  G,  H));
  }

}
