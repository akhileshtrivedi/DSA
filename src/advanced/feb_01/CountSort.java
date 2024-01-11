package advanced.feb_01;

// Java implementation of Counting Sort

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class CountSort {

  void countSort(int array[], int size) {
    int[] output = new int[size + 1];

    // Find the largest element of the array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    int[] count = new int[max + 1];

    // Initialize count array with all zeros.
    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    // Store the count of each element
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }

    // Store the cummulative count of each array
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }

    // Copy the sorted elements into original array
    for (int i = 0; i < size; i++) {
      array[i] = output[i];
    }
  }


  private static ArrayList<Integer> solve(ArrayList<Integer> A) {
    //int[] output = new int[size + 1];
    int size=A.size();
    int[] array = A.stream().mapToInt(i -> i).toArray();
    ArrayList<Integer> result = new ArrayList<>();
    int[] output = new int[size + 1];

    // Find the largest element of the array
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    int[] count = new int[max + 1];

    // Initialize count array with all zeros.
    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }

    // Store the count of each element
    for (int i = 0; i < size; i++) {
      count[array[i]]++;
    }
    System.out.println("count--->"+Arrays.toString(count));
    // Store the cummulative count of each array
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }
    System.out.println("output-->"+Arrays.toString(output));
    // Find the index of each element of the original array in count array, and
    // place the elements in output array
    for (int i = size - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }
    System.out.println(Arrays.toString(output));
    //Collections.addAll(result, output);
    for (int i = 0; i <output.length-1; i++) {
      result.add(output[i]);
    }
return result;
  }
  // Driver code
  public static void main(String args[]) {
    // 6, 3, 3, 6, 7, 8, 7, 3, 7
    // 3 3 3 6 6 7 7 7 8
    // 3, 3, 3, 6, 6, 7, 7, 7, 8, 0
    int[] data = {6, 3, 3, 6, 7, 8, 7, 3, 7};
    int size = data.length;
    CountSort cs = new CountSort();
    cs.countSort(data, size);
  //  System.out.println("Sorted Array in Ascending Order: ");
   // System.out.println(Arrays.toString(data));
    ArrayList<Integer> array = new ArrayList<>();
    array.add(4);
    array.add(2);
    array.add(2);
    array.add(8);
    array.add(3);
    array.add(3);
    array.add(1);
   ;
   // System.out.println(""+solve(array));
    System.out.println(""+solve(new ArrayList<>( Arrays.asList(6, 3, 3, 6, 7, 8, 7, 3, 7))));
  }
}