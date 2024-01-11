package intermediate.nov_18;

public class AnyBaseToDecimal {
    public static int toDecimal(int A, int B) {
        int multiplier = 0, ans= 0;
        while (A > 0) {
            int remainder = A % 10;
            A = A / 10;
            ans += remainder * Math.pow(B, multiplier);
            multiplier++;
        }
        return ans;
    }
    public static void main(String[] args) {


        int A = 1010;
       int  B = 2;

       int  A1 = 22;
       int  B1 = 3;

        System.out.println(""+toDecimal(A, B));
        System.out.println(""+toDecimal(A1, B1));
    }

}