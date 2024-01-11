package intermediate.nov_21;

public class FindingGoodDays {

    public static  int solve(int A) {
        boolean test = false;
        int days=0;
        int fact=A;
        int []food ={1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072,262144,524288,1048576,2097152,4194304,8388608,16777216,33554432,67108864,134217728,268435456,536870912,1073741823};
        // int res = Arrays.binarySearch(food, 8);
        int i=0;
        while(fact>0){
            for (int element : food) {
                if (element == fact) {
                    test = true;
                    fact=fact-element;
                    days++;
                    break;
                }
            }
           // System.out.println("test--> "+test);
           if(!test){
               fact =fact-food[i];
                days++;

           }
        }
        return days;
    }

    public static void main(String[] args) {
       // System.out.println(""+solve(8));
        System.out.println(""+solve(5));
    }
}
