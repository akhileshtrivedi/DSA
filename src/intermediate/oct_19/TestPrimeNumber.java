package intermediate.oct_19;

import java.lang.*;

public class TestPrimeNumber {

    // Function check whether a number
    // is prime or not
    public int isPrime(int n) {
        if (n <= 1)
            return 0;

        else if (n == 2 || n == 3)
            return 1;

        else if (n % 2 == 0 || n % 3 == 0)
            return 0;

        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return 0;

        return 1;
    }

    // Driver Code
    public static void main(String[] args) {
        TestPrimeNumber tp = new TestPrimeNumber();
        int i=0;
         while(i<100) {
             if (tp.isPrime(i)==1)
             System.out.println(i+" is  prime number.");
             i++;
         }
    }
}

