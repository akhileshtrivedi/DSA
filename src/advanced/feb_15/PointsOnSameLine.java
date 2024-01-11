package advanced.feb_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PointsOnSameLine {

  static int gcd(int p, int q) {
    if (q == 0) {
      return p;
    }
    int r = p % q;
    return gcd(q, r);
  }

  //  static int N = 6;
  static int maxPointOnSameLine(int[][] points) {
    int N = points.length;
    if (N < 2) {
      return N;
    }
    int maxPoint = 0;
    int curMax, overlapPoints, verticalPoints;

    HashMap<String, Integer> slopeMap = new HashMap<>();
    // looping for each point
    for (int i = 0; i < N; i++) {
      curMax = overlapPoints = verticalPoints = 0;

      // looping from i + 1 to ignore same pair again
      for (int j = i + 1; j < N; j++) {
        // If both point are equal then just
        // increase overlapPoint count
        System.out.println(i+" i "+points[i][0]+"----"+points[j][0]);
        System.out.println(j+" j "+points[i][1]+"----"+points[j][1]);

        if (points[i][0] == points[j][0]
            && points[i][1] == points[j][1]) {
          overlapPoints++;
        }

        // If x co-ordinate is same, then both
        // point are vertical to each other
        else if (points[i][0] == points[j][0]) {
          verticalPoints++;
        } else {
          int yDif = points[j][1] - points[i][1];
          int xDif = points[j][0] - points[i][0];
          int g = gcd(xDif, yDif);

          // reducing the difference by their gcd
          yDif /= g;
          xDif /= g;

          // Convert the pair into a string to use
          // as dictionary key
          String pair = (yDif) + " " + (xDif);
          if (!slopeMap.containsKey(pair)) {
            slopeMap.put(pair, 0);
          }

          // increasing the frequency of current
          // slope in map
          slopeMap.put(pair,
              slopeMap.get(pair) + 1);
          curMax = Math.max(curMax,
              slopeMap.get(pair));
        }

        curMax = Math.max(curMax, verticalPoints);
      }

      // updating global maximum by current point's
      // maximum
      maxPoint = Math.max(maxPoint,
          curMax + overlapPoints + 1);
      slopeMap.clear();
    }

    return maxPoint;
  }

  private static  int maxPoints(ArrayList<Integer> points, ArrayList<Integer> B) {
    //declare hashmap and result variable
    int result = 0;
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    //iterate over length of points array of obj
    for (int i = 0; i < points.size()-1; i++) {
      //reset map when considering for every point obj
     // map.clear();

      //reset overlap and max declaration to 0 when considering for every fresh point obj in i
      int overlap = 0;
      int max = 0;

      //iterate j from i+1 to points length
     // for (int j = i+1; j < points.size(); j++) {

        //compute the slope numerator and denominator
        int x = B.get(i) - points.get(i);
        int y = B.get(i+1)- points.get(i+1);

        //if both x and y == 0 then both the points in consideration are same, so inc overlap
        //and continue the loop since there is no slope for overlapping points
        if (x == 0 && y == 0) {
          overlap++;
          continue;
        }

        //compute the gcd of x and y; so that 2/4 is considered same as 1/2
        int gcd = generateGCD(x, y);

        //if gcd != 0 then bring the x and y to its simplest form
        if (gcd != 0) {
          x /= gcd;
          y /= gcd;
        }

        //if the map contains x ie slope numerator
        if(map.containsKey(x)) {

          //if thats the case check whether x is mapped to y ie slope denominator
          if(map.get(x).containsKey(y)) {
            //if thats the case then we have found one more point on the same line so get x get y and increment
            //the value and store it back with an internal key of y mapped overall to x
            map.get(x).put(y, map.get(x).get(y) + 1);
          } else {
            //otherwise new point having a new slope with current point detected so map x with y,1
            map.get(x).put(y, 1);
          }
        } else {
          //if x itself is not present, then create a new map m and map y,1 to m and x,m to map
          Map<Integer, Integer> m = new HashMap<>();
          m.put(y, 1);
          map.put(x, m);
        }
        //local max will be max of running value max, and the no of points with slope x/y given by map.get(x).get(y)
        max = Math.max(max, map.get(x).get(y));
     // }
      //global result will be max of running result and sum of max + overlap (to consider points that overlap) + 1 to consider current point in consideration
     result = Math.max(result, max + overlap + 1);
    }

    return result; //T O(n^2) S O(1)
  }

  //recurisve function to compute gcd, if remainder is 0 then return divisor else nr = divisor and dr = nr % dr
  private static int generateGCD(int a, int b) {
    if (b == 0) return a;

    return generateGCD(b, a % b);
  }


  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, 3, 3));
    ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 0, 1, 2, 3, 4));
//
   ArrayList<Integer> AA = new ArrayList<>(Arrays.asList(3, 1, 4, 5, 7, -9, -8, 6));
    ArrayList<Integer> BB = new ArrayList<>(Arrays.asList(4, -8, -3, -2, -1, 5, 7, -4));
    System.out.println("" + maxPoints(A, B));
    System.out.println("" + maxPoints(AA, BB));
    int points[][] = {{-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}, {3, 4}};

    int points2[][] = {{3, 4}, {1, 8}, {4, -3},
        {5, -2}, {7, -1}, {-9, 5}, {-8, 7}, {6, -4}};
    //  int points[][] = { { -1, 1 }, { 0, 0 }, { 1, 1 },
    //      { 2, 2 }, { 3, 3 }, { 3, 4 } };
   // System.out.println(maxPointOnSameLine(points));
   // System.out.println(maxPointOnSameLine(points2));
  }

}



