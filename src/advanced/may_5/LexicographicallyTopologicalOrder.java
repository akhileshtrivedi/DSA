package advanced.may_5;

import java.util.*;

class LexicographicallyTopologicalOrder
{
  static List<List<Integer>> adj;
  static void addEdge(int x,int y)
  {
    adj.get(x).add(y);
  }
  static ArrayList<Integer> topologicalSort()
  {
    int V = adj.size();
    int[] in_degree = new int[V];
    Arrays.fill(in_degree, 0);

    for (int u = 0; u < V; u++) {
      for (int x: adj.get(u))
        in_degree[x]++;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < V; i++)
      if (in_degree[i] == 0)
        queue.add(i);

    int cnt = 0;

    ArrayList<Integer> top_order = new ArrayList<>();

    while (!queue.isEmpty()) {
      int u = queue.poll();
      top_order.add(u);

      for (int x: adj.get(u))

        if (--in_degree[x] == 0)
          queue.add(x);

      cnt++;
    }

    if (cnt != V) {
     // System.out.println(-1);
      return new ArrayList<Integer>();
    }
    top_order.remove(0);
    return  top_order;
  }

  static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
    int v = A+1;
    adj = new ArrayList<>(v);
    for (int i = 0; i < v; i++) {
      adj.add(new ArrayList<>());
    }

    for (int i = 0; i < B.size(); i++) {
      addEdge(B.get(i).get(0).intValue(), B.get(i).get(1).intValue());
    }
    return topologicalSort();
  }


  public static void main (String[] args)
  {


   /* addEdge(5,2);
    addEdge(5,0);
    addEdge(4,0);
    addEdge(4,1);
    addEdge(2,3);
    addEdge(3,1);
    addEdge(6,3);
    addEdge(6,1);
    addEdge(5,1);
    addEdge(5,2);
    addEdge(3,4);
    addEdge(4,2);

    // find required topological order
    topologicalSort();*/

    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    al.add(new ArrayList<>(Arrays.asList(6, 3)));
    al.add(new ArrayList<>(Arrays.asList(6, 1)));
    al.add(new ArrayList<>(Arrays.asList(5, 1)));
    al.add(new ArrayList<>(Arrays.asList(5, 2)));
    al.add(new ArrayList<>(Arrays.asList(3, 4)));
    al.add(new ArrayList<>(Arrays.asList(4, 2)));
    System.out.println(" I am here "+solve(al.size(), al));
  }
}

// This code is contributed by lokeshpotta20.
