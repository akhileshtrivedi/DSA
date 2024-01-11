package intermediate.dec_7;

public class KthSymbolEasyHW {

//    private  static int kthGrammar(int n, int k) {
//        if (n == 1) return 0;
//        int previousIndex = k / 2;
//        int digit = kthGrammar(n - 1, previousIndex);
//        if (digit == 0)
//        {
//            return k % 2 == 0 ? 0 : 1;
//        }
//        else
//        {
//            return k % 2 == 0 ? 1 : 0;
//        }
//    }
//    private static int solveOLD(int A, int B) {
//        if(A == 1) return 0;
//        if(B % 2 == 0){
//            return solve(A - 1, B / 2) == 0 ? 1 : 0;
//        }else{
//            return solve(A - 1, (B+ 1) / 2);
//        }
//    }
    private static int solve(int A, int B) {
        if (A == 1) return 0;
        int previousIndex = B / 2;
        int digit = solve(A - 1, previousIndex);
        if (digit == 0)
        {
            return B % 2 == 0 ? 0 : 1;
        }
        else
        {
            return B % 2 == 0 ? 1 : 0;
        }
    }
    public static void main(String[] args) {
        System.out.println(""+solve(4,5));
        System.out.println(""+solve(3,0));//0
        System.out.println(""+solve(4,4));//1

    }
}
