package lb_recursion;

public class DayOne {

  private static int factorial(int n){
      if(n==0)
        return 1;
      return n*factorial(n-1);

  }
  private static int powerOfTwo(int n){
    if(n==0)
      return 1;
    return 2*powerOfTwo(n-1);

  }
  private static void printNumberDsc(int n){
    if(n==0)
      return;
    System.out.println(""+n);
    printNumberDsc(n-1);
  }
  private static void printNumberAsc(int n){
    if(n==0)
      return;

    printNumberAsc(n-1);
    System.out.println(""+n);
  }

  public static void main(String[] args) {
    int n=3;
    System.out.println(n+" factorial-->"+factorial(n));
    System.out.println(n+" powerOfTwo-->"+powerOfTwo(n));
    System.out.println(" printNumberAsc");
    printNumberAsc(n);
    System.out.println("printNumberDsc");
    printNumberDsc(n);
  }

}
