/**
*This is a class for Complex numbers.
*This class contains methods for basic complex number manipulations
*
*@author Aung Thu
*@since 2015-12-18 
*/

public class Complex implements Comparable{
  private double a;
  private double b;

  /**
  *no argument constructor
  */  
  public Complex(){
    a=0.0;
    b=0.0;
  }

  /**
  *This constructor initializes a complex number 0+iy.
  *
  *@param y value of imaginary part
  */  
  public Complex(double y) {
    a=0.0;
    b=y;
  }

  /**
  *This constructor initializes a complex number x+0i.
  *with dummy variable I.
  *
  *@param x value of real part
  *@param I dummy variable
  */  
  public Complex(double x, String I){
    a=x;
    b=0.0;
  }

  /**
  *This constructor initializes a complex number x+iy.
  *
  *@param x value of real part
  *@param y value of imaginary part
  */  
  public Complex(double x, double y){
    a=x;
    b=y;
  }

  /**
  *This is a copy constructor.
  *
  *@param z Complex number that is being duplicated.
  */
  public Complex(Complex z){
    a=z.a;
    b=z.b;
  }
  
  /**
  *This method is used to get the value of real part of a complex number.
  *
  *@return This returns a of complex number a+ib.
  */
  public double geta(){
    return(a);
  }
  
  /**
  *This method is used to get the value of imaginary part of a complex number.
  *
  *@return This returns b of complex number a+ib.
  */
  public double getb(){
    return(b);
  }
  
  /**
  *This method is used to change/set the vaule of real part of a complex number.
  *
  *@param x vaule of real part
  */
  public void seta(double x){
    a=x; return;
  }

  /**
  *This method is used to change/set the vaule of imaginary part of a complex number.
  *
  *@param y vaule of imaginary part
  */
  public void setb(double y){
    b=y; return;
  } 
  
  /**
  *This method is used to print out the complex number in the form of
  *a+bi. This method also rounds the values to 2 decimal places.
  *
  *@return prints out "a+bi"
  */
  public String toString(){
      return(String.format("%.2f",a)+"+"+String.format("%.2f",b)+"i");
  }

  /**
  *This method is used to test if two complex numbers are equal.
  *
  *@param P Complex number tested to see if its equal. 
  *@return True if they are equal. False if they are not.
  */
  public boolean equals(Object P){ 
      boolean result=false;
      if (this.getClass() != P.getClass())
      {
        return(false);
      }
      else
      {
        Complex that = (Complex) P;
        result=((this.geta()==that.geta()) && (this.getb()==that.getb()));
        return(result);
      } 
    }
  
  /** 
  *This method is used to compare complex numbers based on their modulus.
  *
  *@param p complex number being compared against.
  *@return 0 if they're modulus are equal, 1 if this is greater than other, -1 if this is smaller. 
  */
  public int compareTo(Object p){
    if (this.getClass()!=p.getClass()) return (99999);
    else{
      Complex other=(Complex) p;
      if (this.modulus()>other.modulus()) return(1);
      else if (this.modulus()==other.modulus()){
        return(0);
      }
      else { 
        return(-1);  
      }}
  }

  /** 
  *This method is used to calculate the modulus of a complex number
  *
  *@return modulus of the complex number
  */
  public double modulus(){
    return(Math.sqrt(a*a+b*b));
  }

  /**
  *This is the static method for modulus
  *
  *@param z Complex number to find the mod of.
  *@return mod of z.
  */
  public static double modulus(Complex z){
    return(z.modulus());
  }

  /**
  *This method is used to calculate the argument of a complex number. The argument is
  *the angle made by the complex number with the positive x-axis.
  *
  *@return arguemnt of complex number in radians.
  */
  public double arg(){
    double theta=Math.atan(b/a);
    if (a>0) return(theta);
    else if (a<0 && b>=0) {return(theta+Math.PI);}
    else if (a<0 && b<0) {return (theta-Math.PI);}
    else if (a==0 && b>0) {return (Math.PI/2);}
    else if (a==0 && b<0){return (-Math.PI/2);}
    else {return (0.0);}
  }
  
  /**
  *This is a static method for arg
  *
  *@param z complex number to find arg of.
  *@return arg of z.
  */
  public static double arg(Complex z){
    return(z.arg());
  }

  /**
  *This method is used to initialize a complex number using modulus and argument as 
  *an input. It is useful when only the polar coordinates of a complex number are known.
  *
  *@param r modulus.
  *@param Q argument in radians.
  *@return complex number (a+ib)
  */
  public static Complex polar(double r, double Q){
    return(new Complex(r*Math.cos(Q), r*Math.sin(Q)));
  } 

  /**
  *This method is used to find the conjugate of a complex number
  *
  *@return conjugate of the complex number
  */
  public Complex conjugate(){
    return( new Complex(a,-b));
  }

  /**
  *This is a static method for conjugate
  *
  *@param z Complex number to find the conjugate of.
  *@return conjagate of z.
  */
  public static Complex conjugate(Complex z){
    return(z.conjugate());
  }

  /** 
  *This method is used to add 2 complex numbers.
  *
  *@param x complex number that is added.
  *@return The sum of this and x.
  */ 
  public Complex add(Complex x){
    return(new Complex(a+x.a, b+x.b));
  }
  
  /**
  *This is a static method for add.
  *
  *@param x first complex number for sum.
  *@param y second complex number for sum.
  *@return x+y.
  */
  public static Complex add(Complex x, Complex y){
    return(x.add(y));
  }
  
  /**
  *This method is used to find the differece between 2 complex numbers.
  *
  *@param x complex number that is subtracted from this.
  *@return The difference between this and x.
  */
  public Complex subtract(Complex x){
    return(new Complex(a-x.a, b-x.b));
  }
  
  /**
  *This is the static method for subtract
  *
  *@param x complex number subtracted from.
  *@param y complex number subtracted.
  *@return x-y.
  */
  public static Complex subtract(Complex x, Complex y){
    return(x.subtract(y));
  }

  /**
  *This method is used to multiply two complex numbers.
  *
  *@param x one of the complex numbers that is being multiplied. 
  *@return multiplication of 2 complex numbers.
  */
  public Complex multiply(Complex x){
    return(new Complex((a*x.a)-(b*x.b),(a*x.b)+(b*x.a)));
  }
  
  /**
  *This is the static method for multiply.
  *
  *@param x first complex number for multiplication.
  *@param y second complex number for multiplication.
  *@return x*y.
  */
  public static Complex multiply(Complex x, Complex y){
    return(x.multiply(y));
  }

  /**
  *This method is used to find division between two complex numbers.
  *
  *@param x divisor
  *@return answer of this/x.
  */
  public Complex divide(Complex x){
    Complex temp= this.multiply(x.conjugate());
    double t= x.a*x.a+x.b*x.b;
    return(new Complex(temp.a/t , temp.b/t));
  }
  
  /**
  *This is the static method for divide.
  *
  *@param x dividend
  *@param y divisor
  *@return x/y.
  */
  public static Complex divide(Complex x, Complex y){
    return(x.divide(y));
  }
  
  /**
  *This method is used to rotate a complex number on argand diagram around the origin by an angle Q.
  *
  *@param Q rotation angle in radians.
  *@return the rotated complex number.
  */
  public Complex rotate(double Q){
    double x,y;
    x=a*Math.cos(Q)-b*Math.sin(Q);
    y=a*Math.sin(Q)+b*Math.cos(Q);
    return(new Complex(x,y));
  }

  /**
  *This is the static method for rotate.
  *
  *@param z Complex number that is being rotated.
  *@param Q rotation angle in radains.
  *@return z rotated by Q.
  */
  public static Complex rotate(Complex z, double Q){
    return(z.rotate(Q));
  }
  
  /**
  *This method is used to rotate a complex number on argand diagram around a point by an angle Q.
  *First, the point of rotation is subtracted from complex number, then the complex number is rotated. 
  *Next the point of rotation is added back to the complex number.
  *
  *@param Q rotation angle in radians.
  *@param rotatept the point of rotation
  *@return the rotated complex number.
  */
  public Complex rotate(double Q, Complex rotatept){ 
    Complex temp= new Complex(a-rotatept.a, b-rotatept.b);
    temp=temp.rotate(Q);
    return(new Complex(temp.a+rotatept.b,temp.b+rotatept.b));
  }
  
  /**
  *Static method for rotate about a point.
  *
  *@param z complex number that is being rotated.
  *@param Q angle of rotation in radians.
  *@param rotatept point of rotation.
  *@return z rotated by Q radians around rotatept.
  */
  public static Complex rotate(Complex z, double Q, Complex rotatept){
    return(z.rotate(Q, rotatept));
  }  
  
  /**
  *This method is used to raise a complex number to the power n.
  *Static polar method is used to create a complex number with modulus r^n and argument n*Q.
  *
  *
  *@param n power or exponent
  *@return complex number raised to power n.
  */
  public Complex pow(int n){
    double r= Math.pow(this.modulus(),n);
    double Q= this.arg();
    return(Complex.polar(r,n*Q));
  }

  /**
  *Static method of pow.
  *
  *@param z base complex number.
  *@param n power or exponent.
  *@return z^n.
  */
  public static Complex pow(Complex z, int n){
    return(z.pow(n));
  }

  /**
  *This method is used to find nth root of a complex number.
  *Static polar method is used to create a complex number with modulus r^(1/n)
  *and argument ((Q+2kpi)/n).
  *
  *@param n index.
  *@return nth roots of the complex number in an array.
  */
  public Complex[] root(int n){
    double Q=this.arg();
    double r= Math.pow(this.modulus(),1/n);
    Complex[] recomp= new Complex[n];
    for(int i=0;i<n;i++){
      recomp[i]= Complex.polar(r,(Q+2*i*Math.PI)/n);
    }
    return(recomp);
  }

  /**
  *Static method for root.
  *
  *@param z complex radicand.
  *@param n index.
  *@return nth roots of z. 
  */
  public static Complex[] root(Complex z, int n){
    return(z.root(n));
  }

  /**
  *This method is used to raise a complex number to a rational power m/n.
  *First nth root is calculated using root method, then each root is raised to the 
  *power m using pow method.
  *
  *@param m numerator of index.
  *@param n denomator of index.
  *@return an array of complex numbers raised to the power m/n.
  */
  public Complex[] rationalpow(int m, int n){
    Complex[] recomp = this.root(n);
    for(int i=0;i<n;i++){
      recomp[i]=recomp[i].pow(m);
    }
    return(recomp);
  }

  /**
  *Static method for rationalpow.
  *
  *@param z base complex number.
  *@param m numberator of index.
  *@param n denomator of index.
  *@return z^(m/n).
  */
  public Complex[] rationalpow(Complex z, int m, int n){
    return(z.rationalpow(m,n));
  }

  /**
  *This metod is used to find the natural log of a complex number.
  *This uses the formula ln z = lnr+iQ.
  *
  *@return natural log of complex number.
  */
  public Complex ln(){
    return(new Complex(Math.log(this.modulus()), this.arg()));
  }

  /**
  *Static method for ln.
  *
  *@param z argument for ln.
  *@return ln(z).
  */
  public static Complex ln(Complex z){
    return(z.ln());
  }

  /**
  *This method is used to find the roots of a quadratic function f(x)=ax^2+bx+c.
  *
  *@param a1 value of a in f(x).
  *@param b1 value of b in f(x).
  *@param c1 value of c in f(x).
  *@return roots of quadratic function in an array.
  */
  public static Complex[] quadf(double a1, double b1, double c1){
    Complex[] r =  new Complex[2];
    double m = b1*b1-4*a1*c1;
    if (m<0){
    r[0]= new Complex(-b1/(2*a1), Math.sqrt(-m)/(2*a1));
    r[1]= new Complex(-b1/(2*a1), -Math.sqrt(-m)/(2*a1));
    }
    else if (m==0){
      r[0]= new Complex(-b1/(2*a1));
    }
    else{
      r[0]= new Complex((-b1+Math.sqrt(m))/(2*a1),0.0);
      r[1]= new Complex((-b1-Math.sqrt(m))/(2*a1),0.0);
    }
    return(r);
  }

  /**
  *This method is used to find the hyperbolic sine of an angle.
  *
  *@param x angle in radians.
  *@return sinh(x).
  */
  public static double sinh(double x){
    return((Math.pow(Math.E,x)-Math.pow(Math.E,-x))/2);
  }

  /**
  *This method is used to find the hyperbolic cosine of an angle.
  *
  *@param x angle in radians.
  *@return cosh(x).
  */
  public static double cosh(double x){
    return((Math.pow(Math.E,x)+Math.pow(Math.E,-x))/2);
  }

  /**
  *This method is used to find the hyperbolic tangent of an angle.
  *sinh(x) is divided by cosh(x) to get tanh(x).
  *
  *@param x angle in radians.
  *@return tanh(x).
  */
  public static double tanh(double x){
    return(Complex.sinh(x)/Complex.cosh(x));
  }

  /**
  *This method is used to find the hyperbolic secant of an angle.
  *inverse of cosh(x) is used to get sech(x).
  *
  *@param x angle in radians.
  *@return sech(x).
  */
  public static double sech(double x){
    return(1/Complex.cosh(x));
  }

  /**
  *This method is used to find the hyperbolic cosecant of an angle.
  *inverse of sinh(x) is used to get csch(x).
  *
  *@param x angle in radians.
  *@return csch(x).
  */
  public static double csch(double x){
    return(1/Complex.sinh(x));
  }

  /**
  *This method is used to find the hyperbolic cotangent of an angle.
  *inverse of tanh(x) is used to get coth(x).
  *
  *@param x angle in radians.
  *@return coth(x).
  */
  public static double coth(double x){
    return(1/Complex.tanh(x));
  }

  /**
  *This method is used to find sine of a complex number.
  *
  *@return sine of the complex number.
  */
  public Complex sin(){
    return(new Complex(Math.sin(a)*Complex.cosh(b), Math.cos(a)*Complex.sinh(b)));
  }

  /**
  *Static method for sin.
  *
  *@param z complex number to find the sin of.
  *@return sin(z).
  */
  public static Complex sin(Complex z){
    return(z.sin());
  }

  /**
  *This method is used to find cosine of a complex number.
  *
  *@return cosine of the complex number.
  */
  public Complex cos(){
    return(new Complex(Math.cos(a)*Complex.cosh(b), -Math.sin(a)*Complex.sinh(b))); 
  }

  /**
  *Static method for cosine.
  *
  *@param z complex number to find the cosine of.
  *@return cos(z).
  */
  public static Complex cos(Complex z){
    return(z.cos());  
  }

  /**
  *This method is used to find tangent of a complex number.
  *
  *@return tangent of the complex number.
  */
  public Complex tan(){
    return(Complex.divide(this.sin(),this.cos()));
  }

  /**
  *Static method for tan.
  *@param z complex number to find the tangent of.
  *@return tan(z).
  */
  public static Complex tan(Complex z){
    return(z.tan());
  }

  /**
  *This method is used to find secant of a complex number.
  *Inverse of cosine of the complex number is found using pow method.
  *
  *@return secant of the complex number.
  */
  public Complex sec(){
    return(Complex.pow(this.cos(),-1));
  }

  /**
  *Static method for sec.
  *
  *@param z complex number to find the secant of.
  *@return sec(z).
  */
  public static Complex sec(Complex z){
    return(z.sec());
  }
  
  /**
  *This method is used to find cosecant of a complex number.
  *Inverse of sine of the complex number is found using pow method.
  *
  *@return cosecant of the complex number.
  */
  public Complex csc(){
    return(Complex.pow(this.sin(),-1));
  }

  /**
  *Static method for csc.
  *
  *@param z complex number to find the cosecant of.
  *@return csc(z).
  */
  public static Complex csc(Complex z){
    return(z.csc());
  }

  /**
  *This method is used to find cotangent of a complex number.
  *Inverse of tangent of the complex number is found using pow method.
  *
  *@return cotangent of the complex number.
  */
  public Complex cot(){
    return(Complex.pow(this.tan(),-1));
  }

  /**
  *Static method of cot.
  *
  *@param z complex number to find the cotangent of.
  *@return cot(z).
  */
  public static Complex cot(Complex z){
    return(z.cot());
  }

  /**
  *This method is used to find hyperbolic arcsine of a number.
  *
  *@param x value of sinh(Q).
  *@return arcsinh(x) in radians
  */
  public static double arcsinh(double x){
    return(Math.log(x+Math.sqrt(x*x+1)));
  }

  /**
  *This method is used to find hyperbolic arccosine of a number.
  *
  *@param x value of cosh(Q).
  *@return arccosh(x) in radians
  */
  public static double arccosh(double x){
    return(Math.log(x+Math.sqrt(x*x-1)));
  }

  /**
  *This method is used to find hyperbolic arctangent of a number.
  *
  *@param x value of tanh(Q).
  *@return arctanh(x) in radians
  */
  public static double arctanh(double x){
    return(0.5*Math.log((1+x)/(1-x)));
  }

  /**
  *This method is used to find hyperbolic arcsecant of a number.
  *
  *@param x value of sech(Q).
  *@return arcsech(x)
  */
  public static double arcsech(double x){
    return(Math.log((1/x)+Math.sqrt((1/(x*x))-1)));
  }

  /**
  *This method is used to find hyperbolic arccosecant of a number.
  *
  *@param x value of csch(Q).
  *@return arccsch(x)
  */
  public static double arccsch(double x){
    return(Math.log((1/x)+Math.sqrt((1/(x*x))+1)));
  }

  /**
  *This method is used to find hyperbolic arccotangent of a number.
  *
  *@param x value of coth(Q).
  *@return arccoth(x)
  */
  public static double arccoth(double x){
    return(0.5*Math.log((x+1)/(x-1)));
  }
}