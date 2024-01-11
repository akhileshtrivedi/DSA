package intermediate.nov_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestCommonPrefix_HW {
    private static String longestCommonPrefix(ArrayList<String> A) {
        StringBuilder sb = new StringBuilder();
        int minLength = Collections.min(A).length();
        for (int j = 0; j < minLength; j++) {
            int compareOneTwo = Character.compare(A.get(0).charAt(j), A.get(1).charAt(j));
            int compareOneThree = Character.compare(A.get(0).charAt(j), A.get(2).charAt(j));
            if (compareOneTwo == compareOneThree) {
                sb.append(A.get(0).charAt(j));
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static String longestCommonPrefixNew(ArrayList<String> A) {
        int size = A.size();
        if (size == 0)
            return "";
        if (size == 1)
            return A.get(0);
        Collections.sort(A);

        int end = Math.min(A.get(0).length(), A.get(size - 1).length());

        int i = 0;
        while (i < end && A.get(0).charAt(i) == A.get(size - 1).charAt(i))
            i++;

        String pre = A.get(0).substring(0, i);
        return pre;
    }

    public static void main(String[] args) {
        System.out.println("I am here-->" + longestCommonPrefixNew(new ArrayList<String>(Arrays.asList("abcdefgh", "aefghijk", "abcefgh"))));//a
        System.out.println("I am here-->" + longestCommonPrefixNew(new ArrayList<String>(Arrays.asList("abab", "ab", "abcd"))));//ab
    }
}
