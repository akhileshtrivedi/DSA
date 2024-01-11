package intermediate.dec_5;


    public class PrintNumbersWithoutLoop {

        public static boolean isPalindrome(String s, int i){

            if(i > s.length()/2)
            {
                return true ;
            }

            return s.charAt(i) == s.charAt(s.length()-i-1) && isPalindrome(s, i+1) ;

        }

        public static void main(String[] args) {
            PrintNumbersWithoutLoop pnwl=new PrintNumbersWithoutLoop();
            pnwl.printNumbers(5);

            String str = "geeg" ;
            if (isPalindrome(str, 0))
            { System.out.println("Yes"); }
            else
            { System.out.println("No"); }

        }



        public void printNumbers(int n)
        {
            System.out.print(" "+n);
            if(n<=1)
            {
                return;
            }
            else
            {
                printNumbers(n-1);
                System.out.print(" "+n);
            }
        }

    }

