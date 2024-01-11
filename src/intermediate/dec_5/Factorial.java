package intermediate.dec_5;

public class Factorial {
    private static int fact(int A){
        if(A==1){return 1;}
        return fact(A-1)*A;
    }
    public static void main(String[] args) {
        System.out.println("Factorial value is "+fact(5));
    }
}
