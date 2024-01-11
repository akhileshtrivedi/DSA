package intermediate.nov_14;

public class LengthOfLongestConsecutiveOnes {
    private static int getmMximumOne(String A){
        int countOnes = 0;
        int countZeros = 0;
        int len = A.length();

        for(int i=0;i<len;i++){
            if(A.charAt(i)=='1'){
                countOnes++;
            }
            if(A.charAt(i)=='0'){
                countZeros++;
            }
            if(countZeros==A.length()){
              return 0;
            }
            if (countOnes==A.length()){
                return A.length();
            }
        }
        int maxAns=0;
        for (int i=0;i<len;i++) {
            if (A.charAt(i) == '0') {
                int l = 0;
                for (int j = i - 1; j > 0; j--) {
                    if (A.charAt(j) == '1') {
                        l++;
                    } else {
                        break;
                    }
                }
                System.out.println("left-->"+l);
                int r = 0;
                for (int k = i + 1; k < len; k--) {
                    if (A.charAt(k) == '1') {
                        r++;
                    } else {
                        break;
                    }
                }
                System.out.println("right-->"+r);
                if(l+r+1>maxAns)
                    maxAns=l+r+1;
            }

        }
        return maxAns;
    }
    public static void main(String[] args) {
       String s = "111011101";
       // String s =   "11010110000000000";// 4

        System.out.println("Total Ones count is "+getmMximumOne(s));
    }
}
