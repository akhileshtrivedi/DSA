package advanced.jan_18;

public class EnumeratingGCD {
  private static String solve(String A, String B) {
    if(A.equals(B)){
      return A;
    }
    else{
      return "1";
    }
  }
  public static void main(String[] args) {
    System.out.println(solve("3412", "3412"));
  }

}
