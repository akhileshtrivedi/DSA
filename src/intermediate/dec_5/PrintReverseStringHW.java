package intermediate.dec_5;

public class PrintReverseStringHW {
  /*  private static int fun(int x, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return fun(x * x, n / 2);
        } else {
            return fun(x * x, (n - 1) / 2);
        }

    } */
    private static int bar(int x, int y){
        if(y==0) {
            return 0;
        }
       return  (x+bar(x, y-1));
        }
    private static int foo(int x, int y){
        if(y==0) {
            return 1;
        }
        return  bar(x,foo(x, y-1));
    }

    private static int solve(int A){
        if(A==0)
            return 0;

        return (A%10+solve(A/10));
    }

    public static void main(String[] args) {

        System.out.println(solve(12));
    }
}
