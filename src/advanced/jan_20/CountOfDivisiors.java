package advanced.jan_20;

import java.util.ArrayList;
import java.util.Arrays;

public class CountOfDivisiors {
  static void countIndex(int []A)
  {
    int N = A.length;
    // Stores the maximum integer in []A
    int MAX = Arrays.stream(A).max().getAsInt();

    // Stores the frequency of each
    // element in the array []A

    int []freq = new int[MAX + 1];

    for (int i = 0; i < N; i++)
      freq[A[i]]++;

    // Stores the valid integers in []A
    // for all integers from 1 to MAX
    int []res = new int[MAX + 1];

    for (int i = 1; i <= MAX; ++i) {
      for (int j = i; j <= MAX; j += i) {

        // Case where P = Q
        if (i == j) {

          // Subtract 1 because P & Q
          // cannot have same index
          res[i] += (freq[j] - 1);
        }
        else {
          // Case 1
          res[i] += freq[j];

          // Case 2
          res[j] += freq[i];
        }
      }
    }

    // Loop to print answer for
    // each index of array []A
    for (int i = 0; i < N; i++) {
      System.out.print(res[A[i]]+ " ");
    }
  }
  private  static ArrayList<Integer> solve(ArrayList<Integer> A) {

    ArrayList<Integer> result= new ArrayList<Integer>();

    for(int i=0; i<A.size(); i++){

      int count= getDivisorsCount(A.get(i));

      result.add(count);
    }
    return result;
  }
  public  static int getDivisorsCount(int num){
    int count=0;
    for(int i=1; i*i <= num ; i++){
      if(num % i==0){
        count++;
        if( i !=num/i){
          count++;
        }
      }
    }
    return count;
  }
  public static void main(String[] args) {
    int []A = { 2, 3, 4, 5 };
    int []A2 = { 8, 9, 10};


    // Function Call
   // countIndex(A);
   // countIndex(A2);

    System.out.println(""+solve(new ArrayList<>(Arrays.asList(2, 3, 4, 5))));
  }
}
