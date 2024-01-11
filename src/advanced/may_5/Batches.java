package advanced.may_5;

// Java program to find shortest weighted
// cycle in undirected graph

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

// weighted undirected Graph

class Edge1 {

  public int u;
  public int v;
  public int weight;
}

// weighted undirected Graph
class Graph {

  int V;
  List<Tuple<Integer, Integer>>[] adj;
  List<Edge1> edge;

  public Graph(int V) {
    this.V = V;
    adj = new List[V];
    for (int i = 0; i < V; i++) {
      adj[i] = new ArrayList<>();
    }
    edge = new ArrayList<>();
  }

  // function add edge to graph
  public void addEdge(int u, int v, int w) {
    adj[u].add(new Tuple<>(v, w));
    adj[v].add(new Tuple<>(u, w));
    Edge1 e = new Edge1();
    e.u = u;
    e.v = v;
    e.weight = w;
    edge.add(e);
  }

  // function remove edge from undirected graph
  public void removeEdge(int u, int v, int w) {
    adj[u].remove(new Tuple<>(v, w));
    adj[v].remove(new Tuple<>(u, w));
  }

  // find the shortest path from source to sink using
  // Dijkstra’s shortest path algorithm [ Time complexity
  // O(E logV )]
  public int shortestPath(int u, int v) {

    // Create a set to store vertices that are being
    // preprocessed
    SortedSet<Tuple<Integer, Integer>> setds
        = new TreeSet<>();
    // Create a vector for distances and initialize all
    // distances as infinite (INF)
    List<Integer> dist = new ArrayList<>();
    for (int i = 0; i < V; i++) {
      dist.add(Integer.MAX_VALUE);
    }
    // Insert source itself in Set and initialize its
    // distance as 0.
    setds.add(new Tuple<>(0, u));
    dist.set(u, 0);
		/* Looping till all shortest distance are finalized
	then setds will become empty */
    while (!setds.isEmpty()) {
      // The first vertex in Set is the minimum
      // distance vertex, extract it from set.
      Tuple<Integer, Integer> tmp = setds.first();
      setds.remove(tmp);
      int uu = tmp.second;
      for (Tuple<Integer, Integer> i : adj[uu]) {
        int vv = i.first;
        int weight = i.second;
				/* If the distance of v is not INF then it
				must be in our set, so removing it and
				inserting again with updated less
				distance. Note : We extract only those
				vertices from Set for which distance is
				finalized. So for them, we would never
				reach here. */
        if (dist.get(vv) > dist.get(uu) + weight) {
          if (dist.get(vv) != Integer.MAX_VALUE) {
            setds.remove(
                new Tuple<>(dist.get(vv), vv));
          }
          dist.set(vv, dist.get(uu) + weight);
          setds.add(
              new Tuple<>(dist.get(vv), vv));
        }
      }
    }

    // return shortest path from current source to sink
    return dist.get(v);
  }

  // function return minimum weighted cycle
  public int findMinimumCycle() {
    int minCycle = Integer.MAX_VALUE;
    int E = edge.size();
    for (int i = 0; i < E; i++) {
      Edge1 e = edge.get(i);
      // get current edge vertices which we currently
      // remove from graph and then find shortest path
      // between these two vertex using Dijkstra’s
      // shortest path algorithm .
      removeEdge(e.u, e.v, e.weight);
      // minimum distance between these two vertices
      int distance = shortestPath(e.u, e.v);

      // to make a cycle we have to add weight of
      // currently removed edge if this is the
      // shortest cycle then update min_cycle

      minCycle
          = Math.min(minCycle, distance + e.weight)
          + 4;
      addEdge(e.u, e.v, e.weight);
    }
    // return shortest cycle
    return minCycle;
  }
}

class Tuple<T, U> implements Comparable<Tuple<T, U>> {

  public final T first;
  public final U second;

  public Tuple(T first, U second) {
    this.first = first;
    this.second = second;
  }

  public int compareTo(Tuple<T, U> other) {
    if (this.first.equals(other.first)) {
      return this.second.toString().compareTo(
          other.second.toString());
    } else {
      return this.first.toString().compareTo(
          other.first.toString());
    }
  }

  public String toString() {
    return "(" + first.toString() + ", "
        + second.toString() + ")";
  }
}


// Driver code
public class Batches {
  static int maxn = 100009;
  static ArrayList < ArrayList < Integer > > adj;
  static int[] a = new int[maxn];
  static int[] vis = new int[maxn];
  static int sum = 0;
  public int solve(int A, int[] B, int[][] C, int D) {
    graph();
    for (int[] edge: C) {
      adj.get(edge[0]).add(edge[1]);
      adj.get(edge[1]).add(edge[0]);
    }
    for (int i = 0; i < B.length; i++)
      a[i + 1] = B[i];
    int ans = 0;
    for (int i = 1; i <= A; i++) {
      if (vis[i] == 0) {
        sum = 0;
        dfs(i);
        if (sum >= D)
          ++ans;
      }
    }
    return ans;
  }
  public static void graph() {
    adj = new ArrayList < ArrayList < Integer > > (maxn);
    for (int i = 0; i < maxn; i++) {
      vis[i] = 0;
      adj.add(new ArrayList < Integer > ());
    }
  }
  public static void dfs(int x) {
    sum += a[x];
    vis[x] = 1;
    for (int v: adj.get(x)) {
      if (vis[v] == 0)
        dfs(v);
    }
  }
  public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
    graph();
    for (ArrayList edge: C) {
      adj.get((int)edge.get(0)).add((int)edge.get(1));
      adj.get((int)edge.get(1)).add((int)edge.get(0));
    }
    for (int i = 0; i < B.size(); i++)
      a[i + 1] = B.get(i);
    int ans = 0;
    for (int i = 1; i <= A; i++) {
      if (vis[i] == 0) {
        sum = 0;
        dfs(i);
        if (sum >= D)
          ++ans;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
//    int V = 9;
//    Graph g = new Graph(V);
//    g.addEdge(0, 1, 4);
//    g.addEdge(0, 7, 8);
//    g.addEdge(1, 2, 8);
//    g.addEdge(1, 7, 11);
//    g.addEdge(2, 3, 7);
//    g.addEdge(2, 8, 2);
//    g.addEdge(2, 5, 4);
//    g.addEdge(3, 4, 9);
//    g.addEdge(3, 5, 14);
//    g.addEdge(4, 5, 10);
//    g.addEdge(5, 6, 2);
//    g.addEdge(6, 7, 1);
//    g.addEdge(6, 8, 6);
//    g.addEdge(7, 8, 7);
//    System.out.println(g.findMinimumCycle());
  }
}

// This code is contributed by NarasingaNikhil
