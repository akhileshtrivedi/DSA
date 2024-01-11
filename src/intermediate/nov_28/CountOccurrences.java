package intermediate.nov_28;

public class CountOccurrences {
    private static int solve(String A) {
        char ch = 'b';
        char ch2 = 'o';
        char ch3 = 'b';
        int cnt = 0;

        for ( int i = 0; i < A.length()-2; i++) {
            if (A.charAt(i) == ch && A.charAt(i+1) == ch2 && A.charAt(i+2) == ch3) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(""+solve( "abobc"));
        System.out.println(""+solve( "bobob"));
        String str = "www.scaler.com/topics";
        long cnt = str.chars().filter(ch -> ch == 'o').count();

        System.out.println("Occurrences: " + cnt);
    }
}