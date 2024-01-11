package intermediate.dec_9;

public class DriverClass {


    public static void main(String[] args) {


        Complex a = new Complex(10, 5);
        Complex b = new Complex(2, 3);
        Complex c1 = a.add(b);
        System.out.println(c1.real+"---"+c1.imaginary);
        Complex c2 = a.subtract(b);
        System.out.println(c2.real+"---"+c2.imaginary);
        Complex c3 = a.multiply(b);
        System.out.println(c3.real+"---"+c3.imaginary);
        Complex c4 = a.divide(b);
        System.out.println(c4.real+"---"+c4.imaginary);

//        Circle a = new Circle(3) ; // Radius = 3
//        System.out.println(""+ a.perimeter());
//        System.out.println(""+ a.area());
        //a.perimeter() // 18.84
       // a.area() // 28.26
//        Rectangle a = new Rectangle(2, 3);  // Length = 2, Breadth = 3
//        System.out.println(""+ a.perimeter());
//        System.out.println(""+ a.area());
      //  a.perimeter() // Should give 10
      //  a.area() // Should give 6
        Fraction x = new Fraction(2, 3);  // 2/3
        Fraction y = new Fraction(4, 5); // 4/5
        Fraction z = x.add(y); // 22/15
        System.out.println("Fraction--> "+ z.numerator);
        Fraction z2 = x.subtract(y) ;// -2/15
        System.out.println("Fraction--> "+ z2.numerator);
        Fraction z3 = x.multiply(y); // 8/15
        System.out.println("Fraction--> "+ z3.numerator);
      /*  Fraction z = x.add(y); // 22/15
        Fraction z = x.subtract(y) ;// -2/15
        Fraction z = x.multiply(y); // 8/15   */


    }
}
