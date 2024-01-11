package intermediate.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class Day6 {
  // Assignments sums
  private static int countElementGreaterThanItself(ArrayList<Integer> A) {
    int max = A.get(0);
    int len = A.size();
    int count = 0;
    for (int i = 0; i < len; i++) {
      if (A.get(i) == max) {
        count++;
      } else if (A.get(i) > max) {
        count = 1;
        max = A.get(i);
      }
    }
    return len - count;
  }
  private static int isGoodPair(ArrayList<Integer> A, int B) {
    HashSet<Integer> s = new HashSet<Integer>();
    for (int i = 0; i < A.size(); ++i) {
      int temp = B - A.get(i);
      if (s.contains(temp)) {
        return 1;
      }
      s.add(A.get(i));
    }
    return 0;
  }
  private static ArrayList<Integer> getReverseInRange(ArrayList<Integer> A, int B, int C) {
    // Arraylist for storing reversed elements
    // LinkedList<Integer> revArrayList = new LinkedList<Integer>(A);
    for (; B <= C; B++, C--) {
      int temp = A.get(B);
      A.set(B, A.get(C));
      A.set(C, temp);
    }
    return A;
  }

  private static ArrayList<Integer> getReverseArray(final List<Integer> A) {
    ArrayList<Integer> tmpList = new ArrayList<>(A);
   // Collections.reverse(tmpList);
    int n=tmpList.size();
    int j=n-1;
    for(int i=0;i<n/2;i++){
      int temp = tmpList.get(i);
      tmpList.set(i, tmpList.get(j));
      tmpList.set(j, temp);
      j--;
    }

    return tmpList;
  }
  private static ArrayList<Integer> getArrayRotation(ArrayList<Integer> A, int B) {
    Collections.rotate(A, B);
    return A;
  }
// Homework
private static int getSumOfMaxAndMin(ArrayList<Integer> A) {
  int sum = 0;
  int minVal = A.get(0);
  int maxVal  = A.get(0);

 /* for(int i=1;i<A.size();i++) {

    if(minVal>A.get(i)) {
      minVal = A.get(i);
    }

    if(maxVal<A.get(i)) {
      maxVal = A.get(i);
    }

  }*/
   maxVal = Collections.max(A);
  System.out.println("Maximum is : " + maxVal);

   minVal = Collections.min(A);
  System.out.println("Minimum is : " + minVal);
  sum = minVal + maxVal;

  return sum;
}
  private static int getOccurrences(int[] A, int B) {
    int occurrence = 0;
    for(int i=0;i<A.length;i++){
      if(B==A[i]) {
        occurrence++;
      }
    }
    return occurrence;
  }
  private static int getSecondLargest(int[] A) {
    LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
    lhs.addAll(Arrays.stream(A).boxed().toList());
    List<Integer> arl = new LinkedList<Integer>();
    arl.addAll(lhs);
    System.out.println("arl-->"+arl);
    return arl.get(arl.size()-2);
  }
  private static int getTimeToEquality(int[] A) {
    int temp = 0;
    int largestVal = 0;
    int timeReq = 0;
    for(int i=0;i<A.length-1;i++){
      if(A[i]>A[i+1]) {
        temp = A[i];
        A[i] = A[i+1];
        A[i+1] = temp;
      }
    }

    largestVal = A[A.length-1];

    for(int i=0;i<A.length;i++){
      while(largestVal>A[i]) {
        A[i]++;
        timeReq++;
      }
    }
    return timeReq;
  }

  private static ArrayList<Integer> getRangeSumQuery(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int x = 0; x < B.size(); x++) {
      ArrayList<Integer> firstQuery = B.get(x);
      int sum = 0;
      for (int i = firstQuery.get(0); i <= firstQuery.get(1); i++) {
        sum = sum + A.get(i - 1);
      }
      result.add(sum);
    }
    return result;
  }


  public static void main(String[] args) {
   // System.out.println("Total count-->"+countElementGreaterThanItself(new ArrayList<Integer>(Arrays.asList(3, 1, 2))));
   // System.out.println("Total count-->"+isGoodPair(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),7));
   // System.out.println("Total count-->"+getReverseInRange(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),2,3));
   // System.out.println("Total count-->"+getReverseArray(new ArrayList<Integer>(Arrays.asList(1,1,10,1,7))));
   // System.out.println("Total count-->"+getArrayRotation(new ArrayList<Integer>(Arrays.asList(1,1,10,1,7)),2));
   // System.out.println("Total count-->"+getSumOfMaxAndMin(new ArrayList<Integer>(Arrays.asList(-2, 1, -4, 5, 3))));
   // System.out.println("Total count-->"+getSumOfMaxAndMin(new ArrayList<Integer>(Arrays.asList(-2, 1, -4, 5, 3))));
    ArrayList al= new ArrayList<>();
    al.add(new ArrayList<Integer>(Arrays.asList(1,4)));
    al.add(new ArrayList<Integer>(Arrays.asList(2,3)));

   System.out.println("Total count-->"+getRangeSumQuery(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)),al));
   int[] a ={2, 4, 1, 3, 2};
 //System.out.println("Total count-->"+getOccurrences(a,3));
 //System.out.println("Total count-->"+getSecondLargest(a));
// System.out.println("Total count-->"+getTimeToEquality(a));

  }

}
