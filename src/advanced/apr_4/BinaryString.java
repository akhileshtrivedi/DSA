package advanced.apr_4;

class BinaryString
{
  public static char flip(char ch)
  {
    return (ch == '0') ? '1' : '0';
  }
  public static int getFlipWithStartingCharcter(String str,
      char expected)
  {
    int flipCount = 0;
    for (int i = 0; i < str.length(); i++)
    {
      if (str.charAt(i) != expected)
        flipCount++;
      expected = flip(expected);
    }
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

// This code is contributed by Sumit Ghosh
