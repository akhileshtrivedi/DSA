package intermediate.nov_21;

public class CheckBit {
    private static void isKthBitSet1(int n, int k) {
        if ((n & (1 << (k - 1))) > 0)
            System.out.print("SET");
        else
            System.out.print("NOT SET");
    }

    private static int isKthBitSet(int n, int k) {
        if ((n & (1 << (k - 0))) > 0)
            return 1;
        else
            return 0;
    }
    static int bitAtGivenPosSetOrUnset
            ( int n, int k)
    {
        //System.out.println(n+"new_num--->"+k);
        int new_num = n >> (k - 0);
        //System.out.println("new_num--->"+new_num);
        return (new_num & 1);
    }

    public static void main(String[] args) {
        int n = 4, k = 1;
        int nn = 5, kk = 2;
     //   isKthBitSet1(n, k);
      //  isKthBitSet1(nn, kk);
        // Function call
        System.out.println("I am here--->" + bitAtGivenPosSetOrUnset(n, k));
        System.out.println("I am here--->" + bitAtGivenPosSetOrUnset(nn, kk));
//        if (bitAtGivenPosSetOrUnset(n, k)==1)
//            System.out.println("Set");
//        else
//            System.out.println("Unset");

    }
}
