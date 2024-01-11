package intermediate.nov_23;

public class HWLeapyear {
    private static int isLeapYear(int A) {
        if ((A % 400 == 0)
                || ((A % 4 == 0) && (A % 100 != 0))) {

            return 1;
        } else {
            return 0;
        }

    }

    private static int isNumDividedBy8(String A) {
        int n = A.length();
        if (n == 0)
            return 0;
        if (n == 1)
            return ((A.charAt(0) - '0') % 8 == 0) ? 1 : 0;
        if (n == 2)
            return (((A.charAt(n - 2) - '0') * 10 + (A.charAt(n - 1) - '0')) % 8 == 0) ? 1 : 0;

        int last = A.charAt(n - 1) - '0';
        int second_last = A.charAt(n - 2) - '0';
        int third_last = A.charAt(n - 3) - '0';

        return ((third_last * 100 + second_last * 10 + last) % 8 == 0) ? 1 : 0;
    }

    private static int solve(int A, int B, int C) {
        int max = Math.max(A, Math.max(B, C));
        int min = Math.min(A, Math.min(B, C));
        int mid = A + B + C - max - min;

        String num = "" + min + mid + max;

        return Integer.valueOf(num);
    }


    public static void main(String[] args) {

        // System.out.println("Is the leap year" + isLeapYear(2020));
        // System.out.println("Is the leap year" + isLeapYear(1999));
        System.out.println("Is the leap year" + solve(28, 57, 32));
    }
}
