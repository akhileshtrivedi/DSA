package advanced.feb_17;


public class RabinKarp {

  public final static int d = 256;

  static int search(String pat, String txt) {
    int count = 0;
    int q = 101;
    int M = pat.length();
    int N = txt.length();
    int i, j;
    int p = 0; // hash value for pattern
    int t = 0; // hash value for txt
    int h = 1;

    for (i = 0; i < M - 1; i++) {
      h = (h * d) % q;
    }
    System.out.println("aaaa"+M);
    for (i = 0; i < M; i++) {
      System.out.println(d+"aaaa222"+p);
      p = (d * p + pat.charAt(i)) % q;
      System.out.println("aaaa3333"+p);
      t = (d * t + txt.charAt(i)) % q;
      System.out.println("aaaa4444"+t);
    }

    for (i = 0; i <= N - M; i++) {
      if (p == t) {
        for (j = 0; j < M; j++) {
          if (txt.charAt(i + j) != pat.charAt(j)) {
            break;
          }
        }

        if (j == M) {
          count++;
        }
      }

      if (i < N - M) {
        t = (d * (t - txt.charAt(i) * h)
            + txt.charAt(i + M))
            % q;
        if (t < 0) {
          t = (t + q);
        }
      }
    }
    return count;
  }

  /* Driver Code */
  public static void main(String[] args) {
    String txt = "ccbcdaacc";
    String pat = "ac";
    System.out.println("" + search(pat, txt));
//    ;
//    System.out.println("" + search("aa", "aaaa"));
  }
}

// This code is contributed by nuclode
