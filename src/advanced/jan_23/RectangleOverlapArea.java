package advanced.jan_23;

public class RectangleOverlapArea {
  /**
   * Calculate the overlapping area of two rectangles.
   */
  private static int overlapArea(int A, int B, int C, int D,
      int E, int F, int G, int H) {
    /* Check if there is indeed an overlap.
     * e.g.  E >= C  i.e. the most left point of the rectangle (EFGH) is
     *       on the right side of the most right point of the rectangle (ABCD),
     *       therefore there is no overlapping.
     */
    if ( (E>=C) || (F>= D) || (A>=G) || (B >= H) )
      return 0;

    /* bottom left point of the overlapping area. */
    int bl_x = Math.max(A, E);
    int bl_y = Math.max(B, F);

    /* top right point of the overlapping area. */
    int tr_x = Math.min(C, G);
    int tr_y = Math.min(D, H);

    return (tr_x - bl_x) * (tr_y - bl_y);
  }

  /**
   * Calculate the area of a single rectangle.
   */
  private static int computeArea(int A, int B, int C, int D) {
    return (C-A) * (D-B);
  }

  /**
   * Find the total area covered by two rectilinear rectangles in a 2D plane.
   * Each rectangle is defined by its bottom left corner and top right corner.
   */
  private static int computeArea(int A, int B, int C, int D,
      int E, int F, int G, int H) {
    // The addition of area of the two rectangles minus the overlapping area.
    return computeArea(A, B, C, D) + computeArea(E, F, G, H) -
        overlapArea(A, B, C, D, E, F, G, H);
  }

  public static void main(String[] args) {
    System.out.println(""+overlapArea(0,0,4,4,2,2,6,6));
    System.out.println(""+overlapArea(0,0,4,4,2,2,3,3));
  }
}
