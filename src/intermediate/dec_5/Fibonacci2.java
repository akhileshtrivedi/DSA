package intermediate.dec_5;

public class Fibonacci2 {
    private static int findAthFibonacci(int A) {
        if(A==0){return 0;}
        if(A==1){return 1;}
        if(A==2){return 1;}
        return findAthFibonacci(A-1)+findAthFibonacci(A-2);
    }
    public static void main(String[] args) {
        System.out.println("Fibonacci2---."+findAthFibonacci(5));
    }
}
