package advanced.jan_16;

import java.util.*;

class VeryLargePower
{

  static long MOD = (long) (1e9 + 7);

  static long powerLL(long x, long n)
  {
    long result = 1;
    while (n > 0)
    {
      if (n % 2 == 1)
      {
        result = result * x % MOD;
      }
      n = n / 2;
      x = x * x % MOD;
    }
    return result;
  }

  static long powerStrings(String sa, String sb)
  {
    // We convert strings to number
    long a = 0, b = 0;

    // calculating a % MOD
    for (int i = 0; i < sa.length(); i++)
    {
      a = (a * 10 + (sa.charAt(i) - '0')) %
          MOD;
    }

    // calculating b % (MOD - 1)
    for (int i = 0; i < sb.length(); i++)
    {
      b = (b * 10 + (sb.charAt(i) - '0')) %
          (MOD - 1);
    }

    // Now a and b are long long int. We
    // calculate a^b using modulo exponentiation
    return powerLL(a, b);
  }

  // Driver code
//  public static void main(String[] args)
//  {
//
//    // As numbers are very large
//    // that is it may contains upto
//    // 10^6 digits. So, we use string.
//   // String sa = "2", sb = "3";
//   // System.out.println(powerStrings(sa, sb));
//    System.out.println(powerLL(1, 1));
//    System.out.println(powerLL(2, 2));
//  }



  static final int MAX = 100000;

  static int multiply(int x, int res[], int res_size) {
    int carry = 0;
    for (int i = 0; i < res_size; i++) {
      int prod = res[i] * x + carry;

      res[i] = prod % 10;

      carry = prod / 10;
    }

    while (carry > 0) {
      res[res_size] = carry % 10;
      carry = carry / 10;
      res_size++;
    }
    return res_size;
  }

  static int power(int x, int n) {
    long ans=0;
    if(n == 0 ){
      return 1;
    }
    int res[] = new int[MAX];
    int res_size = 0;
    int temp = x;

    while (temp != 0) {
      res[res_size++] = temp % 10;
      temp = temp / 10;
    }

    for (int i = 2; i <= n; i++)

    ans=ans+multiply(x, res, res_size);
    ans=ans%MOD;
    return (int) ans;
  }

  public static void main(String[] args) {
    int exponent = 100;
    int base = 2;
    System.out.println(""+power(base, exponent));
  }
}

