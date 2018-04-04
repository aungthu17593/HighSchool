import java.util.Scanner;

public class Riemann
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter value for a");
  double a = inp.nextDouble();
  System.out.println("Enter value for b");
  double b = inp.nextDouble();
  System.out.println("Enter value for n");
  double n = inp.nextDouble();
  double y, sum;
  sum = 0;
  
  if (a==0)
  {
  a+=((b-a)/n);
  }
  
  for (double x=a; x<b; x+=((b-a)/n))
  {
   y= (x*x);
   sum += (y*((b-a)/n));
   }
   System.out.println("sum = "+sum);
   return;
   }}