package intermediate.oct_19;

public class CountFactorsSums {
    public int countFact(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        return count;
    }

    public int countFact2(int number) {
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

    public static void main(String[] args) {
        CountFactorsSums cfs = new CountFactorsSums();
        long startTime = System.nanoTime();
        System.out.println("count Fact--->" + cfs.countFact(100000));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("duration-->"+duration);
        long startTime2 = System.nanoTime();
        System.out.println("count Fact--->" + cfs.countFact2(100000));
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("duration2-->"+duration2);
    }
}
