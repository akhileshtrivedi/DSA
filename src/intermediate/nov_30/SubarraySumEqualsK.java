package intermediate.nov_30;

import java.util.*;

public class SubarraySumEqualsK {
    private static <K, V> void insert(Map<K, List<V>> hashMap, K key, V value) {

        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }

    public static int solveOLD(ArrayList<Integer> A, int B) {
        int nums = A.size();
        if(nums<1 || nums>=50001){
            return 0;
        }
        int count = 0;
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);

        int sum = 0;

        for (int i = 0; i < nums; i++) {
            if(A.get(i)<-1000 || A.get(i)>=1001){
                return 0;
            }
            sum += A.get(i);

            if (hashMap.containsKey(B)) {
                List<Integer> list = hashMap.get(B);
                count = count + list.size();
            }

            insert(hashMap, sum, i);
        }
        return count;
    }

    public static int solve(ArrayList<Integer> A, int B) {
        int nums = A.size();
        if(nums<1 || nums>=50001){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums; i++) {
            int sum = 0;
            for (int j = i; j < nums; j++) {
                if(A.get(j)<-1000 || A.get(j)>=1001){
                    return 0;
                }
                sum += A.get(j);

                if (sum == B)
                    count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(1, 0, 1)), 1));
        System.out.println("" + solveOLD(new ArrayList<Integer>(Arrays.asList(0, 0, 0)), 0));
      // System.out.println("" + solveOLD(new ArrayList<Integer>(Arrays.asList(13, 9, 19, -9, -19, 14, -15)), 15));
      // System.out.println("" + solveOLD(new ArrayList<Integer>(Arrays.asList(-2, 16, -12, 5, 7, -1, 2, 12, 11)), 17));
    }
}
