package advanced.jan_13;

import java.util.Scanner;

public class TestBits {

  public static void main(String[] args) {
 /*   int x = 9, y = 8;
// bitwise and
// 1001 & 1000 = 1000 = 8
    System.out.println("x & y = " + (x & y));
// bitwise XOR
// 1001 ^ 1000 = 0001 = 1
    System.out.println("x ^ y = " + (x ^ y));
    // bitwise inclusive OR
// 1001 | 1000 = 1001 = 9
    System.out.println("x | y = " + (x | y));
// bitwise compliment
    int z=9;
// ~0010= 1101 = -3
// ~1001= 0110=-

    System.out.println("~z = " + (~z));
//110010
//  1100
     x = 50;
    System.out.println("x>>2 = " + (x >>2));

    x = 12;
    System.out.println("x<<1 = " + (x << 1));

    x = 20;
    System.out.println("x>>>2 = " + (x >>>2));*/
// Get bit
    System.out.println("Please enter the operation here");
    Scanner sc = new Scanner(System.in);
    int operation = sc.nextInt();
    int n = 5; //0101
    int pos = 1; //0010
    int bitmask = 1 << pos;
    if ((bitmask & n) == 0) {
      System.out.println("bit was zero");
    } else {
      System.out.println("bit was one");

    }
// Set bit
    int newNumber= bitmask|n;
    System.out.println("newNumber--->"+newNumber);

  // Clear bit
    int notBitmask = ~bitmask;
    int newNumber1 = notBitmask & n;
    System.out.println(newNumber1);
// Update Bit
    if (operation==1){
       newNumber= bitmask|n;
      System.out.println("operation--->"+newNumber);

    } else {
       notBitmask = ~bitmask;
       newNumber1 = notBitmask & n;
      System.out.println("operation-------->"+newNumber1);
    }
  }

}
