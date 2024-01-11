package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;

public class IsDictionaryHW {
     static boolean isAlienSortedOld(String[] words, String order) {
        int[] index = new int[26];
        for (int i = 0; i < order.length(); ++i)
            index[order.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < words.length - 1; ++i) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return false;
                    continue search;
                }
            }
            if (word1.length() > word2.length())
                return false;
        }

        return true;
    }
    private static int isAlienSorted(ArrayList<String> A, String B) {
        int[] index = new int[26];
        for (int i = 0; i < B.length(); ++i)
            index[B.charAt(i) - 'a'] = i;

        search: for (int i = 0; i < A.size() - 1; ++i) {
            String word1 = A.get(i);
            String word2 = A.get(i + 1);

            for (int k = 0; k < Math.min(word1.length(), word2.length()); ++k) {
                if (word1.charAt(k) != word2.charAt(k)) {
                    if (index[word1.charAt(k) - 'a'] > index[word2.charAt(k) - 'a'])
                        return 0;
                    continue search;
                }
            }
            if (word1.length() > word2.length())
                return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
       String [] A = {"hello", "scaler", "interviewbit"};
       String  B = "adhbcfegskjlponmirqtxwuvzy";


        String [] AA = {"fine", "none", "no"};
        String BB = "qwertyuiopasdfghjklzxcvbnm";
//        System.out.println(""+isAlienSorted(A, B));
//        System.out.println(""+isAlienSorted(AA, BB));
        System.out.println(""+isAlienSorted(new ArrayList<String>(Arrays.asList("hello", "scaler", "interviewbit")), B));
        System.out.println(""+isAlienSorted(new ArrayList<String>(Arrays.asList("fine", "none", "no")), BB));

    }
}
