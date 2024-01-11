package advanced.jan_20;

import java.util.ArrayList;

public class PrimeSum {


  static boolean SieveOfEratosthenes(int n, boolean isPrime[])
  {
    // Initialize all entries of boolean array as true.
    // A value in isPrime[i] will finally be false if i
    // is Not a prime, else true bool isPrime[n+1];
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i <= n; i++)
      isPrime[i] = true;

    for (int p = 2; p * p <= n; p++) {
      // If isPrime[p] is not changed, then it is a
      // prime
      if (isPrime[p] == true) {
        // Update all multiples of p
        for (int i = p * p; i <= n; i += p)
          isPrime[i] = false;
      }
    }
    return false;
  }

  // Prints a prime pair with given sum
  static void findPrimePair(int n)
  {
    // Generating primes using Sieve
    boolean isPrime[] = new boolean[n + 1];
    SieveOfEratosthenes(n, isPrime);

    // Traversing all numbers to find first pair
    for (int i = 0; i < n; i++) {
      if (isPrime[i] && isPrime[n - i]) {
        System.out.print(i + " here " + (n - i));
        return;
      }
    }
  }

  private static ArrayList<Integer> primesum(int A) {
    ArrayList<Integer> result =new ArrayList<Integer>();
    // Generating primes using Sieve
    boolean isPrime[] = new boolean[A + 1];
    SieveOfEratosthenes(A, isPrime);

    // Traversing all numbers to find first pair
    for (int i = 0; i < A; i++) {
      if (isPrime[i] && isPrime[A - i]) {
        result.add(i);
        result.add(A-i);
        return result;
      }
    }
    return result;
  }
  public static void main(String[] args)
  {
    int n = 74;
    System.out.println(""+primesum(10));
  // findPrimePair(10);
  }
}


