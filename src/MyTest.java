public class MyTest {
    public void sort(int arr[]){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int j= i-1;
            int key = arr[i];
            for(;j>=0&&arr[j]>key; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }

    }

    public void printArray(int arr[]){
        int n = arr.length;

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        MyTest mt = new MyTest();
       // int arr[] = {65, 25, 12, 22, 10};
       // int arr[] = {5, 1, 4, 2, 8};
        int arr[] = {12,11,13,5,6};
        mt.sort(arr);
        mt.printArray(arr);
    }
}
