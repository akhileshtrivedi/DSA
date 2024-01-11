package intermediate.nov_28;

import java.util.Arrays;

public class Anagram {
    private static int solve(String A, String B) {

            char[] str1 = A.toCharArray();
            char[] str2 = B.toCharArray();
            int n1 = str1.length;
            int n2 = str2.length;

            if (n1 != n2)
                return 0;

            Arrays.sort(str1);
            Arrays.sort(str2);

            for (int i = 0; i < n1; i++)
                if (str1[i] != str2[i])
                    return 0;

            return 1;
        }
        public static void main (String[]args){
            String A = "cat";
            String B = "bat";

            String AA = "secure";
            String BB = "rescue";

            System.out.println(" I am here"+solve(A,B));
            System.out.println(" I am here"+solve(AA,BB));
        }
    }
