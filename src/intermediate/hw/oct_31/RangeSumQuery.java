package intermediate.hw.oct_31;

import java.util.ArrayList;

public class RangeSumQuery {
    private static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int x = 0; x < B.size(); x++) {
            ArrayList<Integer> firstQuery = B.get(x);
            int sum = 0;
            for (int i = firstQuery.get(0); i <= firstQuery.get(1); i++) {
                sum = sum + A.get(i - 1);
            }
            result.add(sum);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        ArrayList<Integer> al3 = new ArrayList<>();

        ArrayList query = new ArrayList();
        ArrayList query2 = new ArrayList();
        ArrayList query3 = new ArrayList();
        ArrayList<Integer> q1 = new ArrayList<>();
        ArrayList<Integer> q2 = new ArrayList<>();
        ArrayList<Integer> qq1 = new ArrayList<>();
        ArrayList<Integer> qq2 = new ArrayList<>();
        ArrayList<Integer> qqq1 = new ArrayList<>();
        q1.add(1);
        q1.add(4);
        q2.add(2);
        q2.add(3);
        query.add(q1);
        query.add(q2);

        qq1.add(1);
        qq1.add(1);
        qq2.add(2);
        qq2.add(3);
        query2.add(qq1);
        query2.add(qq2);
        qqq1.add(1);
        qqq1.add(1);
        query3.add(qqq1);
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4); // 1, 3
        al.add(5);

        al2.add(2);
        al2.add(2);
        al2.add(2);

        al3.add(6);
        System.out.println(al + " data for first query-->" + query);
        System.out.println("RangeSumQuery-->" + solve(al, query));

        System.out.println(al2 + "   Data for second query-->" + query2);
        System.out.println("RangeSumQuery-->" + solve(al2, query2));

        System.out.println(al3 + "   Data for second query-->" + query3);
        System.out.println("RangeSumQuery-->" + solve(al3, query3));
    }
}
