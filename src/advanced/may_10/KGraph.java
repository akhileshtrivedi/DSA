package advanced.may_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class KGraph {

  static int maxn = 300009;
  static int[] arr = new int[maxn];
  static int[] sz = new int[maxn];
  static ArrayList<pair> edges;

  static ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
    ini();
    for (int i = 0; i < B.size(); i++) {
      System.out.println(B.get(i).get(2)+" "+i+" "+B.get(i).get(0)+" "+B.get(i).get(1));
      edges.add(new pair(B.get(i).get(2), i, B.get(i).get(0), B.get(i).get(1)));
    }
    ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(B.size(), -1));
    Collections.sort(edges);
    int i = 0;
    int m = B.size();
    while (i < m) {
      int j = i;
      while (j < m && edges.get(j).a == edges.get(i).a) {
        if (root(edges.get(j).c) != root(edges.get(j).d)) {
          ans.set(edges.get(j).b, 1);
        }
        j++;
      }
      j = i;
      while (j < m && edges.get(j).a == edges.get(i).a) {
        if (root(edges.get(j).c) != root(edges.get(j).d)) {
          un(edges.get(j).c, edges.get(j).d);
        }
        j++;
      }
      i = j;
    }
    return ans;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    al.add(new ArrayList<>(Arrays.asList(1, 2, 2)));
    al.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
    al.add(new ArrayList<>(Arrays.asList(2, 3, 3)));

//    al.add(new ArrayList<>(Arrays.asList(0, 1, 10)));
//    al.add(new ArrayList<>(Arrays.asList(0, 2, 6)));
//    al.add(new ArrayList<>(Arrays.asList(0, 3, 5)));
//    al.add(new ArrayList<>(Arrays.asList(1, 3, 15)));
//    al.add(new ArrayList<>(Arrays.asList(2, 3, 4)));
    System.out.println(al.size());
    System.out.println(solve(al.size(), al));

  }

  /*public int[] solve(int A, int[][] B) {
    ini();
    for (int i = 0; i < B.length; i++)
      edges.add(new pair(B[i][2], i, B[i][0], B[i][1]));
    int[] ans = new int[B.length];
    Collections.sort(edges);
    int i = 0;
    int m = B.length;
    while (i < m) {
      int j = i;
      while (j < m && edges.get(j).a == edges.get(i).a) {
        if (root(edges.get(j).c) != root(edges.get(j).d))
          ans[edges.get(j).b] = 1;
        j++;
      }
      j = i;
      while (j < m && edges.get(j).a == edges.get(i).a) {
        if (root(edges.get(j).c) != root(edges.get(j).d))
          un(edges.get(j).c, edges.get(j).d);
        j++;
      }
      i = j;
    }
    return ans;
  }*/
  public static void ini() {
    edges = new ArrayList<pair>();
    for (int i = 0; i < maxn; i++) {
      arr[i] = i;
      sz[i] = 1;
    }
  }

  public static int root(int a) {
    while (arr[a] != a) {
      arr[a] = arr[arr[a]];
      a = arr[a];
    }
    return a;
  }

  public static void un(int a, int b) {
    int ra = root(a);
    int rb = root(b);
    if (sz[ra] <= sz[rb]) {
      arr[ra] = rb;
      sz[rb] += sz[ra];
    } else {
      arr[rb] = ra;
      sz[ra] += sz[rb];
    }
  }
}

class pair implements Comparable<pair> {

  int a, b, c, d;

  pair(int e, int f, int g, int h) {
    this.a = e;
    this.b = f;
    this.c = g;
    this.d = h;
  }

  @Override
  public int compareTo(pair aa) {
    return this.a - aa.a;
  }

}