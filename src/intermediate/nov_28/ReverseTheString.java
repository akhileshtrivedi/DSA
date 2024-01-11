package intermediate.nov_28;

public class ReverseTheString {
    private static String convertStringArrayToString(String[] strArr, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str).append(delimiter);
        return sb.substring(0, sb.length() - 1);
    }
    private static String solve(String A) {
        String str[] = A.split(" ");

        int j=str.length-1;
        String temp;
        for(int i=0;i<str.length/2;i++){
            temp =str[i] ;
            str[i]=str[j];
            str[j]=temp;
            j--;
        }
        return convertStringArrayToString(str, " ");
    }
    public static void main(String[] args) {
        System.out.println(""+solve("the sky is blue"));
        System.out.println(""+solve("this is ib"));

    }
}
