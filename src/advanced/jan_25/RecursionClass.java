package advanced.jan_25;

public class RecursionClass {

  private static void printNumber(int n) {
    if (n <= 0) {
      return;
    }
    System.out.println(" " + n);
    printNumber(n - 1);

  }

  private static int sumOfNaturalNumber(int n) {  // 10+9+8+7+6+5+4+3+2+1
    //n+sum of n-1....
    if (n == 0 || (n == 1)) {
      return n;
    }
    return n + sumOfNaturalNumber(n - 1);
  }
//DP-->Dynamic Programing--->(Recursion+Memorization)



  private static int fib(int n) {//0,1,1,2,3,5,8,13,21,34,55
    if (n <= 1) {
      return n;
    }
    return fib(n - 1) + fib(n - 2);
  }



  private static int PowerOfTwo(int n) {
    if (n == 0) {
      return 1;
    }
    return 2 * PowerOfTwo(n - 1);
  }

  public static void main(String[] args) {
    int n = 5;
    printNumber(n);
    System.out.println("Sum Of Natural Number");
    System.out.println("" + sumOfNaturalNumber(n));
    System.out.println("Fibonacci Numbers");
    System.out.println("" + fib(n));
    System.out.println("Power Of Two");
    System.out.println(""+PowerOfTwo(n));
  }

}
