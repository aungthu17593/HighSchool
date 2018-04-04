import java.util.Scanner;

public class quad
{
public static void main(String[]args)
{
    Scanner inp = new Scanner (System.in);
    System.out.println("f(x) = ax^2 + bx + c");
    System.out.println("a =");
    double a = inp.nextDouble();
    System.out.println("b =");
    double b = inp.nextDouble();
    System.out.println("c =");
    double c = inp.nextDouble();
    double d = b*b-4*a*c;
    double r1, r2;
  
  if (d>0)
  {
  r1 = (-b+Math.sqrt(d))/(2*a);
  r2 = (-b-Math.sqrt(d))/(2*a);
  System.out.println("2 real roots: "+r1+","+r2);
  }
  else if (d==0)
  {
  r1 =  (-b)/(2*a);
  System.out.println("1 real root: "+r1);
  }
  else if (d<0)
  {
  r1 = (Math.sqrt(-d))/(2*a); 
  r2 = -b/(2*a);
  System.out.println("2 complex roots: "+r2+"+/-"+r1+"i");   
   }
   return;
   }
   } 