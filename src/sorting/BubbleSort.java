package sorting;

public class BubbleSort {
    public void printArray(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
        System.out.println(arr[i]+" ");
        }
    }
    public void sort(int arr[]){
     int n = arr.length;
     for(int i = 0; i < n-1; i++){
         for(int j = 0; j < n-i-1; j++){
             if (arr[j] > arr[j+1]){
                 int temp = arr[j];
                 arr[j] = arr[j+1];
                 arr[j+1] = temp;
             }
         }
     }

    }
    public static void main(String[] args) {
   int arr[] = {5, 1, 4, 2, 8};
        BubbleSort bs = new BubbleSort();
        bs.sort(arr);
        bs.printArray(arr);
    }
}
