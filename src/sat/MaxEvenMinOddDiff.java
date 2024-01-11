package sat;

public class MaxEvenMinOddDiff {
    public int getEvenOddDiff(int A[]) {
        int diff = 0;
        int n = A.length;
        boolean firstTime = true;
        int maxEven = 0;
        int minOdd = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] % 2 == 0) {
                if (firstTime) {
                    maxEven = A[i];
                    firstTime = false;
                } else {
                    if (A[i] > maxEven) {
                        maxEven = A[i];
                    }
                }
            } else {
                // System.out.println(" minOdd=="+A[i]);
                if (minOdd == 0 || A[i] < minOdd) {
                    minOdd = A[i];
                }
            }
        }
        System.out.println(" ");
        System.out.println("maxEven-->" + maxEven + " minOdd-->" + minOdd);

        return maxEven - minOdd;
    }

    // Driver Code
    public static void main(String[] args) {

        // Given array arr[]
//        int arr1[] = { 1, 8, 3, 4, 5 };
//
//        // Size of array
//        int N1 = arr.length;
//
//        int K1 = 2;
        int arr1[] = {0, 2, 9}; // -7
        int arr2[] = {-98, 54, -52, 15, 23, -97, 12, -64, 52, 85}; // 151
        int arr3[] = {5, 17, 100, 1};//99
        int arr4[] = {-15, -45, 43, 23, -63, 69, 35, 19, 37, -52}; // -11
        // Function Call
        MaxEvenMinOddDiff e = new MaxEvenMinOddDiff();
        System.out.println("arr1--->" + e.getEvenOddDiff(arr1));
        System.out.println("arr1--->" + e.getEvenOddDiff(arr2));
        System.out.println("arr1--->" + e.getEvenOddDiff(arr3));
        System.out.println("arr1--->" + e.getEvenOddDiff(arr4));
    }
}
