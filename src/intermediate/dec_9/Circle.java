package intermediate.dec_9;

public class Circle {

    // Define properties here
    private float radius;
    static final float PI = (float) 3.14;

    // Define constructor here
    public Circle(float radius) {
        this.radius = radius;
    }

    float perimeter(){
        // Complete the function
        return 2 * radius * PI;
    }

    float area(){
        System.out.println(PI);
        // Complete the function
        return radius * radius * PI;
    }
}