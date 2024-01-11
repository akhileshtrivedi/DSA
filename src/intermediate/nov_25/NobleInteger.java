package intermediate.nov_25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleInteger {
    private static int solve(ArrayList<Integer> list) {
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            // Check if the next element is a duplicate
            if (i < list.size() - 1 && list.get(i) == list.get(i + 1)) {
                continue;
            }

            // Check if a noble int
            if (list.size() - i - 1 == list.get(i)) {
                return 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(3, 2, 1, 0))));
        System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(3, 2, 1, 3))));
      System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(10, 3, 20, 40, 2))));
       System.out.println("" + solve(new ArrayList<Integer>(Arrays.asList(5, 6, 2))));
    }
}
