package sorting;

public class ReverseArray {
    public void shiftZeroRightSideArray(int arr[]) {
        int n = arr.length;
        int noneZero = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                int temp = arr[i];
                arr[i] = arr[noneZero];
                arr[noneZero] = temp;
                noneZero++;
            }
        }
}

    public void printArray(int arr[]){
        int n = arr.length;
        for(int i=0;i<n; i++){

            System.out.println(arr[i]+" ");
        }

    }
    public static void main(String[] args) {
        int  arr[] = {1,2,3,4,5};
        int  arr2[] = {1,2,3,4,5,6};
        int  arr3[] = {0,1,0,2,0,3,4,0,5,6};
        ReverseArray ra =new ReverseArray();
       // ra.reverse(arr);
       // ra.reverse(arr2);
       // ra.printArray(arr);
        ra.shiftZeroRightSideArray(arr3);
        System.out.println(" ReverseArray ");
        ra.printArray(arr3);

    }
}
