package advanced.jan_20;

// Java program to find numbers that are product
// of exactly two distinct prime numbers

import java.util.ArrayList;

class LuckyNumbers {

  static boolean isPerfectSquare(double x) {
    double sr = Math.sqrt(x);
    return ((sr - Math.floor(sr)) == 0);
  }

  static boolean isCheck(int num, ArrayList<Integer> primeList) {
    int cnt = 0;
    for (int i = 0;i < primeList.size(); ++i) {
      if (num % primeList.get(i) == 0) {
        cnt++;
      }
    }
    return cnt == 2;
  }

//  static int findNumbers(int N) {
//    // Vector to store such numbers
//    ArrayList<Integer> result = new ArrayList<Integer>();
//
//    for (int i = 1; i <= N; i++) {
//      //System.out.println(!isProduct(i)+" isProduct   "+i);
//      //System.out.println(isPerfectSquare(i)+" isPerfectSquare   "+i);
//      if (isProduct(i) && !isPerfectSquare(i)) {
//       // System.out.println("hear-->"+i);
//        result.add(i);
//      }
//    }
//    System.out.println(""+result);
//    return result.size();
//  }
  static boolean isPrime(int n){
    //since 0 and 1 is not prime return false.
    if(n==1||n==0)return false;

    //Run a loop from 2 to square root of n
    for(int i=2; i*i<=n; i++){
      // if the number is divisible by i, then n is not a prime number.
      if(n%i==0)return false;
    }
    //otherwise, n is prime number.
    return true;
  }
  private static int solve(int N) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> primeList = new ArrayList<Integer>();
    for (int i = 1; i <= N/2; i++) {
        if(isPrime(i)) {
          primeList.add(i);
        }
    }
    for (int i = 1; i <= N; i++) {
      if(isCheck(i, primeList)) {
        result.add(i);
      }
    }
   // System.out.println("primeList-->"+primeList);
    //System.out.println("result-->"+result);
    return result.size();
  }
  // Driver function
  public static void main(String[] args) {
    int N = 21;
   System.out.println("" + solve(N));

    }
  }

// This Code is Contributed by mits

