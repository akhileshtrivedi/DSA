package intermediate.nov_28;

import java.util.ArrayList;
import java.util.Arrays;

public class ToUpper {
    private static ArrayList<Character> to_upper(ArrayList<Character> A) {
        for (int i=0;i<A.size();i++){
            System.out.println(A.get(i)+"   "+(int)A.get(i));
            if((int)A.get(i)>= 97 && (int)A.get(i)<= 122 ){
                A.set(i, (char) ((int)A.get(i)-32));
            }
        }
        return A;

    }
    public static void main(String[] args) {
        ArrayList<Character> al= new ArrayList<>(Arrays.asList('S', 'c', 'A', 'l', 'e', 'r', 'A', 'c', 'a', 'D', 'e', 'm', 'y'));
        ArrayList<Character> al2= new ArrayList<>(Arrays.asList('S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'));
        System.out.println(" I am here"+to_upper(al));
    }
}
