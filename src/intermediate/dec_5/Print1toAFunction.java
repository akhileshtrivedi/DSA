package intermediate.dec_5;

public class Print1toAFunction {
    private  static void solve(int A) {
        if(A<=0){ return;}
        solve(A-1);
        System.out.print(A+" ");

    }
    public static void main(String[] args) {

        solve(10);
    }
}
