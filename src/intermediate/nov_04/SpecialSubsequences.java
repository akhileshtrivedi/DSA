package intermediate.nov_04;

public class SpecialSubsequences {
    private static int countPosition(String A) {
        String SearchString = "AG";
        int len = A.length() -1;
        int count = 0;
        int tc = 0;
        for (int i = len; i >= 0; i--) {
            char c = A.charAt(i);
            if (c == 'G')
                count += 1;
            if (c == 'A')
                tc += count;
        }
        return tc % 1000000007;
    }


    public static void main(String[] args) {
        String  A = "ABCGAG"; //AG
        String  B = "GA";
       // countPosition(A);
      //  System.out.println(A);
        System.out.println("count Position is "+countPosition(A));
       // System.out.println("count Position is "+countPosition(B));

    }
}
