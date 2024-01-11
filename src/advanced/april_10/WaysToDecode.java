package advanced.april_10;

public class WaysToDecode {
  public static int MOD = 1000000007;
  static int countDecodingDP(String A) {
    char digits[] = A.toCharArray();
    int n=digits.length;
    long count[] = new long[n + 1];
    count[0] = 1;
    count[1] = 1;
    if (digits[0] == '0') {
      return 0;
    }
    for (int i = 2; i <= n; i++) {
      count[i] = 0;
      if (digits[i - 1] > '0') {
        count[i] = count[i - 1];
        count[i] = count[i] % MOD;

      }
      if (digits[i - 2] == '1' ||
          (digits[i - 2] == '2' &&
              digits[i - 1] < '7')) {
        count[i] += count[i - 2];
        count[i] = count[i] % MOD;
      }
    }
    return (int)count[n];
  }

  public static void main(String[] args) {
   // char digits[] = {'1', '2', '3', '4'};
    String digits = "1234";
    System.out.println("Count is " + countDecodingDP(digits));
  }
}
