package advanced.feb_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class FlipAndFindNearest {

  private static String getFlippedString(String str, int index) {
    StringBuffer string = new StringBuffer(str);
    char bit = str.charAt(index);
    string.setCharAt(index, bit == '1' ? '0' : '1');
    return string.toString();
  }

  private static TreeSet onesSet(String str){
    TreeSet set = new TreeSet();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') {
        set.add(i+1);
      }
    }
   return set;
  }
  private static ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {
    int type = 0;
    TreeSet set;

    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (ArrayList obj : B) {
      type = (int) obj.get(0);
      switch (type) {
        case 1:
          System.out.println(
              "Flip the bit of the  " + obj.get(1) + " -th position in given String");
          A = getFlippedString(A, (int) obj.get(1) - 1);
           set = onesSet(A);
          break;
        case 2:
          int x= (int)obj.get(1);
          set = onesSet(A);
          int right = -1;
          int left = -1;
          System.out.println(A+" set-->"+set);
          System.out.println(set.ceiling(x)+" set-->"+set.floor(x));
          if(set.ceiling(x)!=null){
            right = (int)set.ceiling(x);
          }
          if(set.floor(x)!=null){
            left = (int)set.floor(x);
          }
          if(left==-1 && right==-1){
            ans.add(-1);
          }else  if(left==-1){
            ans.add(right);
          }else if(right==-1){
          ans.add(left);
        }
//          System.out.println(x+" here ans-->"+ans);
//           if(x==1 && ans.size()==1 ){
//             result.add(right);
//             break;
//           }
          if(Math.abs(x-left)==Math.abs(x-right)  && ans.size()==1){
            result.add(right);
          }else if(Math.abs(x-left)<Math.abs(x-right)){
            result.add(left);
          } else if(Math.abs(x-left)>Math.abs(x-right)){
            result.add(right);
          } else{
            result.add(left);
          }
          System.out.println(A + " Find the index of the nearest '1' from " + obj.get(1));

          break;
      }
    }
    return result;
  }


  private static ArrayList<Integer> solve2(String A, ArrayList<ArrayList<Integer>> B) {
    final int inf = (int)(1e9);
    TreeSet<Integer> set = new TreeSet<Integer>();
    ArrayList<Integer> ans = new ArrayList<Integer>();
    for(int i = 0; i < A.length(); i++){
      if(A.charAt(i) == '1'){
        set.add(i + 1);
      }
    }
    for(int i = 0; i < B.size(); i++){
      int type = B.get(i).get(0);
      int x = B.get(i).get(1);
      if(type == 1){
        if(set.contains(x)){
          set.remove(x);
        }
        else{
          set.add(x);
        }
      }
      else{
        int left = -inf, right = inf;
        if(set.ceiling(x) != null){
          right = set.ceiling(x);
        }
        if(set.floor(x) != null){
          left = set.floor(x);
        }
        if(left == -inf && right == inf){
          ans.add(-1);
        }
        else if(x - left <= right - x){
          ans.add(left);
        }
        else{
          ans.add(right);
        }
      }
    }
    return ans;
  }
  public static void main(String[] args) {

    ArrayList<ArrayList<Integer>> queries = new ArrayList<>();
    queries.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
    queries.add(new ArrayList<Integer>(Arrays.asList(2, 3)));

    ArrayList<ArrayList<Integer>> queries2 = new ArrayList<>();
    queries2.add(new ArrayList<Integer>(Arrays.asList(2, 5)));
    queries2.add(new ArrayList<Integer>(Arrays.asList(1, 7)));
    queries2.add(new ArrayList<Integer>(Arrays.asList(2, 9)));

/*  [2, 3]
  [2, 1]
  [1, 4]
  [2, 4]
  [2, 5]
  [1, 2]
  [1, 4]
  [2, 1]
  [2, 3]*/

    ArrayList<ArrayList<Integer>> queries3 = new ArrayList<>();
    queries3.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(2, 1)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(2, 4)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(2, 5)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(2, 1)));
    queries3.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
    //System.out.println("" + solve("10010", queries));
   // System.out.println(""+solve("010000100", queries2));
    System.out.println("" + solve2("01011", queries3));
//2 2 5 5 4 4


  }
}
