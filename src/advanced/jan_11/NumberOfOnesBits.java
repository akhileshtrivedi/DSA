package advanced.jan_11;

public class NumberOfOnesBits {

  private static int numSetBits(int A) {
    int count = 0;
    for (int i = 0; i < 4 * 8; i++)
    {
      if ((A & (1 << i)) != 0)
        count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println("I did" + numSetBits(11));//3   000001011
    System.out.println("I did" + numSetBits(6));//2    000000110
  }
}
