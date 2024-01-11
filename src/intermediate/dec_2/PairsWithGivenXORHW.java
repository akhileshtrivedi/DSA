package intermediate.dec_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenXORHW {
       private static int xorPairCountOLD(ArrayList<Integer> A, int B)
        {
            int n =A.size();
            int result = 0;
            Map<Integer,Integer> m = new HashMap<>();

            for (int i = 0;  i < n ; i++)
            {
                int curr_xor = B^A.get(i);
                if (m.containsKey(curr_xor))
                    result += m.get(curr_xor);

                if(m.containsKey(A.get(i)))
                {
                    m.put(A.get(i), m.get(A.get(i)) + 1);
                }
                else{
                    m.put(A.get(i), 1);
                }
            }
            return result;
        }
    private static int xorPairCount(ArrayList<Integer> A, int B)
    {
        int n =A.size();
        Integer[] arr = new Integer[n];
        arr = A.toArray(arr);
        int result = 0; // Initialize result
        Map<Integer,Integer> m = new HashMap<>();

        for (int i = 0;  i < n ; i++)
        {
            int curr_xor = B^arr[i];
            if (m.containsKey(curr_xor))
                result += m.get(curr_xor);

            if(m.containsKey(arr[i]))
            {
                m.put(arr[i], m.get(arr[i]) + 1);
            }
            else{
                m.put(arr[i], 1);
            }
        }
        // return total count of pairs with XOR equal to x
        return result;
    }
    public static void main(String[] args) {

        System.out.println("Count of pairs with given XOR = "
                + xorPairCountOLD(new ArrayList<Integer>(Arrays.asList(5, 4, 10, 15, 7, 6)),5));//1
        System.out.println("Count of pairs with given XOR = "
                + xorPairCountOLD(new ArrayList<Integer>(Arrays.asList(3, 6, 8, 10, 15, 50)),5));//2
    }
}
