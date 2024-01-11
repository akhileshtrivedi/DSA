package intermediate.nov_28;

import java.util.*;

public class ChangeCharacter {
    static final int MAX_CHAR = 26;

    private static int solveNew(String A, int B) {

        int n = A.length();
       // if (n > MAX_CHAR)
      //      return -1;
        System.out.println("count");
        int dist_count = 0;
        int count[] = new int[MAX_CHAR];
        System.out.println("count2222");
        for (int i = 0; i < MAX_CHAR; i++)
            count[i] = 0;
        System.out.println("count3333");
        for (int i = 0; i < n; i++) {
            if (count[A.charAt(i) - 'a'] == 0)
                dist_count++;
            count[A.charAt(i) - 'a']++;
        }
        if (B <= 0 || A.length()==1) {
            return dist_count;
        }
        Arrays.sort(count);
        System.out.println("count");
        int len = count.length - 1;
        for (int i = 0; i <= len; i++) {
          //  System.out.println("count["+i+ "] "+ count[i]);
        }
        for (int i = 0; i <= len; i++) {
           // System.out.println("count[i]" + count[i]);
            if (count[i] > 0 && B >= count[i] ) {
                System.out.println(B+"<---B count[i]----> "+ count[i]);
                B = B - count[i];
                count[len] = count[len] + count[i];

                count[i] = 0;
            }
        }
        dist_count = 0;
        for (int i = 0; i <= len; i++) {
            if (count[i] > 0) {
                dist_count++;
            }
        }

        return dist_count;
    }

    private static int solve(String A, int B) {
        Map<Character, Integer> mp = new HashMap<>();

        char[] ch = A.toCharArray();
        int cnt = 0;
        for (int i = 0; i < A.length(); i++) {
            mp.put(ch[i], mp.get(ch[i]) == null ? 1 : mp.get(ch[i]) + 1);
        }
        System.out.println("I am here--->" + mp);
        return 0;
    }

    public static void main(String[] args) {
        //  System.out.println(" here"+solve("abcabbccd", 3));
        // String str = "aebaecedabbee";
        String str = "abcabbccd";
        String a1="qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmq";
        System.out.println(a1.length());
       // System.out.println(solveNew("umeaylnlfd", 1));
       // System.out.println(solveNew("a", 1));
        System.out.println(solveNew("qghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxfxtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknlyjyhfixjswnkkufnuxxzrzbmnmgqooketlyhnkoaugzqrcddiuteiojwayyzpvscmpsajlfvgubfaaovlzylntrkdcpwsrtesjwhdizcobzcnfwlqijtvdwvxhrcbldvgylwgbusbmborxtlhcsmpxohgmgnkeufdxotogbgxpeyanfetcukepzshkljugggekjdqzjenpevqgxiepjsrdzjazujllchhbfqmkimwzobiwybxduunfsksrsrtekmq", 119));
    }
}
