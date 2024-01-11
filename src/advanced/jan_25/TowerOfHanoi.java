package advanced.jan_25;

import java.util.ArrayList;

public class TowerOfHanoi {

  /* static void towerOfHanoi(int n, char from_rod,
       char to_rod, char aux_rod)
   {
     if (n == 0) {
       return;
     }
     towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
     System.out.println("Move disk " + n + " from rod "
         + from_rod + " to rod "
         + to_rod);
     towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
   }*/
  static ArrayList<ArrayList<Integer>> towerOfHanoi(int n, int from_rod,
      int to_rod, int aux_rod, ArrayList<ArrayList<Integer>> al) {

    if (n == 0) {
      return al;
    }

    towerOfHanoi(n - 1, from_rod, aux_rod, to_rod, al);

    ArrayList<Integer> data = new ArrayList<Integer>();
   // data.add(Integer.valueOf((n * 100) +" "+ (from_rod * 10) +" "+  to_rod));
   // data.add(Integer.valueOf(n +" "+ from_rod+" "+  to_rod));
    data.add(n);
    data.add(from_rod);
    data.add(to_rod);
    al.add(data);
    towerOfHanoi(n - 1, aux_rod, to_rod, from_rod, al);
    return al;
  }

  private static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
    ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
    int N = 3;

    // A, B and C are names of rods
    //towerOfHanoi(N, 'A', 'C', 'B');
    towerOfHanoi(N, 1, 3, 2, al);
    return al;
  }

  //  Driver method
  public static void main(String args[]) {
    int n = 1; // Number of disks
    System.out.println("" + towerOfHanoi(n));
    ;  // A, B and C are names of rods
  }

}
