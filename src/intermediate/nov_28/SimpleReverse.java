package intermediate.nov_28;

public class SimpleReverse {
    private static String solve(String A) {
        char ch[] = A.toCharArray();
        int j=A.length()-1;
        char temp;
        for(int i=0;i<A.length()/2;i++){
          temp =ch[i] ;
            ch[i]=ch[j];
            ch[j]=temp;
            j--;
        }
       return new String(ch);
    }
    public static void main(String[] args) {
        System.out.println(""+solve("AKHIL"));
    }
}
