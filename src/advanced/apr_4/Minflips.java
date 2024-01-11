package advanced.apr_4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Minflips {
  static int findMinOperations(String A, int B){

    /* Storing the length of Input string */
    char[] S =A.toCharArray();
    int N = A.length();

    /* To store the minimum number of operations required. */
    int minOperations = 0;

    /* Iterating over the string S. */
    for(int ind=0; ind<N; ind++){

            /* If ith character is '0' and there is substring of length K
            present on the right side. */
      int check=(S[ind] - '0');
      if((check == 0) && (ind+B <= N)){

        /* Then flip the substring s[i, i+k]. */
        for(int j=ind; j<ind+B; j++){
          int check_again=(S[j]-'0');
          if(check_again>0){
            S[j] = '0';
          }
          else{
            S[j] = '1';
          }
        }

        /* Incrementing the answer since we performed a flip. */
        minOperations++;
      }
    }

    boolean zeroPresent = false;

    /* Checking if the string still contains a zero. */
    for(int i=0; i<N; i++){
      if(S[i] == '0')zeroPresent = true;
    }

        /* If there still exists a zero then return -1 otherwise return
        minimum number of operations required. */
    return (zeroPresent ? -1 : minOperations);
  }
  static int minKBitFlips(int[] nums, int k) {
    int ans = 0;
    boolean flip = false;
    Queue<Integer> turns = new ArrayDeque<Integer>();
    for (int i = 0; i < nums.length - k + 1; i++) {
      int bit = nums[i];
      if (!turns.isEmpty() && i == turns.peek()) {
        flip = !flip;
        turns.remove();
      }
      if (flip) {
        bit = 1 - bit;
      }
      if (bit == 0) {
        turns.add(i+k);
        flip = !flip;
        ans++;
      }
    }
    for (int i = nums.length - k + 1; i < nums.length; i++) {
      int bit = nums[i];
      if (!turns.isEmpty() && i == turns.peek()) {
        flip = !flip;
        turns.remove();
      }
      if (flip) bit = 1 - bit;
      if (bit == 0) return -1;
    }
    return ans;
  }

  public static void main(String[] args) {
   // try (Scanner sc = new Scanner(System.in)) {
     // char[] str= sc.next().toCharArray();
    //  int K=sc.nextInt();
      // Call function
    // .
    String str="00010110";
    //int K=3;
   // String str="011";
    int K=3;
     // int ans = findMinOperations(str, K);

    int[] num = new int[str.length()];

    for (int i = 0; i < str.length(); i++){
      num[i] = str.charAt(i) - '0';
    }

      System.out.print("Minimum operations required are : ");
      // Print the final answer.
    //  System.out.print(ans);
      System.out.println(""+minKBitFlips(num,K));
      System.out.println();
   // }
  }
}