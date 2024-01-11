package intermediate.nov_14;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPositivity {
    static int longestSubarry(int arr[]) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curr_count = 0;
            while (i < n && arr[i] >= 0) {
                curr_count++;
                i++;
            }
            res = Math.max(res, curr_count);
        }
        return res;
    }

    static ArrayList<Integer> longestSubarry2(ArrayList<Integer> arr) {
        int n = arr.size();
        int len_so_far = 0;
        int start = 0, end = 0, s = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr.get(j) < 0) {
                if (j - i > len_so_far) {
                    len_so_far = j - i;
                    end = j - 1;
                    start = i;
                }
                i = j + 1;

            } else {
                if (j == (n - 1)) {

                    if (((j + 1) - i) > len_so_far) {
                        end = j;
                        start = i;
                    }

                }
            }

        }
        for (int ii = start; ii <= end; ii++) {
            ans.add(arr.get(ii));
        }
        return ans;
    }

    static ArrayList<Integer> longestSubarryFinal(ArrayList<Integer> arr) {
        int n = arr.size();
        int len_so_far = 0;
        int start = 0, end = 0, s = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = i;
            //   System.out.println(i+" I   here "+arr.get(i));
            while (arr.get(j) > 0) {

                System.out.println(j + " j  here " + arr.get(j));
                j++;
            }
            len_so_far = (j - i);
            System.out.println("len_so_far-->" + len_so_far);
            j++;
        }
//        for (int i = start; i <= end; i++) {
//            ans.add(arr.get(i));
//        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 4, 0, 1, -1,
                -1, 0, 0, 1, 0};
        int arr2[] = {5, 6, -1, 7, 8};
        int arr3[] = {1, 2, 3, 4, 5, 6};
        System.out.println(longestSubarry2(new ArrayList<Integer>(Arrays.asList(5, 6, -1, 7, 8, -2, 7, 8, 9))));
        System.out.println(longestSubarry2(new ArrayList<Integer>(Arrays.asList(5, 6, -1, 7, 8))));
        System.out.println(longestSubarry2(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        // System.out.println(longestSubarry2(arr3));
        //System.out.println(longestSubarry2(arr3));

    }
}
