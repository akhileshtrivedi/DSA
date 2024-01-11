package intermediate.dec_9;

public class Fraction {
    int numerator, denominator;

    // Define constructor here
    Fraction() {
        numerator = 0;
        denominator = 1;
    }

    //constructor
    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //accessor for numerator
    int getNumerator() {
        return numerator;
    }

    //mutator for numerator
    void setNumerator(int num) {
        numerator = num;
    }

    //accessor for denominator
    int getDenominator() {
        return denominator;
    }

    //mutator for denominator
    void setDenominator(int denom) {
        denominator = denom;
    }
    private int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }
    private Fraction lowest(int den3, int num3)
    {
        int common_factor = gcd(num3,den3);
        den3 = den3/common_factor;
        num3 = num3/common_factor;
        Fraction temp = new Fraction();
        temp.numerator = num3 / den3;
        return temp;
    }

  Fraction add(Fraction a){
        // Complete the function
      Fraction  f = new Fraction();

      int den3 = gcd(this.denominator,a.denominator);

      den3 = (this.denominator*a.denominator) / den3;

      int num3 = (this.numerator)*(den3/this.denominator) + (a.numerator)*(den3/a.denominator);
      return lowest(den3,num3);
    }

 Fraction subtract(Fraction a){
        // Complete the function
      Fraction  f = new Fraction();

      int den3 = gcd(this.denominator,a.denominator);

      den3 = (this.denominator*a.denominator) / den3;

      int num3 = (this.numerator)*(den3/this.denominator) - (a.numerator)*(den3/a.denominator);
      return lowest(den3,num3);
    }

       Fraction multiply(Fraction a){
        // Complete the function
           Fraction  f = new Fraction();

           int den3 = gcd(this.denominator,a.denominator);

           den3 = (this.denominator*a.denominator) / den3;

           int num3 = (this.numerator)*(den3/this.denominator) * (a.numerator)*(den3/a.denominator);
           return lowest(den3,num3);
    }
}