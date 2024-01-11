package lb_recursion;

import java.util.Arrays;

public class DayFive {

  private static void merge(int[] arr, int s, int e) {
    int mid = (s + e) / 2;
    System.out.println(s+"  "+mid+"   "+e);
    int firstSize = mid - s+1;
    int secondSize = e - mid;
    System.out.println(firstSize+"      "+secondSize);
    int[] firstPart = new int[firstSize];
    int[] secondPart = new int[secondSize];
    int mainArrayIndex = s;

    for (int i = 0; i < firstSize; i++) {
      firstPart[i] = arr[mainArrayIndex++];
    }
    for (int i = 0; i < secondSize; i++) {
      secondPart[i] = arr[mainArrayIndex++];
    }

    int k = mid + 1;
    int index1 = 0;
    int index2 = 0;
    mainArrayIndex = s;

    while (index1 < firstSize && index2 < secondSize) {
      if (firstPart[index1] < secondPart[index2]) {
        arr[mainArrayIndex++] = firstPart[index1++];
      } else {
        arr[mainArrayIndex++] = secondPart[index2++];
      }
    }
    while (index1 < firstSize) {
      arr[mainArrayIndex++] = firstPart[index1++];
    }
    while (index2 < secondSize) {
      arr[mainArrayIndex++] = secondPart[index2++];
    }
  }

  private static void mergeSort(int[] arr, int s, int e) {
    if (s >= e) {
      return;
    }

    int mid = (s + e) / 2;
    mergeSort(arr, s, mid);
    mergeSort(arr, mid + 1, e);
    merge(arr, s, e);
  }


  public static void main(String[] args) {
    int arr[] = {2, 5, 6, 8, 1, 10, 4, 9, 7, 3};
    int n = 10;
    mergeSort(arr, 0, n - 1);
    System.out.println("" + Arrays.toString(arr));
  }

}
