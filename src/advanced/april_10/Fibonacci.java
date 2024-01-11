package advanced.april_10;

import java.util.Scanner;

public class Fibonacci
{
  static int fib(int n)
  {
    int f[] = new int[n+2];
    int i;

    f[0] = 0;
    f[1] = 1;

    for (i = 2; i <= n; i++)
    {
      f[i] = f[i-1] + f[i-2];
    }

    return f[n];
  }

  static int fib2(int n) {

    int a = 0;
    int b = 1;
    int c = 0;
    if (n <= 0) {
      return n;
    }
    for (int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }

    return c;
  }


  public static void main (String args[])
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(fib2(n));
  }
};

