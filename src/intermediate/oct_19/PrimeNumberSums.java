package intermediate.oct_19;

public class PrimeNumberSums {
    public int countFact(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                if (i == number / i) {
                    count++;
                } else {
                    count = count + 2;
                }
            }
        }
        return count;
    }

    public int isPrimeNumber(int A) {
        int flag=0;
        // return countFact(number) == 2;
        if (A <= 1) {
            flag= 0;
        }
        if (A == 2 || A == 3) {
            flag= 1;
        }
        if (A % 2 == 0 || A % 3 == 0) {
            flag= 0;
        }

        for (int i = 5; i <= Math.sqrt(A); i = i + 6) {
            if (A % i == 0 || A % (i + 2) == 0) {
                flag= 0;
            }
            flag= 1;
        }
        return flag;
    }

    public static void main(String[] args) {
        PrimeNumberSums pns = new PrimeNumberSums();
        int i=0;
        while(i<20) {
            System.out.println(i+" is  prime number->" + pns.isPrimeNumber(i));
            i++;
        }
       // System.out.println(" is PrimeNumber " + pns.isPrimeNumber(10));

    }
}
