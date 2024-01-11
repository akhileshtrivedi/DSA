package intermediate.dec_21;

import java.util.ArrayList;
import java.util.Arrays;

public class OddEvenSeq1 {

    public int longOddEvenSeq(int a[], int size)
    {
        int[] loes = new int[size];
        int maximumLen = 0;

        for (int j = 0; j < size; j++)
        {
            loes[j] = 1;

        }
        for (int j = 1; j < size; j++)
        {
            for (int i = 0; i < j; i++)
            {
                if ((a[j] + a[i]) % 2 != 0 && loes[j] < loes[i] + 1)
                {
                    loes[j] = loes[i] + 1;
                    System.out.println(""+loes[j]);
                }
            }
        }
        for (int k = 0; k < size; k++)
        {
            if (maximumLen < loes[k])
            {
                maximumLen = loes[k];
            }
        }
        return maximumLen;
    }
    public static int longOddEvenIncSeq(int arr[],
                                        int n)
    {
        int[] lioes = new int[n];
        int maxLen = 0;
        for (int i = 0; i < n; i++)
            lioes[i] = 1;
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] &&
                        (arr[i] + arr[j]) % 2 != 0
                        && lioes[i] < lioes[j] + 1)
                    lioes[i] = lioes[j] + 1;
                System.out.println("" + lioes[i]);
            }
        for (int i = 0; i < n; i++)
            if (maxLen < lioes[i])
                maxLen = lioes[i];

        return maxLen;
    }
   private static int solve(ArrayList<Integer> A){
           int n= A.size();
           int maxi1 = 0;

           // Marks the starting of odd
           // number as sequence and
           // alternatively changes
           int f1 = 0;

           // Finding the longest odd/even sequence
           for (int i = 0; i < n; i++)
           {

               // Find odd number
               if (f1 % 2 != 0)
               {
                   if (A.get(i) % 2 == 1)
                   {
                       f1 = 1;
                       maxi1++;
                   }
               }

               // Find even number
               else
               {
                   if (A.get(i) % 2 == 0)
                   {
                       maxi1++;
                       f1 = 0;
                   }
               }
           }

           int maxi2 = 0;
           int f2 = 0;

           // Length of the longest even/odd sequence
           for (int i = 0; i < n; i++)
           {

               // Find odd number
               if (f2 % 2 != 0)
               {
                   if (A.get(i) % 2 == 1)
                   {
                       f2 = 1;
                       maxi2++;
                   }
               }

               // Find even number
               else
               {
                   if (A.get(i) % 2 == 0)
                   {
                       maxi2++;
                       f2 = 0;
                   }
               }
           }

           // Answer is maximum of both
           // odd/even or even/odd subsequence
           return Math.max(maxi1, maxi2);
       }
    public static int longOddEvenIncSeqOne(ArrayList<Integer> A) {
        Integer[] arr = new Integer[A.size()];
        arr= A.toArray(arr);
        int n = arr.length;
        int[] lioes = new int[n];

        int maxLen = 0;

        for (int i = 0; i < n; i++)
            lioes[i] = 1;

        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j] &&
                    (arr[i] + arr[j]) % 2 != 0
                    && lioes[i] < lioes[j] + 1)
                    lioes[i] = lioes[j] + 1;

        for (int i = 0; i < n; i++)
            if (maxLen < lioes[i])
                maxLen = lioes[i];

        return maxLen;
    }


    private static int solve1(ArrayList<Integer> A) {
        int n = A.size();
        int ans1 = 0,ans2 = 0;
        int x = 1,y = 0;
        for(int i=0;i<n;i++){
         int   it = (A.get(i) & 1);    //another way of writing it = it % 2
            // n % 2^n equals to n & (2^n)-1
            if(it == x){
                ++ans1;
                x ^= 1;        // if x is 1 make it 0 and vice versa
            }
            if(it == y){
                y ^= 1;        // if y is 0 make it 1 and vice versa
                ++ans2;
            }
        }
        return Math.max(ans1,ans2);
    }
        // main method
    public static void main(String arg[])
    {
//creating an object of the class OddEvenSeq1
//        OddEvenSeq1 obj = new OddEvenSeq1();
//
      //  int a[] = { 16, 50, 2, 9, 40, 2, 19, 43, 14};
        int a[] = { 1, 2, 2, 5, 6};
       int size = a.length;
//
//        System.out.println("For the input array: ");
//        for(int i = 0; i < size; i++)
//        {
//            System.out.print(a[i] + " ");
//        }
//        System.out.println("\n");
//
//        int ans = obj.longOddEvenSeq(a, size);
//
//       System.out.println("The longest odd even subsequence is: " + ans);
     // System.out.println("The longest odd even subsequence is: " + longOddEvenIncSeqOne(new ArrayList<Integer>(
       System.out.println(""+solve1(new ArrayList<Integer>(Arrays.asList(16, 50, 2, 9, 40, 2, 19, 43, 14))));

    }
}

