package advanced.jan_9;

public class NumberOfDigitOne {
  static int countDigitOne(int n)
  {
//    int countr = 0;
//    for (int i = 1; i <= n; i *= 10)
//    {
//      int divider = i * 10;
//      countr += (n / divider) * i +
//          Math.min(Math.max(n %
//              divider - i +
//              1, 0), i);
//    }
//    return countr;

    int countr = 0;
    for (int i = 1; i <= n; i++)
    {
      String str = String.valueOf(i);
      countr += str.split("1", -1) . length - 1;
    }
    return countr;
  }

  // Driver Code
  public static void main (String[] args)
  {
    int n = 13;
    System.out.println(countDigitOne(n));

    n = 113;
  //  System.out.println(countDigitOne(n));

    n = 205;
  //  System.out.println(countDigitOne(n));
  }

}
