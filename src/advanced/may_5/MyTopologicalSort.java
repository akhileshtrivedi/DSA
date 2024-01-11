package advanced.may_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


class Edge
{
  int src, dest;

  public Edge(int src, int dest)
  {
    this.src = src;
    this.dest = dest;
  }
}
class MyGraph
{
  List<List<Integer>> adjList = null;
  List<Integer> indegree = null;
  MyGraph(List<Edge> edges, int n)
  {
    adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }
    indegree = new ArrayList<>(Collections.nCopies(n, 0));
    for (Edge edge: edges)
    {
      int src = edge.src;
      int dest = edge.dest;
      adjList.get(src).add(dest);
      indegree.set(dest, indegree.get(dest) + 1);
    }
  }
}
public class MyTopologicalSort {
 // static ArrayList<Edge> edges;
  static ArrayList<Integer> doTopologicalSort(MyGraph graph, int n) {
    ArrayList<Integer> L = new ArrayList<>();
    List<Integer> indegree = graph.indegree;
    Stack<Integer> S = new Stack<>();
    for (int i = 0; i < n; i++)
    {
      if (indegree.get(i) == 0) {
        S.add(i);
      }
    }
    while (!S.isEmpty())
    {
      int i = S.pop();
      L.add(i);
      for (int m: graph.adjList.get(i))
      {
        indegree.set(m, indegree.get(m) - 1);
        if (indegree.get(m) == 0) {
          S.add(m);
        }
      }
    }
    for (int i = 0; i < n; i++)
    {
      if (indegree.get(i) != 0) {
        return null;
      }
    }
    return L;
  }

  static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
    ArrayList<Edge> edges=new ArrayList<>();
    for (int i = 0; i < B.size(); i++) {
      System.out.println(B.get(i).get(0).intValue()+" "+B.get(i).get(1).intValue());
      edges.add(new Edge(B.get(i).get(0).intValue(), B.get(i).get(1).intValue()));
     // edges.add(new Edge(6, 3));
    }
   MyGraph graph = new MyGraph(edges, A);
    return  doTopologicalSort(graph, A);
  //  return (ArrayList<Integer>) Collections.<Integer>emptyList();
  }

  public static void main(String[] args)
  {
    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    al.add(new ArrayList<>(Arrays.asList(6, 3)));
    al.add(new ArrayList<>(Arrays.asList(6, 1)));
    al.add(new ArrayList<>(Arrays.asList(5, 1)));
    al.add(new ArrayList<>(Arrays.asList(5, 2)));
    al.add(new ArrayList<>(Arrays.asList(3, 4)));
    al.add(new ArrayList<>(Arrays.asList(4, 2)));
    System.out.println(""+solve(al.size()+1, al));
    // List of graph edges as per the above diagram
   /* List<Edge> edges = Arrays.asList(
        new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
        new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
        new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
    );
   List<Edge> edges = Arrays.asList(
        new Edge(6, 3), new Edge(6, 1), new Edge(5, 1),
        new Edge(5, 2), new Edge(3, 4), new Edge(4, 2)
    );
   /*  List<Edge> edges = Arrays.asList(
        new Edge(1, 2), new Edge(2, 3), new Edge(3, 1));

    // total number of nodes in the graph (labelled from 0 to 7)
    int n = 7;

    // build a graph from the given edges
    MyGraph graph = new MyGraph(edges, n);

    // Perform topological sort
    List<Integer> L = doTopologicalSort(graph, n);

    if (L != null) {
      System.out.print(L);    // print topological order
    }
    else {
      System.out.println("Graph has at least one cycle. " +
          "Topological sorting is not possible");
    }*/
  }
}
