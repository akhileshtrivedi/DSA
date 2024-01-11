package intermediate.dec_21;

import java.util.Stack;

public class LittlePonnyAndSubsequence {
    static void firstSubsequence(String s)
    {

        // Store index of character
        // to be deleted
        int isMax = -1;

        // Traverse the String
        for(int i = 0; i < s.length() - 1; i++)
        {

            // If ith character > (i + 1)th
            // character then store it
            if (s.charAt(i) > s.charAt(i + 1))
            {
                isMax = i;
                break;
            }
        }

        // If any character found in non
        // alphabetical order then remove it
        if (isMax >= 0)
        {
            s = s.substring(0, isMax) +
                    s.substring(isMax + 1);
            // s.rerase(isMax, 1);
        }

        // Otherwise remove last character
        else
        {
            //s.erase(s.length() - 1, 1);
            s = s.substring(0, s.length() - 1);

        }

        // Print the resultant subsequence
        System.out.print(s);
    }
    static void smallestSubsequence(char []S, int K)
    {

        // Length of String
        int N = S.length;

        // Stores the minimum subsequence
        Stack<Character> answer = new Stack<>();

        // Traverse the String S
        for (int i = 0; i < N; ++i) {

            // If the stack is empty
            if (answer.isEmpty()) {
                answer.add(S[i]);
            }
            else {

                // Iterate till the current
                // character is less than the
                // the character at the top of stack
                while ((!answer.isEmpty())
                        && (S[i] < answer.peek())

                        // Check if there are enough
                        // characters remaining
                        // to obtain length K
                        && (answer.size() - 1 + N - i >= K)) {
                    answer.pop();
                }

                // If stack size is < K
                if (answer.isEmpty() || answer.size() < K) {

                    // Push the current
                    // character into it
                    answer.add(S[i]);
                }
            }
        }

        // Stores the resultant String
        String ret="";

        // Iterate until stack is empty
        while (!answer.isEmpty()) {
            ret+=(answer.peek());
            answer.pop();
        }

        // Reverse the String
        ret = reverse(ret);

        // Print the String
        System.out.print(ret);
    }
    static String reverse(String input) {
        char[] a = input.toCharArray();
        int l, r = a.length - 1;
        for (l = 0; l < r; l++, r--) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }
    public static void main(String[] args)
    {

        // Given String S
        //String S = "geeksforgeeks";
       // String S = "abcdsfhjagj";

        // Function Call
       // firstSubsequence(S);
        String S = "aabdaabc";
        int K = 3;
        smallestSubsequence(S.toCharArray(), K);
    }
}
