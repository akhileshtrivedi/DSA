package intermediate.nov_21;

import java.util.ArrayList;
import java.util.Arrays;

    public  class HelpFromSam {

        private static ArrayList<Integer> solve(ArrayList<Integer> A) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            int xor = 0;
            for(int i=0 ; i<A.size(); i++){
                xor = xor ^ A.get(i);
            }
            //note : right set bit masking -> n & -n
            int  rightSetBit = xor & -xor;
            int x = 0; // 1st uniue number
             int y = 0; // 2nd uniue number
            for(int val : A){
                if((val & rightSetBit) == 0){                //i.e zero
                        x ^= val;            }
                else{                y ^= val;
                }
            }
            if(x < y){
                result.add(x);
                result.add(y);
            }else{
                result.add(y);
                result.add(x);
            }
                return result;
        }






            // Returns number of ways to reach score n
        static int count(int n)
        {

            int table[] = new int[n + 1], i;
            Arrays.fill(table, 0);
            table[0] = 1;

            for (i = 3; i <= n; i++)
                table[i] += table[i - 3];
            for (i = 5; i <= n; i++)
                table[i] += table[i - 5];
            for (i = 10; i <= n; i++)
                table[i] += table[i - 10];

            return table[n];
        }

        // Driver code
        public static void main(String[] args)
        {
//            int n = 20;
//            System.out.println("Count for " + n + " is "
//                    + count(n));
//
//            n = 13;
//            System.out.println("Count for " + n + " is " + count(n));
//            System.out.println("Count for 5 is " + count(5));
//            System.out.println("Count for 3 is " + count(n));
            System.out.println("Count for 3 is " + solve(new ArrayList<Integer>(Arrays.asList(5,3))));
           // System.out.println("Count for 3 is " + count(n));
        }
    }


