package intermediate.revision;

public class Day1 {
    // There are 3 sums for Assignments
    private static boolean isPrimeNumber(int n) {

        return solveOpt(n) == 2;
    }


    private static int solveOpt(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count++;
                } else {
                    count = count + 2;
                }
            }
        }
        return count;
    }

    private static int sqrt(int n) {
        int ans = 0, i = 1;
        while (i *i <=n) {
            ans = i;
            i++;
        }
        return ans;
    }
// There are Homework sums
    // Find a perfect number
private static int isPerfectNumber(int A) {
    if (A == 1)
        return 0;

    int sum = 1;
    for (int i = 2; i * i <= A; i++) {
        if (A % i == 0) {
            if (i * i == A)
                sum += i;
            else
                sum += i + (A / i);
        }
    }
    if (sum == A)
        return 1;

    return 0;
}
// Return the counts of Prime Number
    private static boolean isPrime(int num)
    {
        if (num <= 1)
            return false;

        for(int i = 2; i * i <= num; i++)
            if (num % i == 0)
                return false;

        return true;
    }
    private static int countPrimeNumber(int A) {
        int i = 2, count = 0;
        while (i <= A) {
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        return count;
    }


    public static void main(String[] args) {
        // solveOpt(30);
        // solve(36);
        // System.out.println( isPrimeNumber(31));
        //System.out.println(sqrt(49));
        //  sqrt(9);
      //  System.out.println("is Perfect Number "+isPerfectNumber(6));
        System.out.println("is Perfect Number "+countPrimeNumber(10));
    }
}
