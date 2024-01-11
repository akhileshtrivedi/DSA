package intermediate.nov_21;

public class ModifyBits {
    private static int modifyBit(int n,
                                 int p,
                                 int b) {
        int mask = 1 << p;
        System.out.println(" mask is-->" + mask);
        return (n & ~mask) |
                ((b << p) & mask);
    }

    private static int modifyBitPos(int A, int B) {
        int mask = 1 << A;
        int mask2 = 1 << B;
        System.out.println(mask + " mask is-->" + mask2);
        return ((mask2 == mask) ? mask : mask2 + mask);
    }

    private static int getUnsetIthBit(int A, int B) {
        if ((A & (1 << (B - 0))) > 0)
            return (A & (~(1 << (B))));
        else
            return A;
    }

    private static int setKthBit(int n, int k) {
        // kth bit of n is being set by this operation
        return ((1 << k) | n);
    }

    private static int ToggleIthBit(int A, int B) {
        if ((A & (1 << (B - 0))) > 0)
            return (A & (~(1 << (B))));
        else
            return ((1 << B) | A);
    }

    private static Long getUnsetXbitsFromRight(Long A, int B) {
        //if ((A & (1 << (B - 0))) > 0)
            return (long)(A & (~((B)>>1)));

    }

    public static void main(String[] args) {
//        System.out.println(modifyBit(6, 2, 0)); //110--->100
//        System.out.println (modifyBit(6, 5, 1));//110--->100110
//        System.out.println(modifyBitPos(2, 0)); //110--->100
//        System.out.println(modifyBitPos(5, 1));//110--->100110---
        // System.out.println(ToggleIthBit(4, 1)); //100--->100-->6
        // System.out.println(ToggleIthBit(5, 2));//101--->001-->1
        System.out.println(getUnsetXbitsFromRight((long) 25, 3)); //11001--->11000(Right shifting)
        System.out.println(getUnsetXbitsFromRight((long) 37, 3));//100101--->100100(Right shifting)
        // System.out.println(getUnsetIthBit(49, 0));//110001--->
        System.out.println(2^3);
    }
}
