package advanced.jan_23;

public class ComputenCrm {
  static int power(int x, int y, int p) {
    int res = 1;
    x = x % p;
    while (y > 0) {
      if (y % 2 == 1) {
        res = (res * x) % p;
      }
      y = y >> 1; // y = y/2
      x = (x * x) % p;
    }
    return res;
  }

  static int modInverse(int n, int p) {
    return power(n, p - 2, p);
  }

  static int nCrModPFermat(int n, int r, int p) {
    if (n < r) {
      return 0;
    }
    // Base case
    if (r == 0) {
      return 1;
    }

    int[] fac = new int[n + 1];
    fac[0] = 1;

    for (int i = 1; i <= n; i++) {
      fac[i] = fac[i - 1] * i % p;
    }

    return (fac[n] * modInverse(fac[r], p)
        % p * modInverse(fac[n - r], p)
        % p)
        % p;
  }
  static int nCrModp(int n, int r, int p)
  {
    if (r > n - r)
      r = n - r;

    int C[] = new int[r + 1];

    C[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = Math.min(i, r); j > 0; j--)

        // nCj = (n-1)Cj + (n-1)C(j-1);
        C[j] = (C[j] + C[j - 1]) % p;
    }
    return C[r];
  }
  static long moduloMultiplication(long a, long b,
      long mod)
  {
    // Initialize result
    long res = 0;

    // Update a if it is more than
    // or equal to mod
    a %= mod;

    while (b > 0) {

      // If b is odd, add a with result
      if ((b & 1) != 0)
        res = (res + a) % mod;

      // Here we assume that doing 2*a
      // doesn't cause overflow
      a = (2 * a) % mod;
      b >>= 1; // b = b / 2
    }
    return res;
  }
  static long gcdExtended(long a, long b)
  {

    // Base Case
    if (a == 0) {
      x = 0;
      y = 1;
      return b;
    }

    // To store results of recursive call
    long gcd = gcdExtended(b % a, a);
    long x1 = x;
    long y1 = y;

    // Update x and y using results of recursive
    // call
    x = y1 - (b / a) * x1;
    y = x1;

    return gcd;
  }
  static long modInverse(long a, long m)
  {
    long g = gcdExtended(a, m);

    // Return -1 if b and m are not co-prime
    if (g != 1)
      return -1;

    // m is added to handle negative x
    return (x % m + m) % m;
  }

  static long modDivide(long a, long b, long m)
  {

    a = a % m;
    long inv = modInverse(b, m);
    if (inv == -1)
      return 0;
    else
      return (inv * a) % m;
  }

  static long nCr(long n, long r, long p)
  {

    // Edge Case which is not possible
    if (r > n)
      return 0;

    // Optimization for the cases when r is large
    if (r > n - r)
      r = n - r;

    // x stores the current result at
    long x = 1;

    // each iteration
    // Initialized to 1 as nC0 is always 1.
    for (long i = 1L; i <= r; i++) {

      // Formula derived for calculating result is
      // C(n,r-1)*(n-r+1)/r
      // Function calculates x*(n-i+1) % p.
      x = moduloMultiplication(x, (n + 1L - i), p);

      // Function calculates x/i % p.
      x = modDivide(x, i, p);
    }
    return x;
  }
  // Global Variables
  static long x, y;
  public static void main(String[] args) {
    int n = 38, r = 5, m = 81;
    //(n!/((n-r)!*r!))% m.
    //long ans = (factorial(n)% m / (factorial(n - r)% m * factorial(r)% m)) % m;
    //System.out.println("nCr % m-->" + ans);
    //System.out.println(""+factorial(1));
   // System.out.println("Value of nCr % p is " + nCrModp(n, r, m));
    System.out.println("Value of nCr % p is "
        + nCr(n, r, m));
  }

}
