package intermediate.nov_28;

public class AddBinaryStrings {
    private static String addBinary(String A, String B) {

        if (A.charAt(0) == '0' && B.charAt(0) == '0') {
            return "0";
        }

        StringBuilder result = new StringBuilder("");
        int s = 0;
        int i = A.length() - 1, j = B.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            s += ((i >= 0) ? A.charAt(i) - '0' : 0);
            s += ((j >= 0) ? B.charAt(j) - '0' : 0);

            result.append((char) (s % 2 + '0'));

            s /= 2;

            i--;
            j--;
        }

        int start = result.length() - 1;

        while (start >= 0 && result.charAt(start) == '0') {
            start--;
        }

        if (start != result.length() - 1) {
            result.delete(start + 1, result.length());
        }

        return result.reverse().toString();
    }
    static String addBinaryOLD(String a, String b)
    {
        //If the inputs are 0
        if(a.charAt(0) == '0' && b.charAt(0) == '0'){
            return "0";
        }
        // Initialize result
        StringBuilder result = new StringBuilder("");

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result.append((char)(s % 2 + '0'));

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        // Remove leading zeros, if any
        int start = result.length()-1;

        while(start >=0 && result.charAt(start) == '0') {
            start--;
        }

        if(start != result.length()-1) {
            result.delete(start+1,result.length());
        }

        return result.reverse().toString();
    }
    public static void main(String[] args) {
        String A = "100";
        String B = "11";

        String AA = "110";
        String BB = "10";
        System.out.println("" + addBinary(A, B));//111
        System.out.println("" + addBinary(AA, BB));//1000

        String a = "11", b="1";

       System.out.print(addBinaryOLD(a, b));
    }
}
