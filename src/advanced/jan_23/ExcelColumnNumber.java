package advanced.jan_23;

public class ExcelColumnNumber {
  private static int titleToNumber(String A) {
    // This process is similar to
    // binary-to-decimal conversion
    int result = 0;
    for (int i = 0; i < A.length(); i++)
    {
      result *= 26;
      System.out.println("result 1-->"+result);
      result += A.charAt(i) - 'A' + 1;
      System.out.println("result 2-->"+result);
    }
    return result;
  }


  public static void main(String[] args) {
    System.out.println(""+titleToNumber("A"));
  //  System.out.println(""+titleToNumber("AA"));
   // System.out.println(""+titleToNumber("BB"));
  }
}
