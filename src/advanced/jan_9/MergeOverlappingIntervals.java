package advanced.jan_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


// An Interval


class Interval {

  int start, end;

  Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class MergeOverlappingIntervals {

  public static void mergeIntervals(Interval arr[]) {

    Arrays.sort(arr, new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });

    int index = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[index].end >= arr[i].start) {
        arr[index].end = Math.max(arr[index].end, arr[i].end);
      } else {
        index++;
        arr[index] = arr[i];
      }
    }

    System.out.print("The Merged Intervals are: ");
    for (int i = 0; i <= index; i++) {
      System.out.print("[" + arr[i].start + ","
          + arr[i].end + "]");
    }
  }

  static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    ArrayList<Interval> result = new ArrayList<Interval>(0);
    Interval[] arr = new Interval[intervals.size()];
    arr = intervals.toArray(arr);
    Arrays.sort(arr, new Comparator<Interval>() {
      public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
      }
    });

    int index = 0;

    for (int i = 1; i < arr.length; i++) {
      if (arr[index].end >= arr[i].start) {
        arr[index].end = Math.max(arr[index].end, arr[i].end);
      } else {
        index++;
        arr[index] = arr[i];
      }
    }

    for (int i = 0; i <= index; i++) {
      result.add(new Interval(arr[i].start, arr[i].end));
    }
    return result;

  }


  // Driver Code
  public static void main(String args[]) {
    // A : [ (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6) ]
    Interval arr[] = new Interval[6];
    arr[0] = new Interval(1, 10);
    arr[1] = new Interval(2, 9);
    arr[2] = new Interval(3, 8);
    arr[3] = new Interval(4, 7);
    arr[4] = new Interval(5, 6);
    arr[5] = new Interval(6, 6);
    // arr[3] = new Interval(4, 7);
    //  mergeIntervals(arr);
    ArrayList<Interval> al = new ArrayList<Interval>();
    al.add(new Interval(1, 10));
    al.add(new Interval(2, 9));
    al.add(new Interval(3, 8));
    al.add(new Interval(4, 7));
    al.add(new Interval(5, 6));
    al.add(new Interval(6, 6));



    System.out.println("" + merge(al));
  }
}

