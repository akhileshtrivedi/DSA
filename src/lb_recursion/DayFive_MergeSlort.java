package lb_recursion;

import java.util.Arrays;

public class DayFive_MergeSlort {

  private static void merge(int arr[], int s, int e) {
    int mid = (s + e) / 2;
    int len1 = mid - s + 1;
    int len2 = e - mid;
    int firstPartArr[] = new int[len1];
    int secondPartArr[] = new int[len2];

    int mainArrayIndex = s;
    for (int i = 0; i < len1; i++) {
      firstPartArr[i] = arr[mainArrayIndex++];
    }
    for (int i = 0; i < len2; i++) {
      secondPartArr[i] = arr[mainArrayIndex++];
    }

    // merge 2 sorted array
    int index1 = 0;
    int index2 = 0;
    mainArrayIndex = s;
    while (index1 < len1 && index2 < len2) {
      if (firstPartArr[index1] < secondPartArr[index2]) {
        arr[mainArrayIndex++] = firstPartArr[index1++];
      } else {
        arr[mainArrayIndex++] = secondPartArr[index2++];
      }
    }
    while (index1 < len1) {
      arr[mainArrayIndex++] = firstPartArr[index1++];
    }
    while (index2 < len2) {
      arr[mainArrayIndex++] = secondPartArr[index2++];
    }
  }

  private static void mergeSort(int arr[], int s, int e) {
    //This is a base condition
    if (s >= e) {
      return;
    }
    // It is a mid point
    int mid = (s + e) / 2;
   //For left part sorting
    mergeSort(arr, s, mid);
    //For right part sorting
    mergeSort(arr, mid + 1, e);

    //After sorting, merging here
    merge(arr, s, e);

  }

  public static void main(String[] args) {
    int arr[] = {2, 5, 6, 1, 9};
    int n = 5;
    mergeSort(arr, 0, n - 1);
    System.out.println(""+ Arrays.toString(arr));
  }

}
