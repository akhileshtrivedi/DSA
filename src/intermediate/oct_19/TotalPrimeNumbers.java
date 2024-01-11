package intermediate.oct_19;

class TotalPrimeNumbers{

    static boolean isPrime(int num)
    {
        if (num <= 1)
            return false;

        for(int i = 2; i * i <= num; i++)

            // If a divisor of n exists
            if (num % i == 0)
                return false;

        return true;
    }

    static boolean isFulPrime(int n)
    {

        // If n is not a prime
        if (!isPrime(n))
            return false;

            // Otherwise
        else
        {
            while (n > 0)
            {

                // Extract digit
                int rem = n % 10;

                // If any digit of n
                // is non-prime
                if (!(rem == 2 || rem == 3 ||
                        rem == 5 || rem == 7))
                    return false;

                n = n / 10;
            }
        }
        return true;
    }
    static int countFulPrime(int L, int R)
    {

        // Stores count of full primes
        int cnt = 0;

        for(int i = L; i <= R; i++)
        {

            // Check if i is full prime
            if ((i % 2) != 0 && isFulPrime(i))
            {
                cnt++;
            }
        }
        return cnt;
    }

    private static int solve(int A) {
        int i = 0, count = 0;
        while (i <= A) {
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main (String[] args)
    {

        System.out.println("Total Primes count-->"+solve(19));

//
//        int L = 1, R = 21;
//
//        // Stores count of full primes
//        int ans = 0;
//
//        if (L < 1)
//            ans++;
//
//        System.out.println(ans + countFulPrime(L, R));
    }
}

// This code is contributed by sanjoy_62
