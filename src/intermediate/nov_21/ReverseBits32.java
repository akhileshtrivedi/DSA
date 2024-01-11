package intermediate.nov_21;

import java.util.ArrayList;
import java.util.List;

public class ReverseBits32 {
    public static long reverseBits32(long n){
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((n & (1 << i)) != 0)
                rev |= 1;
        }
        return rev;
    }
    static long  reversedBitsNum(long  n)
    {
        long dn = 0; // variable for new decimal number
        int j = 30; // initial value of j
        // loop to find the reversede binary bit
        for (int i = 0; i < 32; ++i) {
            long k = (n >> i) & 1;
           // if (k) { // if bit is set then only convert in
                // decimal
                if (j == -1) { // since if j = -1 then left
                    // shift operator will not work
                    dn = (long) (Math.abs(dn) + Math.pow(2, 0));
                }
                else {
                    dn = Math.abs(dn)
                            + (2 << j); // here left shift operator
                    // calculates 2 to power j
                    // for making code efficient
                }
           // }
            j--;  // j is decreased in each iteration
        }
        return Math.abs(dn);
    }
    // Driver code
    public static void main(String[] args)
    {
       // int n = 3;
       // System.out.println(reverseBits(n));
        System.out.println("I am here with --->"+reverseBits32(3));
// 3221225472
// 3221225472
//4294967295
        int num = 3;
        showBits(num); // just to show full bit sequence
        int ret = reverseBits(num);
        System.out.println("\nreverse of number " + num + " is=" + ret);
        showBits(ret);

        System.out.println("\n");
        num = -10;
        showBits(num); // just to show full bit sequence
        ret = reverseBits(num);
        System.out.println("\nreverse of number " + num + " is=" + ret);
        showBits(ret);
    }
    static int reverseBits(int n) {
        int newN = 0;
        for(int i = 0; i < Integer.SIZE; i++) {
            newN = newN << 1;
            if((n & 1) > 0) {
                newN = newN ^ 1;
            }
            n = n >> 1;
        }
        return newN;
    }

    // helper method to show actual bits
    static void showBits(int n) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i< Integer.SIZE; i++) {

            if((n & 1) > 0) l.add(1);
            else l.add(0);

            n = n >> 1;
        }
        for(int i = l.size()-1; i >= 0; i--) {
            System.out.print(l.get(i) + ",");
        }
    }
}

