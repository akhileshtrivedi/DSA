package intermediate.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day8 {
  // Assignments
  private static int  getSpecialSubsequencesAG(String A) {
    String SearchString = "AG";
    // char [] ch = A.toCharArray();
    int len = A.length() -1;
    int count = 0;
    int tc = 0;
    for(int i = len; i >= 0; i--) {
      char c = A.charAt(i);
      if (c == 'G')
        count += 1;
      if(c == 'A')
        tc = (tc+count)%1000000007;
    }
    return tc;
  }

  private static ArrayList<Integer> getLeaders(ArrayList<Integer> A) {
    ArrayList<Integer> leaders = new ArrayList<>();
    int leader = A.get(A.size() -1);
    leaders.add(leader);
    for (int i = A.size() - 2; i >= 1; i--) {
      if (A.get(i) > leader) {
        leader = A.get(i);
        leaders.add(leader);
      }
    }
    return leaders;
  }

  private static  int getClosestMinMax(ArrayList<Integer> A) {
    int minValue = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      if (A.get(i) < minValue) {
        minValue = A.get(i);
      }
    }

    int maxValue = A.get(0);
    for (int i = 1; i < A.size(); i++) {
      if (A.get(i) > maxValue) {
        maxValue = A.get(i);
      }
    }

    int pos_min = -1, pos_max = -1, result = Integer.MAX_VALUE;

    for (int i = 0; i < A.size(); i++) {
      if (A.get(i) == minValue) {
        pos_min = i;
      }
      if (A.get(i) == maxValue) {
        pos_max = i;
      }

      if (pos_min != -1 && pos_max != -1) {
        result = Math.min(result, Math.abs(pos_min - pos_max) + 1);
      }
    }

    return result;
  }
  //Homework
  private static int getMaxProfit(final List<Integer> A) {
    if(A.size()<1){
      return 0;
    }
    int min = A.get(0);
    int max = A.get(0);
    if(A.size()==2){
      return A.get(1)>min ? A.get(1)-min : 0;
    }

    for (int i = 1; i < A.size(); i++) {
      if (A.get(i) > max) {
        max = A.get(i);
      }
      if (A.get(i) < min) {
        min = A.get(i);
      }
    }
    return max-min;
  }

  private static long getAmazingSubArrays(String A) {
    int n = A.length();
    long count = 0;
    for(int i = 0; i < A.length(); i++) {
      char ch = A.charAt(i);
      if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
        System.out.println(i+"    "+n);
        System.out.println(count+"    count");
        count += n - i;
      }
    }
    return count%10003;
  }

  private static String getEvenSuarrays(ArrayList<Integer> A) {
    String evenRespo="";
    if(A.size()%2!=0 || A.get(0)%2!=0 || (A.get(A.size()-1))%2!=0){
      return "NO";
    } else{
      return "YES";
    }

  }


  private static int bulbs(int[] A) {
    int count = 0;
    int N= A.length;
    for (int i = 0; i < N; i++)
    {
      if (A[i] == 1 && count%2 == 0)
        continue;

      else if(A[i]  == 0 && count%2 != 0)
        continue;

      else if (A[i]  == 1 && count%2 != 0)
      {
        count++;
      }

      else if (A[i]  == 0 && count%2 == 0)
      {
        count++;
      }
    }
    return count;
  }

  private static int getMaximumPossibleSum(int[] A, int B) {
    int n = A.length;

    int result = 0;

    for (int i = 0; i < B; i++) {
      result += A[i];
    }

    int sum = result;

    for (int i = 0; i < B; i++) {
      sum -= A[B - 1 - i];
      sum += A[n - 1 - i];

      result = Math.max(result, sum);
    }

    return result;
  }
  public static void main(String[] args) {
   // System.out.println(" here-->"+ getSpecialSubsequencesAG( "ABCGAG"));
   // System.out.println(" here-->"+ getLeaders(new ArrayList<>(Arrays.asList(16, 17, 4, 3, 5, 2))));
   // System.out.println(" here-->"+ getClosestMinMax(new ArrayList<>(Arrays.asList(16, 17, 4, 3, 5, 2))));
   // System.out.println(" here-->"+ getMaxProfit(new ArrayList<>(Arrays.asList(16, 17, 4, 3, 5, 2))));
   // System.out.println(" here-->"+ getAmazingSubArrays("ABEC"));
    //System.out.println(" here-->"+ getEvenSuarrays(new ArrayList<>(Arrays.asList(2, 4, 8, 6))));
    int[] a ={5, -2, 3 , 1, 2};
   // System.out.println(" here-->"+ bulbs(a));
    System.out.println(" here-->"+ getMaximumPossibleSum(a,3));

  }
}
