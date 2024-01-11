package sorting;

public class SortedAndRotated {
    public void printArray(int arr[]){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]+" ");
        }
    }
    public boolean rotateAndSort(int arr[]){
        int n = arr.length;
        int count = 0;
        for(int i=1;i<n;i++){
            if(arr[i-1]>arr[i]){
                count++;
            }
            if(arr[n-1]>arr[0])
                count++;

            // System.out.println(newArr[i]+"   "+i);
        }
        System.out.println(" counts   "+count);
        return count <=1;
    }
    public static void main(String[] args) {
        SortedAndRotated sr = new SortedAndRotated();
        int arr[] = {3, 3, 3, 3, 3, 3, 3, 3, 3};
        //sr.rotateAndSort(arr);
        System.out.println(" value--->"+sr.rotateAndSort(arr));
       // sr.printArray(arr);
    }
}
