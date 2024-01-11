package intermediate.dec_9;

public class Complex {
    float real, imaginary;

    Complex()
    {
    }
    Complex(int tempReal, int tempImaginary)
    {
        real = tempReal;
        imaginary = tempImaginary;
    }
    Complex add(Complex x)
    {
        Complex temp = new Complex();
        temp.real = this.real + x.real;
        temp.imaginary = this.imaginary + x.imaginary;
        return temp;
    }

    Complex subtract(Complex x)
    {
        Complex temp = new Complex();
        temp.real = this.real - x.real;
        temp.imaginary = this.imaginary - x.imaginary;
        return temp;
    }

    Complex multiply(Complex x) {
        Complex temp = new Complex();
        temp.real = this.real * x.real;
        temp.imaginary = this.imaginary * x.imaginary;
        return temp;
    }

    Complex divide(Complex x) {

        Complex temp = new Complex();
        temp.real = this.real / x.real;
        temp.imaginary = this.imaginary / x.imaginary;
        return temp;
    }
}
