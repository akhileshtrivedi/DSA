package sorting;

public class InsertionSort {
    public void printArray(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]+" ");
        }

    }

    public void sort(int arr[]){
        int n = arr.length;
        for(int i = 1; i<n; i++){
            int j= i-1;
            int key = arr[i];
            //while(j>=0 && arr[j]>key){

           // System.out.println(arr[j]+" out j "+j);
           // System.out.println(key+" out key "+j);
            for(;j>=0 && arr[j]>key; j--){
                    arr[j+1] = arr[j];
                    //j= j-1;
                    }
            arr[j+1] = key;
            }

        }


    public static void main(String[] args) {
        int arr[] = {12,11,13,5,6};
        InsertionSort is = new InsertionSort();
        is.sort(arr);
        is.printArray(arr);
    }
}
