package advanced.jan_20;

// Java program to print all primes smaller than or equal to
// n using Sieve of Eratosthenes

import java.util.ArrayList;
import java.util.Collections;

class SieveOfEratosthenes {
  void sieveOfEratosthenes(int n)
  {
    ArrayList<Boolean> primeList = new ArrayList<>(Collections.nCopies(n+1, true));
   // System.out.println(primeList);


    for (int p = 2; p * p <= n; p++) {
      if (primeList.get(p) == true) {
        for (int i = p * p; i <= n; i += p)
          primeList.set(i, false);
      }
    }

    // Print all prime numbers
    for (int i = 2; i <= n; i++) {
      if (primeList.get(i) == true)
        System.out.print(i + " ");
    }

  }
  private static void OneToNfactCount(int n){
    ArrayList<Integer> factList = new ArrayList<>(Collections.nCopies(n, 0));
    System.out.println("factList-->"+factList);
    for(int i=0;i<n;i++){
   //   for(int j=i;j<n;j++){
      //  System.out.println(j+""+(j+1));
        factList.set(i,factCount(i+1));
     // }
    }
    System.out.println(" updated factList-->"+factList);
  }
  private static int factCount(int n){
    int fact =0;
    for(int i=1;i*i<n;i++){
        if(n%i==0){
          if(i==n/i){
            fact++;
          }else{
            fact+=2;
          }

        }
    }
   // System.out.println(" updated factList-->"+fact);
    return fact;
  }
  // Driver Code
  public static void main(String args[])
  {
    int n = 30;
    System.out.print("Following are the prime numbers ");
    System.out.println("smaller than or equal to " + n);
    SieveOfEratosthenes g = new SieveOfEratosthenes();
  //  g.sieveOfEratosthenes(n);
    OneToNfactCount(n);
  //  OneToNfactCount(n);

  }
}

// This code is contributed by Aditya Kumar (adityakumar129)
