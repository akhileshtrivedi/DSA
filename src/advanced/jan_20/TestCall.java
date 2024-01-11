package advanced.jan_20;

public class TestCall {
private static int factorial(int n){
  int fact=1;
  for(int i=1;i<=n;i++){
    fact=fact*i;
  }
  return fact;
}
  private static boolean isPrime(int n){
    int fact=0;
    for(int i=1;i*i<=n;i++) {
      if (n%i==0) {
        if (i == n/i) {
          fact++;
        } else {
          fact += 2;
        }
      }
    }
    return fact==2;
  }

  public static void main(String[] args) {
    int n=0;

    System.out.println("Is "+n+" Prime number? "+isPrime(n));
    System.out.println(" Factorial number "+factorial(n));
  }

}
