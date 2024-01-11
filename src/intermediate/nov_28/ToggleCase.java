package intermediate.nov_28;

public class ToggleCase {
    private static String solve(String A) {
        StringBuilder myA = new StringBuilder(A);
        for (int i=0;i<myA.length();i++){
            if((int)A.charAt(i)>= 65 && (int)A.charAt(i)<= 90 ){
                myA.setCharAt(i, (char) ((int)A.charAt(i)+32));
            }else if((int)A.charAt(i)>= 97 && (int)A.charAt(i)<= 122 ){
                myA.setCharAt(i, (char) ((int)A.charAt(i)-32));
            }
        }

        return myA.toString();
    }
    public static void main(String[] args) {
        String A = "Hello";
        String  A2 = "tHiSiSaStRiNg";
        System.out.println("Toggled String-->"+solve(A));
       System.out.println("Toggled String-->"+solve(A2));
    }
}
