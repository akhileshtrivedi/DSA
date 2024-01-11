package intermediate.nov_14;

public class MultipleLeftRotate {
    private static void preprocess(int arr[], int n, int temp[])
    {
        // Store arr[] elements at i and i + n
        for (int i = 0; i < n; i++)
            temp[i] = temp[i + n] = arr[i];
    }

    // Function to left rotate an array k time
    private static void leftRotate(int arr[], int n, int k,
                           int temp[])
    {
        // Starting position of array after k
        // rotations in temp[] will be k % n
        int start = k % n;

        // Print array after k rotations
        for (int i = start; i < start + n; i++)
            System.out.print(temp[i] + " ");

        System.out.print("\n");
    }

    // Driver program
    public static void main(String[] args)
    {
       // A = [5, 17, 100, 11]
      //  B = [1]
        int arr[] = { 5, 17, 100, 11};
        int n = arr.length;

        int temp[] = new int[2 * n];
        preprocess(arr, n, temp);

        int k = 1;
        leftRotate(arr, n, k, temp);

        k = 3;
        leftRotate(arr, n, k, temp);

        k = 4;
        leftRotate(arr, n, k, temp);
    }
}

