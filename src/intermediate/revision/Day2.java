package intermediate.revision;

public class Day2 {
    private static int q1(int n) {
        return n * (n + 1) / 2;
    }

    private static int q2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private static void printEvenOdd(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println("Even number is -->" + i);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 1) {
                System.out.println("Odd number is -->" + i);
            }
        }
    }

    private static int q3(int n) {
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            sum += i;

        }
        return sum;
    }
private static int q4(int n){
       int ans=0;
        while(n>1){
         n=n/2;
        }
        return ans;
}
    public static void main(String[] args) {
        //System.out.println("Sum of numbers by Q1-->"+q1(100));
        // System.out.println("Sum of numbers by Q2-->"+q2(100));
        System.out.println("Sum of numbers by Q2-->" + q4(5));
        // printEvenOdd(10);

    }
}
