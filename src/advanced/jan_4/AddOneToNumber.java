package advanced.jan_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AddOneToNumber {
  private static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
    int reminder = 0;
    while (A.size() > 1 && A.get(0) == 0)
      A.remove(0);
    for (int i=A.size()-1; i>=0; i--) {
      int number = A.get(i);
      if (number == 9) {
        A.remove(i);
        A.add(i, 0);
        reminder = 1;
      }
      else {
        A.remove(i);
        A.add(i, number+1);
        reminder = 0;
        break;
      }
    }
    if (reminder == 1) {
      A.add(0, 1);
    }
    return A;
  }
 private  static  ArrayList<Integer> AddOne(ArrayList<Integer> digits)
  {
    int index= digits.size() - 1;
    while (index >= 0 && digits.get(index) == 9){
      digits.set(index, 0);
      index -= 1;
    }
    if (index < 0){
      digits.set(0, 1);
      digits.add(digits.size(),0);

    }
    else
      digits.set(index, digits.get(index) + 1);
return digits;
  }


  private static  ArrayList<Integer> plus_one(ArrayList<Integer> digits)
  {
    int n = digits.size();
    Collections.reverse(digits);
    int carry = 0;
    for(int i = 0; i < n; i++)
    {
      if(i == 0)
        digits.set(i, digits.get(i) + 1 + carry);
      else if(carry != 0)
        digits.set(i, digits.get(i) + carry);
      carry = digits.get(i) / 10;
      if(carry != 0)
        digits.set(i, digits.get(i) % 10);
    }

    if(carry != 0)
      digits.set(digits.size() - 1, carry);
    Collections.reverse(digits);
    return digits;
  }
  public static void main(String[] args) {
    System.out.println("plusOne-->"+plus_one(new ArrayList<>(Arrays.asList(1, 2, 3))));
    System.out.println("plusOne-->"+plus_one(new ArrayList<>(Arrays.asList(1, 2, 3,9))));
    System.out.println("plusOne-->"+plus_one(new ArrayList<>(Arrays.asList(0))));
  }
}
