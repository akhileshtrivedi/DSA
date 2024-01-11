package intermediate.nov_14;

class ChristmasTrees {
    private static int solve(int[] A, int[] B) {
        if(A[0]==A[1] || A[0]==A[2]){
            return -1;
        }
            int min = Integer.MAX_VALUE;
            for(int i =  1 ; i < B.length-1;i++ ){
                int leftmin =Integer.MAX_VALUE;
                int rightmin = Integer.MAX_VALUE;
                for(int j = i-1 ; j >=0 ; j--){
                    if(A[i] > A[j]){
                        if(B[j] < leftmin){
                            leftmin = B[j];
                        }
                    }
                }
                for(int j = i+1 ; j < B.length; j++){
                    if(A[i] < A[j]){
                        if(B[j] < rightmin){
                            rightmin = B[j];
                        }
                    }
                }
                if(leftmin == Integer.MAX_VALUE || rightmin == Integer.MAX_VALUE) continue;
                min = Math.min(min,B[i] + leftmin + rightmin);
            }
            return min;
        }


    //Main Function
    public static void main(String[] args) {
      int []  A = {1, 3, 5};
       int []B = {1, 2, 3};

      int [] AA = {1, 6, 4, 2, 6, 9};
        int [] BB = {2, 5, 7, 3, 2, 7};
        // System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 3, 5)), new ArrayList<>(Arrays.asList(1, 2, 3))));
        // System.out.println(""+solve(new ArrayList<>(Arrays.asList(1, 6, 4, 2, 6, 9)), new ArrayList<>(Arrays.asList(2, 5, 7, 3, 2, 7))));
        System.out.println("" + solve(A,B));
        System.out.println("" + solve(AA,BB));

    }
}
