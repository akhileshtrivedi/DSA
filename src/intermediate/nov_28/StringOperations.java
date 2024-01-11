package intermediate.nov_28;

public class StringOperations {
    private static String solve(String A) {
        String strNew = A.concat(A).replaceAll("([A-Z])", "");
        for(int i=0;i<A.length();i++){
            char character =A.charAt(i);
            if (character == 'a' || character == 'e'||character == 'i' || character == 'o'||character == 'u') {
                strNew =  strNew.replace(character,'#');
            }
        }
        return strNew;
    }
    public static void main(String[] args) {
        System.out.println(""+solve("AbcaZeoB"));//"bc###bc###"
    }
}
