package advanced.jan_16;

public class PrimeModuloInverse {

  public static int solve(int A, int B) {
    for (int X = 1; X < B; X++) {
      if (((A % B) * (X % B) % B) == 1) {
        return X;
      }
    }

    return 1;
  }
  static int modInverse(int A, int M)
  {
    int g = gcd(A, M);
    if (g != 1)
      System.out.println("Inverse doesn't exist");
    else {
      // If a and m are relatively prime, then modulo
      // inverse is a^(m-2) mode m
      return power(A, M - 2, M);
    }
    return 1;
  }

  static int power(int x, int y, int M)
  {
    if (y == 0)
      return 1;
    int p = power(x, y / 2, M) % M;
    p = (int)((p * (long)p) % M);
    if (y % 2 == 0)
      return p;
    else
      return (int)((x * (long)p) % M);
  }

  // Function to return gcd of a and b
  static int gcd(int a, int b)
  {
    if (a == 0)
      return b;
    return gcd(b % a, a);
  }
  public static void main(String args[])
  {
    int A = 3, M = 11;

    // Function call
    System.out.println(modInverse(A, M));
  }
}
