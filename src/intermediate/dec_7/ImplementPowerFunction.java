package intermediate.dec_7;

public class ImplementPowerFunction {
    private static int pow(int A, int B, int C) {
        if(A==0)
            return 0;
        if(B==0)
            return 1;
        if(B<=0)
            return A+C;
        int ans =pow(A,B/2,C);
        if(B%2==0)
            return (ans*ans)%C;
        else
            return ((ans*ans)%C*A)%C;
    }
    public static void main(String[] args) {
        System.out.println("result "+pow(71045970,41535484,64735492));//2
      //  System.out.println("result "+pow(-1,1,20));//2

    }
//20805472
//28433464
//-7340352
}
