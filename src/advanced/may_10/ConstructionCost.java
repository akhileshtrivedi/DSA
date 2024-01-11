package advanced.may_10;

// Java implementation of the approach
import java.util.*;
    import java.lang.*;
    import java.io.*;

class ConstructionCost{

  // Max number of nodes given
  static int N = 500 + 10;

  static class pair
  {
    double c;
    int first, second;

    pair(double c, int first, int second)
    {
      this.c = c;
      this.first = first;
      this.second = second;
    }
  }

  // arr is the parent array
// sz is the size of the
// subtree in DSU
  static int[] arr = new int[N],
      sz = new int[N];

  // Function to initialize the parent
// and size array for DSU
  static void initialize()
  {
    for(int i = 1; i < N; ++i)
    {
      arr[i] = i;
      sz[i] = 1;
    }
  }

  // Function to return the
// parent of the node
  static int root(int i)
  {
    while (arr[i] != i)
      i = arr[i];

    return i;
  }

  // Function to perform the
// merge operation
  static void union(int a, int b)
  {
    a = root(a);
    b = root(b);

    if (a != b)
    {
      if (sz[a] < sz[b])
      {
        int tmp = a;
        a = b;
        b = tmp;
      }

      sz[a] += sz[b];
      arr[b] = a;
    }
  }

  // Function to return the minimum
// cost required
  static double minCost(int[][] p)
  {

    // Number of points
    int n = (int)p.length;

    // To store the cost of every possible pair
    // as { cost, {to, from}}.
    ArrayList<pair> cost = new ArrayList<>();

    // Calculating the cost of every possible pair
    for(int i = 0; i < n; ++i)
    {
      for(int j = 0; j < n; ++j)
      {
        if (i != j)
        {

          // Getting Manhattan distance
          int x = Math.abs(p[i][0] - p[j][0]) +
              Math.abs(p[i][1] - p[j][1]);

          // If the distance is 1 the cost is 0
          // or already connected
          if (x == 1)
          {
            cost.add(new pair( 0, i + 1,
                j + 1 ));
            cost.add(new pair( 0, j + 1,
                i + 1 ));
          }
          else
          {

            // Calculating the euclidean
            // distance
            int a = p[i][0] - p[j][0];
            int b = p[i][1] - p[j][1];
            a *= a;
            b *= b;

            double d = Math.sqrt(a + b);
            cost.add(new pair(d, i + 1,
                j + 1 ));
            cost.add(new pair(d, j + 1,
                i + 1));
          }
        }
      }
    }

    // Krushkal Algorithm for Minimum
    // spanning tree
    Collections.sort(cost, new Comparator<>()
    {
      public int compare(pair a, pair b)
      {
        if(a.c <= b.c)
          return -1;
        else
          return 1;
      }
    });

    // To initialize the size and
    // parent array
    initialize();

    double ans = 0.00;
    for(pair i : cost)
    {
      double c = i.c;
      int a = i.first;
      int b = i.second;

      // If the parents are different
      if (root(a) != root(b))
      {
        union(a, b);
        ans += c;
      }
    }
    return ans;
  }

  // Driver code
  public static void main(String[] args)
  {

    // Vector pairs of points
    int[][] points = { { 1, 1 },
        { 2, 2 },
        { 2, 3 }};

    // Function calling and printing
    // the answer
    System.out.format("%.5f", minCost(points));
  }
}

// This code is contributed by offbeat
