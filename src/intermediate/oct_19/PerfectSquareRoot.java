package intermediate.oct_19;

public class PerfectSquareRoot {
    public int getSquareRoot(int number) {
        double x = Math.sqrt(number);
        if (x == (int) x) {
            return (int) x;
        }
        return -1;
    }

    public int getSquareRootNew(int A) {
        for (int i = 1; i <= A; i++) {
            int s = i * i;
            if (s == A) {
                return i;
            }

//            if(s>A) {
//                return , i-1, i);
//            }
        }
        return -1;
    }


    public static void main(String[] args) {
        PerfectSquareRoot psr = new PerfectSquareRoot();
        System.out.println("here is   " + psr.getSquareRoot(84630800));
        // System.out.println(""+psr.getSquareRootNew(10001));
    }
}
