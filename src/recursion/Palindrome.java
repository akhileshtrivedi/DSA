package recursion;

public class Palindrome {
    private boolean isPalindromeRecInt(int n) {
        System.out.println("called isPalindromeRecInt-->");
        int i=0;
        if (n == 0) {
            return true;
        }
        i = (i * 10) + (n % 10);
        return isPalindromeRecInt(n / 10);
    }

//        static int rev(int n, int temp)
//        {
//            // base case
//            if (n == 0)
//                return temp;
//
//            // stores the reverse
//            // of a number
//            temp = (temp * 10) + (n % 10);
//
//            return rev(n / 10, temp);
//        }
//


    private boolean isPalindromeRec(String str, int i, int j) {
        // base case: if the string is null or empty
        if (str == null || str.equals("")) {
            return false;
        }
        char[] charArr = str.toCharArray();
        if (i > j) {
            return true;
        }
        if (charArr[i] != charArr[j]) {
            return false;
        } else {
            System.out.println(charArr[i] + "" + charArr[j]);
            // return  true;
            return isPalindromeRec(str, i++, j--);
        }

    }

    private boolean isPalindrome(String str) {
        char[] charArr = str.toCharArray();
        boolean flag = false;
        int len = charArr.length - 1;
        for (int i = 0; i < len / 2; i++) {

            if (charArr[i] == charArr[len - i]) {
                flag = true;
            } else {
                return false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        String str = "aba";
        Palindrome p = new Palindrome();
        int n=1211;
        //   System.out.println("Is it Palindrome " + p.isPalindrome(str));
        //  System.out.println("Is it Palindrome " + p.isPalindromeRec(str,0,str.length()-1));
        System.out.println("Is it Palindrome "+p.isPalindromeRecInt(n));

    }
}
