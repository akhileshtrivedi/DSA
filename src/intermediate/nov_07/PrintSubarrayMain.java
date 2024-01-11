package intermediate.nov_07;

public class PrintSubarrayMain {
    public static void main(String args[]){
        PrintSubarrayMain psm=new PrintSubarrayMain();
        int arr[]= {1,2,3,4};
        psm.printSubArray(arr);
    }

    void printSubArray(int arr[])
    {

        int n=arr.length;
        int count=0;
        for (int i=0; i <n; i++) //This loop will select start element
        {
            for (int j=i; j<n; j++)   //This loop will select end element
            { System.out.print(count+" - { ");
                for (int k=i; k<=j; k++) //This loop will print element from start to end

                {
                    System.out.print(arr[k]+" ");
                }
                System.out.print("}");
                count++;
                System.out.println();
            }
        }
        System.out.println("count-->"+count);
    }
}