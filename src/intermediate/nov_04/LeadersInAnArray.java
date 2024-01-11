package intermediate.nov_04;

import java.util.ArrayList;

public class LeadersInAnArray {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int leader = A.get(A.size() -1);
        leaders.add(leader);
        for (int i = A.size() - 2; i >= 1; i--) {
            if (A.get(i) > leader) {
                leader = A.get(i);
                leaders.add(leader);
            }
        }
        return leaders;
    }

    public static void main(String[] args) {
        // A = [16, 17, 4, 3, 5, 2]     [17, 2, 5]
        // A = [1, 2]     //[2]
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        al.add(16);
        al.add(17);
        al.add(4);
        al.add(3);
        al.add(5);
        al.add(2);

        al2.add(1);
        al2.add(2);
        System.out.println(" I am here" + solve(al));
        System.out.println(" I am here" + solve(al2));
    }
}
