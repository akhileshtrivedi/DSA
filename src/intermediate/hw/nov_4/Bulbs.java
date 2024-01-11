package intermediate.hw.nov_4;

public class Bulbs {
    public static int bulbsOLD(int[] A) {
        int count = 0;
        int N= A.length;
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                A[i] = 1;
                for (int j = i + 1; j < N; j++) {
                    if (A[j] == 1) {
                        A[j] = 0;
                    }
                    else {
                        A[j] = 1;
                    }
                }
                count++;
            }
        }
        return count;
    }
    public static int bulbs(int[] A)
    {
        // To keep track of switch presses so far
        int N = A.length;
        int count = 0;

        for (int i = 0; i < N; i++)
        {
            if (A[i] == 1 && count%2 == 0)
                continue;

            else if(A[i]  == 0 && count%2 != 0)
                continue;

            else if (A[i]  == 1 && count%2 != 0)
            {
                count++;
            }

            else if (A[i]  == 0 && count%2 == 0)
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] states = { 0, 1, 0, 1 };
        int[] states2 = { 1, 1, 1, 1 };
        int N = states.length;

        // Function Code
        System.out.println(
                "The minimum number of switches needed are "
                        + bulbs(states));
        System.out.println(
                "The minimum number of switches needed are "
                        + bulbs(states2));
    }

}
