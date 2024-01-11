package intermediate.dec_21;


public class SpecialSubsequences {
    static int count(String a, String b, int m, int n)
    {

        if ((m == 0 && n == 0) || n == 0)
            return 1;

        if (m == 0)
            return 0;

        if (a.charAt(m - 1) == b.charAt(n - 1))
            return count(a, b, m - 1, n - 1) +
                    count(a, b, m - 1, n);
        else
            return count(a, b, m - 1, n);
    }

    static int max = 100;
    static void countSubsequence(String s)
    {
        int n = s.length();
        int cntG = 0, cntF = 0, result = 0, C=0;

        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'A':
                    cntG++;
                    result+=C;
                    break;

                case 'G':
                    cntF++;
                    C+=cntG;
                    break;

                default:
                    continue;
            }
        }

        System.out.println(result);
    }

    public static void main(String args[]) {
        String s= "ABCGAG";
        String s2= "AG";
       // String s2= "GAB";
       // countSubsequence(s);
       // countSubsequence(s2);
        String a = "GeeksforGeeks";
        String b = "Gks";
      //  System.out.println( count(a, b, a.length(), b.length())) ;
        System.out.println( count(s, s2, s.length(), s2.length())) ;
    }
}


