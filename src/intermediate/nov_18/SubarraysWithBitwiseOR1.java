package intermediate.nov_18;

import java.util.*;

public class SubarraysWithBitwiseOR1 {




    private static Long distintBitwiseOROLD(int A, ArrayList<Integer> B)
    {
        long count = 0;
        for (int i = 0; i < A; i++) {
            for (int j = i; j < A; j++) {
                int bitwise_or = 0;
                for (int k = i; k <= j; k++) {
                    bitwise_or = bitwise_or | B.get(k);
                }
                if (bitwise_or >= 1)
                    count++;
            }
        }
        return count;
    }
    static int countSubarrWithEqualZeroAndOne(int arr[])
    {
        int n = arr.length;
        Map<Integer, Integer> um = new HashMap<>();
        int curr_sum = 0;

        for (int i = 0; i < n; i++) {
            curr_sum += (arr[i] == 0) ? -1 : arr[i];
            um.put(curr_sum, um.get(curr_sum) == null
                    ? 1
                    : um.get(curr_sum) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> itr :
                um.entrySet()) {

            if (itr.getValue() > 1)
                count += ((itr.getValue()
                        * (itr.getValue() - 1))
                        / 2);
        }

        if (um.containsKey(0))
            count += um.get(0);

        return count+1;
    }

    static int printSubArrays(int[] arr, int start, int end, int count)
    {
        if (end == arr.length) {
            return count;
        }else if (start > end) {
           count = printSubArrays(arr, 0, end + 1, count);
        } else {
            int bitwise_or = 0;
            for (int i = start; i < end; i++) {
                bitwise_or = bitwise_or | arr[i];

            }
            if (bitwise_or >= 1)
                count++;
            System.out.println(arr[end] + "]");
            count = printSubArrays(arr, start + 1, end, count);
        }
        return count;
    }
        // Driver code


    private static Long distintBitwiseOR(int A, ArrayList<Integer> B)
    {
        long count = 0;
        int lastVal=0;
        for (int i = 0; i < A; i++) {

            if(B.get(i)==1){
                lastVal =i+1;
            }
            count+=lastVal;
        }
        return count;
    }
        public static void main(String[] args) {
            //int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
            int arr[] = {1, 0,1};
            int arr2[] = {1, 1};
            int arr3[] = {1, 0,1};
            int arr4[] = {1, 0};

           // int[] arr = { 1, 2, 3 };
          //  System.out.println(printSubArrays(arr4, 0, 0, 1));
        // ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,1,1));
         //   ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(1,1));
            ArrayList<Integer> al3 = new ArrayList<>(Arrays.asList(1,0));
            ArrayList<Integer> al4 = new ArrayList<>(Arrays.asList(1,0,1));
            System.out.println("distintBitwiseOR 2 = " + distintBitwiseOR(al3.size(), al3));
            System.out.println("distintBitwiseOR 5  = " + distintBitwiseOR(al4.size(), al4));
           System.out.println("Count = " + countSubarrWithEqualZeroAndOne(arr2));
           // System.out.println("Count = " + countSubarrWithEqualZeroAndOne(arr2));
            //ArrayList<Integer> data=new ArrayList<>(Arrays.asList(1, 0, 0, 1 ));

            //System.out.println(""+countSubarrWithEqualZeroAndOne());
           // System.out.println("list of subarray is "+distintBitwiseOR(data.size(),data));
            //findMinXORSubarray(B,B.length,A);
            // System.out.println("list of subarray is "+distintBitwiseOR(B,B.length,A));
            // System.out.println("list of subarray is "+distintBitwiseOR(BB,BB.length,AA));

            // System.out.println(""+findMinXORSubarray(B,B.length,A));
        }
    }

// This code is contributed by Rajput-Ji





