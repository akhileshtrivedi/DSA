package advanced.jan_23;

// Java program to find the nCr%p
// based on optimal Dynamic
// Programming implementation and
// Pascal Triangle concepts

class ComputenCrp {


  static long x, y;

  static long gcdExtended(long a, long b) {
    if (a == 0) {
      x = 0;
      y = 1;
      return b;
    }
    long gcd = gcdExtended(b % a, a);
    long x1 = x;
    long y1 = y;
    x = y1 - (b / a) * x1;
    y = x1;
    return gcd;
  }

  static long modInverse(long a, long m) {
    long g = gcdExtended(a, m);
    if (g != 1) {
      return -1;
    }
    return (x % m + m) % m;
  }


  static int nCrModp(int n, int r, int p) {
    if (n == r && n == p && n == 1) {
      return 0;
    }
    if (r > n - r) {
      r = n - r;
    }
    int C[] = new int[r + 1];
    C[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = Math.min(i, r); j > 0; j--) {
        C[j] = (C[j] + C[j - 1]) % p;
      }
    }
    return C[r];
  }
  
  private static int solve(int A, int B, int C) {
    if (B == 0) {
      return 1;
    }
    long[] fact = new long[A + 1];
    fact[0] = 1;
    for (int i = 1; i <= A; i++) {
      fact[i] = fact[i - 1] * i % C;
    }
    long ncr = ((fact[A] * modInverse(fact[B], C) % C * modInverse(fact[A - B], C) % C) % C);
    return (int) ncr;
  }

  // Driver Code
  public static void main(String[] args) {
    long n = 5, r = 3, p = 1000000007;
    // System.out.println("Value of nCr % p is " + nCr(1, 1, 1));
    //  System.out.println("Value of nCr % p is " + nCr(911921, 190902, 1000000007));
    System.out.println("Value of nCr % p is " + solve(911921, 190902, 1000000007));
    System.out.println("Value of nCr % p is " + solve(5, 2, 13));
//873634993
    //System.out.println("Value of nCr % p is " + nCrModp(1, 1, 1));
    // System.out.println("Value of nCr % p is " + nCrModp(8802, 5310, 212297));
  }
}

// This code is contributed by phasing17
