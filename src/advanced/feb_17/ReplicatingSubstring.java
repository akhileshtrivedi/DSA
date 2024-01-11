package advanced.feb_17;

import java.util.HashMap;

public class ReplicatingSubstring {
  private static int solve(int A, String B) {
    HashMap<Character,Integer> map = new HashMap<>();
    for(int i=0; i<B.length(); i++){
      Character ch = B.charAt(i);
      if(!map.containsKey(ch)){
        map.put(ch,1);
      }
      else{
        map.put(ch,(map.get(ch))+1);
      }
    }

    for(Character i : map.keySet()){
      int val = map.get(i);
      if((val % A) != 0) {
        return -1;
      }
    }

    return 1;
  }

  public static void main(String[] args) {
    System.out.println(""+solve(2, "bbaabb"));
    System.out.println(""+solve(1, "bc"));
  }

}
