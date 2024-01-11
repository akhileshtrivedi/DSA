package advanced.apr_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class FinishJobs {

  // Pair class
  static class Pair {

    int first;
    int second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  static int SelectActivities(ArrayList<Integer> s, ArrayList<Integer> f) {
    int count = 0;
    ArrayList<Pair> ans = new ArrayList<>();
    PriorityQueue<Pair> p = new PriorityQueue<>(
        (p1, p2) -> p1.first - p2.first);

    for (int i = 0; i < s.size(); i++) {

      p.add(new Pair(f.get(i), s.get(i)));
    }

    Pair it = p.poll();
    int start = it.second;
    int end = it.first;
    ans.add(new Pair(start, end));

    while (!p.isEmpty()) {
      Pair itr = p.poll();
      if (itr.second >= end) {
        start = itr.second;
        end = itr.first;
        ans.add(new Pair(start, end));
      }
    }


    for (Pair itr : ans) {
      count++;
      System.out.println(
          "Activity started at " + itr.first
              + " and ends at " + itr.second);
    }
    return count;
  }

  // Driver Code
  public static void main(String[] args) {

    System.out.println(" " + SelectActivities(new ArrayList<Integer>(Arrays.asList(3, 2, 6)),
        new ArrayList<Integer>(Arrays.asList(9, 8, 9))));
  }
}

// This code is contributed by Debojyoti Mandal
