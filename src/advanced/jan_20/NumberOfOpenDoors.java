package advanced.jan_20;

public class NumberOfOpenDoors {

  static int countOpenDoors(int N)
  {
    int doorsOpen = (int) Math.sqrt(N);
    return doorsOpen;
  }

  // Driver Code
  public static void main (String[] args) {

    System.out.println(countOpenDoors(5));
    System.out.println(countOpenDoors(6));

  }
}


