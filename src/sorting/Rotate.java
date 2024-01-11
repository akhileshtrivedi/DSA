package sorting;

public class Rotate {
    public void printArray(int arr[]){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]+" ");
        }
    }
    public void rotate(int arr[], int k, int newArr[]){
        int n = arr.length;

        for(int i=0 ;i<n;i++){
            newArr[i] =  arr[(k+i)%n];
           // System.out.println(newArr[i]+"   "+i);
        }
    }

    public static void main(String[] args) {
        Rotate r = new Rotate();
        int arr[] = {-1, -100, 3, 20, 33, 56, 99, 100, 101};
        int k=2;
        int newArr[] = new int[arr.length];
        r.rotate(arr,k, newArr);
      r.printArray(newArr);
    }
}
