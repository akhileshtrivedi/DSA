package intermediate.nov_14;

public class JosephusProblem {
    private static int solve(int A) {
        int personNo = 0;
        int[] a = new int[A];
        for (int i = 0; i < A; i++) {
            a[i] = i + 1;
        }
        int pos = 0;
        while (a.length > 1) {
            pos++;
            pos %= a.length;
            int[] anotherArray = new int[a.length - 1];
            System.arraycopy(a, 0, anotherArray, 0, pos);
            System.arraycopy(a, pos + 1, anotherArray, pos, a.length - pos - 1);
            a = anotherArray;
        }
        return a[0];
    }

    public static void main(String[] args) {

        System.out.println("Person that survive the game "+solve(100));
    }
}
