package intermediate.nov_21;

public class CountSetBitsInAnInteger {

    private static int countSetBits(int n)
    {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
    private static int countSetBits2(int n)
    {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    // driver program
    public static void main(String args[])
    {
        int i = 11;
        System.out.println(countSetBits2(11));
        System.out.println(countSetBits2(6));
    }
}
