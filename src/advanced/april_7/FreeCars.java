package advanced.april_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FreeCars {
   class Pair
  {
    public final int  first;
    public final int second;
    private Pair(int first, int second)
    {
      this.first = first;
      this.second = second;
    }
  }
  class SortByFirst implements Comparator<Pair> {
    public int compare(Pair a, Pair b)
    {
      return a.first - b.first;
    }
  }
  private  int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
    int n =A.size();
    long profit =0;
    ArrayList<Pair> pairList = new ArrayList<>();
    PriorityQueue<Integer> profitQ = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      pairList.add(new Pair(A.get(i), B.get(i)));
    }
    Collections.sort(pairList, new SortByFirst());
    int t = 0;
    for (int i = 0; i < n; i++) {
      Pair p = pairList.get(i);
      if(t<p.first){
        profitQ.add(p.second);
        t++;
      } else if (t>=p.first) {
        if(profitQ.peek() < p.second) {
          profitQ.poll();
          profitQ.add(p.second);
        }
      }
    }
    //System.out.println(Arrays.toString(profitQ.toArray()));
    int size=profitQ.size();
    for(int i=0;i<size;i++){
      profit=profit+profitQ.poll();
    }
    return (int)(profit%1000000007);
  }
  public static void main(String[] args) {
    FreeCars freeCars = new FreeCars();
    System.out.println("Max profit--> "+freeCars.solve(new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3)),new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9))));
    System.out.println("Max profit--> "+freeCars.solve(new ArrayList<>(Arrays.asList(3, 8, 7, 5)),new ArrayList<>(Arrays.asList(3, 1, 7, 19))));

  }

}
