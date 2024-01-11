package advanced.jan_11;


class DivideIntegers {

  static long divideOLD(long dividend, long divisor) {
    long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    long quotient = 0;

    while (dividend >= divisor) {
      dividend -= divisor;
      ++quotient;
    }

    if (sign == -1) {
      quotient = -quotient;
    }

    return quotient;
  }

  static int divide(int AA, int BB) {
    // Edge case first.
    if (BB == -1 && AA == Integer.MIN_VALUE){
      return Integer.MAX_VALUE;   // Very Special case, since 2^31 is not inside range while -2^31 is within range.
    }
    long B = BB;
    long A = AA;

    int sign = -1;
    if ((A<0 && B<0) || (A>0 && B>0)){
      sign = 1;
    }
    if (A < 0) A = A * -1;
    if (B < 0) B = B * -1;

    int ans = 0;
    long currPos = 1; // necessary to be long. Long is better for left shifting.
    while (A >= B){
      B <<= 1; currPos <<= 1;
    }
    B >>= 1; currPos >>= 1;
    while (currPos != 0){
      if (A >= B){
        A -= B;
        ans |= currPos;
      }
      B >>= 1; currPos >>= 1;
    }
    return ans*sign;
  }

  public static void main(String[] args) {
    int a = 5, b = 2;
    System.out.println(divide(a, b));
    a = 2147483647;
    b = 1;
    System.out.println(divide(a, b));
  }
}

