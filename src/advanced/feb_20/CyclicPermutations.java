package advanced.feb_20;


import java.util.Arrays;

public class CyclicPermutations{

  static void compute_z(String s, int z[])
  {
    System.out.println(s+"   "+ Arrays.toString(z));
    int l = 0, r = 0;
    int n = s.length();
    for (int i = 1; i <= n - 1; i++) {
      if (i > r) {
        l = i;
        r = i;
        while (r < n && s.charAt(r - l) == s.charAt(r))
          r++;
        z[i] = r - l;
        r--;
      }
      else {
        int k = i - l;
        if (z[k] < r - i + 1) {
          z[i] = z[k];
        }
        else {
          l = i;
          while (r < n && s.charAt(r - l) == s.charAt(r))
            r++;
          z[i] = r - l;
          r--;
        }
      }
    }
  }

  static int countPermutation(String A, String B)
  {
    B = B + B;
    B = B.substring(0, B.length() - 1);
    int ans = 0;
    String s = A + "$" + B;
    int n = s.length();
    int z[] = new int[n];
    compute_z(s, z);

    for (int i = 1; i <= n - 1; i++) {
      if (z[i] == A.length())
        ans++;
    }
    return ans;
  }


  // Driver Code
  public static void main(String []args){

    String a = "11";
    String b = "11";
    System.out.println(countPermutation(a, b)) ;
  }

}
