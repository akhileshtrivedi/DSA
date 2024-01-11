package advanced.may_10;

import java.io.*;
    import java.util.*;

// Class to form pair
class Pair implements Comparable<Pair>
{
  int v;
  int wt;
  Pair(int v,int wt)
  {
    this.v=v;
    this.wt=wt;
  }
  public int compareTo(Pair that)
  {
    return this.wt-that.wt;
  }
}

class PrimAlgo {

  // Function of spanning tree
 // static int spanningTree(int V,int edges[][])
  static ArrayList<Integer> spanningTree(int A, ArrayList<ArrayList<Integer>> B)
  {
    ArrayList<Integer> ans = new ArrayList<>();

    int V=A;
    int E=A;
    ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
    for(int i=0;i<V;i++)
    {
      adj.add(new ArrayList<Pair>());
    }
    for(int i=0;i<B.size();i++)
    {
      int u=B.get(i).get(0);
      int v=B.get(i).get(1);
      int wt=B.get(i).get(2);
      adj.get(u).add(new Pair(v,wt));
      adj.get(v).add(new Pair(u,wt));
    }
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    pq.add(new Pair(0,0));
    int[] vis=new int[V];
    int s=0;
    while(!pq.isEmpty())
    {
      Pair node=pq.poll();
      int v=node.v;
      int wt=node.wt;
      if(vis[v]==1)
        continue;

      ans.add(wt);
      vis[v]=1;
      for(Pair it:adj.get(v))
      {
        if(vis[it.v]==0)
        {
          pq.add(new Pair(it.v,it.wt));
        }
      }
    }
    return ans;
  }

  // Driver code
  public static void main (String[] args) {
    int graph[][] = new int[][] {{1, 2, 2},
        {1, 3, 2},
        {2, 3, 3}};
    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    al.add(new ArrayList<>(Arrays.asList(0,1,5)));
    al.add(new ArrayList<>(Arrays.asList(1,2,3)));
    al.add(new ArrayList<>(Arrays.asList(0,2,1)));
    // Function call
    System.out.println(spanningTree(3,al));
  }
}
