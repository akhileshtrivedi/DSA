package advanced.mar_06;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumber {

  private static String solve(int A) {
    Queue<String> q = new LinkedList<>();
    q.add("1");
    q.add("2");

    int count=0;
    String current="", rev="";
    while(count<A){
      current =q.peek();
      q.remove();
      q.add(current+"1");
      q.add(current+"2");
      count++;
    }
    for(int i=current.length()-1; i>=0; i--){

      rev+=current.charAt(i);
    }
    return current+rev;
  }
  public static void main(String[] args) {



  //  System.out.println(""+generatePalindrome(1));
 //   System.out.println(""+generatePalindrome(2));
    System.out.println(""+solve(3));
//    System.out.println(""+generatePalindrome(4));
//    System.out.println(""+generatePalindrome(5));
//    System.out.println(""+generatePalindrome(6));
//    System.out.println(""+generatePalindrome(7));
//    System.out.println(""+generatePalindrome(8));
//    System.out.println(""+generatePalindrome(9));
//    System.out.println(""+generatePalindrome(10));
//    System.out.println(""+generatePalindrome(11));
//    System.out.println(""+generatePalindrome(12));
  }
  public static int generatePalindrome(int n) {
    if(n<=2){
      return n;
    }
    LinkedList<Integer> linkedList= new LinkedList<>();
    int i=2;
    linkedList.add(1);
    linkedList.add(2);
    while(true){

      int x= linkedList.pop();
     // System.out.println("x-->"+x);
      int y= x*10+1;
      int z= x*10+2;

      if(i+1==n){
        return y;
      }
      if(i+2==n){
        return z;
      }
      i+=2;
      linkedList.add(y);
      linkedList.add(z);
    }
   // return 0;
  }
  public static String generatePalindrome2(int n) {
    StringBuilder sb = new StringBuilder();
    String s = Integer.toString(n);
    for (int i = 0; i < s.length(); i++) {
      sb.append(s.charAt(i));
    }
    for (int i = s.length() - 1; i >= 0; i--) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }

  public static boolean isPerfectNumber(String s) {
    if (s.charAt(0) != '1') {
      return false;
    }
    if (s.charAt(s.length() - 1) != '1') {
      return false;
    }
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '1' && s.charAt(i) != '2') {
        return false;
      }
    }
    return true;
  }
}
