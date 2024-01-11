package intermediate.dec_9;

public class Rectangle {

    // Define properties here
private int length, width;

    // Define constructor here
    public Rectangle(int length, int width){
        this.length = length;
        this.width = width;
    }


    int perimeter(){
        // Complete the function
        return  2*(length+ width);

    }

    int area(){
        // Complete the function
        return  length* width;
    }
}

/*
    Rectangle a = new Rectangle(2, 3)  // Length = 2, Breadth = 3
	a.perimeter() // Should give 10
    a.area() // Should give 6
*/