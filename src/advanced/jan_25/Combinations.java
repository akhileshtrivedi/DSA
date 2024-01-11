package advanced.jan_25;


import java.util.ArrayList;
import java.util.Vector;

class Combinations {

 // static Vector<Vector<Integer>> ans = new Vector<Vector<Integer>>();
  //static Vector<Integer> tmp = new Vector<Integer>();
  static ArrayList<ArrayList<Integer>> makeCombiUtilOLD(int n, int left, int k,ArrayList<ArrayList<Integer>>  ans)
  {
    System.out.println(n+" "+left+" "+k);
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    if (k == 0) {
      ans.add(tmp);
      for(int i = 0; i < tmp.size(); i++)
      {
        System.out.print(tmp.get(i) + " ");
      }
      System.out.println();
      return ans;
    }

    for (int i = left; i <= n; ++i)
    {
      tmp.add(i);
      ans.add(tmp);
      makeCombiUtilOLD(n, i + 1, k - 1, ans);
      tmp.remove(tmp.size() - 1);
    }
    return ans;
  }
  static ArrayList<ArrayList<Integer>> makeCombiOLD(int n, int k)
  {
    ArrayList<ArrayList<Integer>> ans =new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> A = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<>();
   // ans=makeCombiUtilOLD(n, 1, k,ans);
    //return ans;

    for (int i = 1; i<n+1; ++i) {
      A.add(i);
    }

   // makeCombiUtilOLD(0, k, result, A, row);
    return ans;
  }

  public static void main (String[] args) {
   // System.out.println( " "+makeCombi(4, 2));
    System.out.println( " ");
  //  System.out.println( " "+makeCombi(3, 2));
    System.out.println( " "+makeCombiOLD(4, 2));
    System.out.println( " "+makeCombiOLD(3, 2));

  }
}
