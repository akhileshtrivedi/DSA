package intermediate.dec_5;

import java.util.Scanner;

public class StringReverseHW {

   private static void reverseString(String str)
    {
        if ((str==null)||(str.length() <= 1))
            System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length()-1));
            reverseString(str.substring(0,str.length()-1));
        }
    }
   private  static void reverse(char[] str, int index, int n)
    {
        if (index == n)
        {
            return;
        }
        char temp = str[index];
        reverse(str, index + 1, n);
        System.out.print(temp);
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
       /* String str = "Geeks for Geeks";
        StringReverseHW obj = new StringReverseHW();
        obj.reverse(str); */
        // String input with the Java Scanner
        System.out.println("Please write string as input here");
        Scanner stringScanner = new Scanner(System.in);
        String str = stringScanner.next();
        char a[] = str.toCharArray();
        int n = a.length;
        reverse(a, 0, n);
       // reverseString(str);



    }
}
