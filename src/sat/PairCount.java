package sat;

public class PairCount {
    public int getPairCount(int A[], int B) {
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = A[i] + A[j];
                if (sum == B) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getPairCountNew(int A[], int B) {
        int count = 0;
        int sum = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                sum = A[i] + A[0];
            } else {
                sum = A[i] + A[i + 1];
            }
            if (sum == B) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int A[] = {1, 2, 3, 2, 1};
        int B = 5;
        int A2[] = {1, 1, 1};
        int B2 = 2;
        PairCount hw = new PairCount();
        System.out.println("count--> " + hw.getPairCount(A, B));
        System.out.println("count--> " + hw.getPairCount(A2, B2));

        System.out.println("count--> " + hw.getPairCountNew(A, B));
        System.out.println("count--> " + hw.getPairCountNew(A2, B2));


    }
}
