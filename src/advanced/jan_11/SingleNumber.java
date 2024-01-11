package advanced.jan_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNumber {
  private static int singleNumber(final List<Integer> A) {
    System.out.println(A);
    int ans=0;
    for(int i=0;i<A.size();i++){
      ans=ans^A.get(i);
    }
    return ans;
  }
  public static void main(String[] args) {
    System.out.println("I did"+singleNumber(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1))));
    System.out.println("I did"+singleNumber(new ArrayList<>(Arrays.asList(1, 2, 2))));
  }

}
