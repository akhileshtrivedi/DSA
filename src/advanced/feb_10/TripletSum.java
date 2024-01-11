package advanced.feb_10;

import java.util.ArrayList;
import java.util.Arrays;

public class TripletSum {
  public static int tripletSum( ArrayList<Integer> A, int B) {
    int numberPairs = 0;
    int[] arr= A.stream().mapToInt(i->i).toArray();
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          if (arr[i] + arr[j] + arr[k] == B) {
            numberPairs++;
          }
        }
      }
    }
    return numberPairs;
  }
  private static int solve(ArrayList<Integer> A, int B) {
    int[] nums=A.stream().mapToInt(i->i).toArray();
      Arrays.sort(nums);

      int n = nums.length;
      for (int i = 0; i <= n - 3; i++)
      {
        int k = B - nums[i];
        int low = i + 1;
        int high = nums.length - 1;
        //System.out.println(low+"  "+high);
        {
          // increment `low` index if the total is less than the remaining sum
          if (nums[low] + nums[high] < k) {
            low++;
          }

          // decrement `high` index if the total is more than the remaining sum
          else if (nums[low] + nums[high] > k) {
            high--;
          }

          // triplet with the given sum is found
          else {
            // print the triplet
            System.out.println("(" + nums[i] + ", " + nums[low] + ", " +
                nums[high] + ")");

            // increment `low` index and decrement `high` index
            low++;
            high--;
          }
        }
      }
      return 0;
    }

  public static void main(String[] args) {
    ArrayList<Integer> input= new ArrayList<>(Arrays.asList(1, 5, 7, 3, 2 ));
    ArrayList<Integer> input2= new ArrayList<>(Arrays.asList(2, 7, 4, 0, 9, 5, 1, 3 ));
    //solve(A,6);
    System.out.println(solve(input,9));
    //System.out.println(tripletSum(input,6));
  }

}
