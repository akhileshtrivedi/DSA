package intermediate.dec_5;

public class CheckPalindrome {

    static int isPalRec(String str, int s, int e)
    {
        if (s == e)
            return 1;
        if ((str.charAt(s)) != (str.charAt(e)))
            return 0;
        if (s < e + 1)
            return isPalRec(str, s + 1, e - 1);
        return 1;
    }
    private static int isPalindrome(String A){
        int n = A.length();
        if (n == 0)
            return 1;
        return isPalRec(A, 0, n - 1);
    }

    public static void main (String[] args) {
        String str = "geeg" ;

System.out.println(""+isPalindrome("naman"));
        System.out.println(""+isPalindrome("strings"));
        System.out.println(""+isPalindrome(str));

    }
}
