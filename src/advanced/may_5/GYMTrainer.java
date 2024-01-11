package advanced.may_5;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GYMTrainer {
  static int maxn = 100009;
  static long MOD = 1000000007;
  static int[] par = new int[maxn];
  static int[] sz = new int[maxn];
  public int solve(int A, ArrayList<ArrayList<Integer>> B, ArrayList<ArrayList<Integer>> C) {
    reset();
    int n = A;
    int m = B.size();
    Map< Integer, Integer > mp = new HashMap< Integer, Integer >();
    for (int i = 0; i < m; i++) {
      int u = B.get(i).get(0);
      int v = B.get(i).get(1);
      mp.putIfAbsent(u, 1);
      mp.putIfAbsent(v, 1);
      if (same(u, v) == false)
        un(u, v);
    }
    int flag = 0;
    m = C.size();
    for (int i = 0; i < m; i++) {
      int u = C.get(i).get(0);
      int v = C.get(i).get(1);
      if (mp.containsKey(u) || mp.containsKey(v))
        flag = 1;
      if (same(u, v) == false)
        un(u, v);
    }
    if (flag == 1)
      return 0;
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (par[i] == i)
        cnt++;
    }
    long ret = 1;
    for (int i = 0; i < cnt; i++) {
      ret = (2 * ret) % MOD;
    }
    return (int) ret;
  }

  public int solve(int A, int[][] B, int[][] C) {
    reset();
    int n = A;
    int m = B.length;
    Map< Integer, Integer > mp = new HashMap< Integer, Integer >();
    for (int i = 0; i < m; i++) {
      int u = B[i][0];
      int v = B[i][1];
      mp.putIfAbsent(u, 1);
      mp.putIfAbsent(v, 1);
      if (same(u, v) == false)
        un(u, v);
    }
    int flag = 0;
    m = C.length;
    for (int i = 0; i < m; i++) {
      int u = C[i][0];
      int v = C[i][1];
      if (mp.containsKey(u) || mp.containsKey(v))
        flag = 1;
      if (same(u, v) == false)
        un(u, v);
    }
    if (flag == 1)
      return 0;
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
      if (par[i] == i)
        cnt++;
    }
    long ret = 1;
    for (int i = 0; i < cnt; i++) {
      ret = (2 * ret) % MOD;
    }
    return (int) ret;
  }

  public static void reset() {
    for (int i = 0; i < maxn; i++) {
      par[i] = i;
      sz[i] = 1;
    }
  }
  public static int find(int a) {
    while (par[a] != a) {
      par[a] = par[par[a]];
      a = par[a];
    }
    return a;
  }
  public static boolean same(int x, int y) {
    if (find(x) == find(y))
      return true;
    return false;
  }
  public static void un(int a, int b) {
    int ra = find(a);
    int rb = find(b);
    if (sz[ra] <= sz[rb]) {
      par[ra] = rb;
      sz[rb] += sz[ra];
    } else {
      par[rb] = ra;
      sz[ra] += sz[rb];
    }
  }
}