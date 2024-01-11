package intermediate.nov_30;

import java.util.*;

public class printAllSubarraysHW {
    public static void printAllSubarraysNaive(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = i; j < nums.length; j++)
            {
                sum += nums[j];

                if (sum == 0) {
                    System.out.println("Subarray [" + i + "," + j + "]");
                }
            }
        }
    }



    public static void printAllSubarrays(int[] nums)
    {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];

            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);

                for (Integer value: list)
                {
                    System.out.println("Subarray [" + (value + 1) + "," +
                            i + "]");
                }
            }

            insert(hashMap, sum, i);
        }

    }
    private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {

        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }
    public static int solve(ArrayList<Integer> A)
    {
        int count=0;
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);

        int sum = 0;

        for (int i = 0; i < A.size(); i++)
        {
            sum += A.get(i);

            if (hashMap.containsKey(sum))
            {
                List<Integer> list = hashMap.get(sum);
                count=count+list.size();
            }

            insert(hashMap, sum, i);
        }
        return count;
    }
    public static void main (String[] args)
    {
        int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

       // printAllSubarrays(nums);
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(1, -1, -2, 2))));
        System.out.println(""+solve(new ArrayList<Integer>(Arrays.asList(-1, 2, -1))));
    }
}
