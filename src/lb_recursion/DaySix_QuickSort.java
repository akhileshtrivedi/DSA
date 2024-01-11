package lb_recursion;

import java.util.Arrays;

public class DaySix_QuickSort {

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  private static int partition(int[] arr, int s, int e) {

    int pivot = arr[s];
    int count = 0;
    for (int i = s + 1; i <= e; i++) {
      if (arr[i] <= pivot) {
        count++;
      }
    }
    int pivotIndex = s + count;
    swap(arr, s, pivotIndex);

    int i = s, j = e;
    while (i < pivotIndex && j > pivotIndex) {
      while (arr[i] <= pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }
      if (i < pivotIndex && j > pivotIndex) {
        swap(arr, i++, j--);
      }
    }
    return pivotIndex;
  }

  private static void quickSort(int[] arr, int s, int e) {
    //Base case
    if (s >= e) {
      return;
    }
    // Pivot value
    int partitionInt = partition(arr, s, e);
    // For left part
    quickSort(arr, s, partitionInt - 1);
    //For Right part
    quickSort(arr, partitionInt+1 , e);
  }

  public static void main(String[] args) {
    int arr[] = {2, 5, 6, 8, 1, 10, 4, 9, 7, 3};
    int n = 10;
    quickSort(arr, 0, n - 1);
    System.out.println("" + Arrays.toString(arr));
  }

}


// selection, merge,insertion,  quick, radix sort(position)
//Count sort