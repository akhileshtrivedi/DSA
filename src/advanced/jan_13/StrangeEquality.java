package advanced.jan_13;

public class StrangeEquality {
  private static int solve(int A) {
    int X = 0 , idx = 0 ;
    for(int i = 30 ; i >=0 ; i--){
      if((A&(1<<i)) != 0){
        idx = i ;
        break ;
      }
    }
    for(int i = idx-1 ; i>=0 ; i--){
      if((A&(1<<i)) == 0)
        X += 1<<i ;
    }
    int Y = 1<<(idx+1) ;
    return Y^X ;
  }
  public static void main(String[] args) {
    System.out.println(solve(5));
    System.out.println(solve(2));
  }

}
