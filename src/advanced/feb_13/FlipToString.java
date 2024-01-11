package advanced.feb_13;

class FlipToString
{
  public static char flip(char ch)
  {
    System.out.println(" ch "+ch);
    return (ch == '0') ? '1' : '0';
  }

  public static int getFlipWithStartingCharcter(String str,
      char expected)
  {
    System.out.println("str-->"+str);
    int flipCount = 0;
    for (int i = 0; i < str.length(); i++)
    {
      if (str.charAt(i) != expected)
        flipCount++;

      expected = flip(expected);
    }
    System.out.println(str+" flipCount-->"+flipCount);
    return flipCount;
  }

  public static int minFlipToMakeStringAlternate(String str)
  {

    return Math.min(getFlipWithStartingCharcter(str, '0'),
        getFlipWithStartingCharcter(str, '1'));
  }

  // Driver code to test above method
  public static void main(String args[])
  {
    String str = "0001010111";
    System.out.println(minFlipToMakeStringAlternate(str));
  }
}

