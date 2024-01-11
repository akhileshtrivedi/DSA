package advanced.feb_17;


import java.io.*;
import java.util.Stack;

class ReverseTheString {

  public static String swap(String str, int i, int j)
  {
    char ch[] = str.toCharArray();
    char temp = ch[i];
    ch[i] = ch[j];
    ch[j] = temp;
    return new String(ch);
  }

  public static String reverse_words(String s)
  {
    s=s.trim();
    int left = 0, i = 0, n = s.length();

    while (s.charAt(i) == ' ')
      i++;

    left = i;
    while (i < n) {
      if (i + 1 == n || s.charAt(i) == ' ') {
        int j = i - 1;
        if (i + 1 == n)
          j++;

        while (left < j)
          s = swap(s, left++, j--);

        left = i + 1;
      }
      if (i > left && s.charAt(left) == ' ')
        left = i;

      i++;
    }
    System.out.println(s);
    s = new StringBuilder(s).reverse().toString();
    return s;
  }



  static String reverse(String A)
  {
    Stack<String> stc = new Stack<>();
    String temp = "";
    StringBuilder result= new StringBuilder();
    for(int i = 0; i < A.length(); i++)
    {
      if(A.charAt(i) == ' ')
      {
        stc.add(temp);
        temp = "";
      }
      else
      {
        temp = temp + A.charAt(i);
      }
    }

    stc.add(temp);
    while(!stc.isEmpty())
    {
      temp = stc.peek();
      result.append(temp+" ");
      stc.pop();
    }
    return result.toString().trim();
  }
  public static void main(String[] args)
  {
    String str = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";
    //System.out.println(str);
   // str = reverse_words(str);
    String str1 = "blue is sky the";
    System.out.println("--->"+str1);
    System.out.println(reverse(str1));

   // reverse(str1);

  }
}

