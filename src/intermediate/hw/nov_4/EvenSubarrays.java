package intermediate.hw.nov_4;

public class EvenSubarrays {
    public static String solve(int[] A) {
        if(A.length%2!=0 || A[0]%2!=0 || A[A.length-1]%2!=0)
            return "NO";
        else
            return "YES";
    }
    public static void main(String[] args) {
      int  A[] = {2, 4, 8, 6};//YES
      int AA []= {2, 4, 8, 7, 6}; // NO
      int AAA []= {978, 847, 95, 729, 778, 586, 188, 782, 813, 870, 871, 940, 312, 693, 580, 101, 760, 837, 564, 633, 680, 155, 241, 374, 682, 290, 850, 601, 433, 922, 773, 959, 530, 290, 990, 50, 516, 409, 868, 131, 664, 851, 721, 880, 20, 450, 745, 387, 787, 823, 392, 242, 674, 347, 65, 135, 819, 324, 651, 678, 139, 940}; // NO
        System.out.println(""+solve(A));
        System.out.println(""+solve(AA));
        System.out.println(""+solve(AAA));
    }
}
