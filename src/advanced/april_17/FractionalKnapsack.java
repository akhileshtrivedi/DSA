package advanced.april_17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Greedy approach
public class FractionalKnapsack {

  // Function to get maximum value
  private static double getMaxValue(ItemValue[] arr,
      int capacity) {
    // Sorting items by profit/weight ratio;
    Arrays.sort(arr, new Comparator<ItemValue>() {
      @Override
      public int compare(ItemValue item1,
          ItemValue item2) {
        double cpr1
            = (double) item1.profit
            / (double) item1.weight;
        double cpr2
            = (double) item2.profit
            / (double) item2.weight;

        if (cpr1 < cpr2) {
          return 1;
        } else {
          return -1;
        }
      }
    });

    double totalValue = 0d;

    for (ItemValue i : arr) {

      int curWt = (int) i.weight;
      int curVal = (int) i.profit;

      if (capacity - curWt >= 0) {

        // This weight can be picked whole
        capacity = capacity - curWt;
        totalValue += curVal;
      } else {

        // Item cant be picked whole
        double fraction
            = ((double) capacity / (double) curWt);
        totalValue += (curVal * fraction);
        capacity
            = (int) (capacity - (curWt * fraction));
        break;
      }
    }

    return totalValue;
  }

  // Item value class
  static class ItemValue {

    int profit, weight;

    // Item value function
    public ItemValue(int val, int wt) {
      this.weight = wt;
      this.profit = val;
    }
  }
  static int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
    ItemValue[] arr = new ItemValue[A.size()];
    for(int i=0;i<A.size();i++){
      arr[i]= new ItemValue(A.get(i), B.get(i));
    }


    double maxValue = getMaxValue(arr, C);
    maxValue=maxValue*100;
    System.out.println("maxValue--->"+maxValue);
    return (int)maxValue;
  }
  // Driver code
  public static void main(String[] args) {
//
//    ItemValue[] arr = {new ItemValue(60, 10),
//        new ItemValue(100, 20),
//        new ItemValue(120, 30)};
//
//    int capacity = 50;
//
//    double maxValue = getMaxValue(arr, capacity);

    // Function call
    System.out.println(solve(new ArrayList<>(Arrays.asList(10, 20, 30, 40)),new ArrayList<>(Arrays.asList(12, 13, 15, 19)), 10));
  }
}
