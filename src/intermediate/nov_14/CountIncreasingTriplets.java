package intermediate.nov_14;

import java.util.*;

class CountIncreasingTriplets {

    public static int lower(int a[], int x)
    {
        int n = a.length;
        int l = 0;
        int r = n - 1;
        int ans = n;
        while(l <= r)
        {
            int m = (r - l) / 2 + l;
            if(a[m] >= x)
            {
                ans = m;
                r = m - 1;
            }
            else
            {
                l = m + 1;
            }
        }
        System.out.println("ans-->"+ans);
        return ans;
    }
    public static int query(int BIT[], int i)
    {
        int sum = 0;
        for (; i > 0; i -= (i & -i)) {
            sum += BIT[i];
        }
        return sum;
    }
    public static void Convert(int arr[], int n)
    {
        int temp[]=new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
            System.out.println("arr[i]-->"+arr[i]);
        }
        Arrays.sort(temp);
        for (int i = 0; i < n; i++) {
            arr[i] = lower(temp, arr[i]) + 1;
        }
    }

    public static void update(int BIT[], int n, int i, int val)
    {
        for (; i <= n; i += (i & -i)) {
            BIT[i] += val;
        }
    }
    public static int getCount(int arr[])
    {
        int n= arr.length;
        Convert(arr, n);

        int BIT[] = new int[n+1];
        int smaller_right[] = new int[n+1];
        int greater_left[] = new int[n+1];
        for(int i=0;i<n+1;i++){
            BIT[i]=0;
            smaller_right[i]=0;
            greater_left[i]=0;
        }
        for (int i = n - 1; i >= 0; i--) {
            smaller_right[i] = query(BIT, arr[i]-1);
            update(BIT, n, arr[i], 1);
        }

        for (int i = 0; i <= n; i++) {
            BIT[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            greater_left[i] = i - query(BIT, arr[i]);
            update(BIT, n, arr[i], 1);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += greater_left[i] * smaller_right[i];
        }


        return ans;
    }
    public static void main (String[] args) {
       // int arr[] = { 7, 3, 4, 3, 3, 1};
        int arr2[] = {1,2,4,3};
        int arr3[] = {2,1,2,3};

       // System.out.println(getCount(arr));
        System.out.println(getCount(arr2));
       // System.out.println(getCount(arr3));
    }
}
// this code is contributed by Manu Pathria

