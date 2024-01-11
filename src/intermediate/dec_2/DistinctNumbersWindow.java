package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersWindow {
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>(0);
        Integer[] arr = new Integer[A.size()];
        arr = A.toArray(arr);

        HashMap<Integer, Integer> hM
                = new HashMap<Integer, Integer>();
        for (int i = 0; i < B; i++)
            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

        result.add(hM.size());

        for (int i = B; i < arr.length; i++) {
            if (hM.get(arr[i - B]) == 1) {
                hM.remove(arr[i - B]);
            } else
                hM.put(arr[i - B], hM.get(arr[i - B]) - 1);

            hM.put(arr[i], hM.getOrDefault(arr[i], 0) + 1);

            result.add(hM.size());
        }
   return result;
    }

    public static void main(String[] args) {

        System.out.println("" + dNums(new ArrayList<Integer>(Arrays.asList(1, 2, 1, 3, 4, 3)), 3));
        System.out.println("" + dNums(new ArrayList<Integer>(Arrays.asList(1, 1, 2, 2)), 1));
    }
}
