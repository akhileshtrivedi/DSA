package intermediate.dec_9;

public class ComplexNumber {
    float real, imaginary;

    public ComplexNumber(float real, float imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    ComplexNumber add(ComplexNumber x) {
        return new ComplexNumber(this.real + x.real, this.imaginary + x.imaginary);
    }

    ComplexNumber subtract(ComplexNumber x) {

        return new ComplexNumber(this.real - x.real, this.imaginary - x.imaginary);
    }

    ComplexNumber multiply(ComplexNumber x) {
        return new ComplexNumber(this.real * x.real, this.imaginary * x.imaginary);
    }

    ComplexNumber divide(ComplexNumber x) {
        ;
        return new ComplexNumber(this.real / x.real, this.imaginary / x.imaginary);
    }

}
