package advanced.feb_20;

class MakeStringPalindrome
{

  public static int[] computeLPSArray(String str)
  {
    int n = str.length();
    int lps[] = new int[n];
    int i = 1, len = 0;
    lps[0] = 0; // lps[0] is always 0

    while (i < n)
    {
      if (str.charAt(i) == str.charAt(len))
      {
        len++;
        lps[i] = len;
        i++;
      }
      else
      {

        if (len != 0)
        {
          len = lps[len - 1];
        }
        else
        {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }
  static int getMinCharToAddedToMakeStringPalin(String A)
  {
    StringBuilder s = new StringBuilder();
    s.append(A);

    String rev = s.reverse().toString();
    s.reverse().append("$").append(rev);
    int lps[] = computeLPSArray(s.toString());
    return A.length() - lps[s.length() - 1];
  }

  public static void main(String args[])
  {
    String str = "AACECAAAA";
    System.out.println(getMinCharToAddedToMakeStringPalin(str));
  }
}

// This code is contributed by Sparsh Singhal
