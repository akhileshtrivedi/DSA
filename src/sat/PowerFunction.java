package sat;

public class PowerFunction {
    public int getPower(int A, int B, int C) {
        if(A == 0) {
            return 0;
        }
        else if(B == 0) {
            return 1;
        }else if(C == 0){
            return 0;
        }else {
            return (int) Math.pow(A, B) % C;
        }
    }

    public static void main(String[] args) {
        int A = 2;
        int B = 3;
        int C = 0;
        PowerFunction pf = new PowerFunction();
        System.out.println("---->" + pf.getPower(A, B, C));
    }
}
