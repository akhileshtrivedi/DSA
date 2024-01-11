package intermediate.dec_21;

import java.io.*;
        import java.util.*;

public class Subset {

    static void printPowerSet(int[] set, int set_size)
    {
        int[][] arr = new int[set_size][];
        ArrayList<String> subset = new ArrayList<String>();

        long pow_set_size = (long)Math.pow(2, set_size);
        int counter, j;

		/*Run from counter 000..0 to
		111..1*/
        for (counter = 0; counter < pow_set_size;
             counter++) {
            String temp = "";
            for (j = 0; j < set_size; j++) {
                if ((counter & (1 << j)) > 0)
                    temp
                            += (Integer.toString(set[j]) + '$');
            }

            if (!subset.contains(temp)
                    && temp.length() > 0) {
                subset.add(temp);
            }
        }

        for (String s : subset) {
            s = s.replace('$', ' ');
            System.out.println(s);
        }
    }
    public static void
    findSubsets(ArrayList<ArrayList<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index)
    {
        // Base Condition
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        // Not Including Value which is at Index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // Including Value which is at Index
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }
    private static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> inputArrList) {
        ArrayList<ArrayList<Integer>> subset = new ArrayList<>();
        findSubsets(subset, inputArrList, new ArrayList<>(), 0);

        Collections.sort(subset, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                }
                else {
                    // sort based on the unequal elements value
                    return o1.get(i) - o2.get(i);
                }
            }
            // sort based on size
            return o1.size() - o2.size();
        });

        // Printing Subset
        for (int i = 0; i < subset.size(); i++) {
            for (int j = 0; j < subset.get(i).size(); j++) {
                System.out.print(subset.get(i).get(j) + " ");
            }
            System.out.println();
        }
    return subset;
    }

    public static void findPowerSet(int[] S)
    {
        // `N` stores the total number of subsets
        int N = (int)Math.pow(2, S.length);
       // Set<List<Integer>> set = new HashSet<>();
        ArrayList<ArrayList<Integer>> set = new ArrayList<>();
        // sort the set
        Arrays.sort(S);

        // generate each subset one by one
        for (int i = 0; i < N; i++)
        {
            List<Integer> subset = new ArrayList<>();

            // check every bit of `i`
            for (int j = 0; j < S.length; j++)
            {
                // if j'th bit of `i` is set, append `S[j]` to the subset
                if ((i & (1 << j)) != 0) {
                    subset.add(S[j]);
                }
            }

            // insert the subset into the set
          //  set.add(subset);
        }

        // print all subsets present in the set
        System.out.println(set);
    }
    // Driver program to test printPowerSet
    public static void main(String[] args)
    {
        int[] set = { 10, 12, 12 };
        int[] S = { 1, 2, 3 };

        findPowerSet(S);
       // printPowerSet(set, 3);
       // System.out.println(""+subsets(new ArrayList<Integer>(Arrays.asList(1,2,3))));
    }
}

// This code is contributed by Aditya Patil.
