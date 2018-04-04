import java.util.Scanner;

public class montecarlo
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Input M value");
  double M=inp.nextDouble();
  System.out.println("Input a value");
  double a=inp.nextDouble();
  System.out.println("Input b value");
  double b=inp.nextDouble();
  System.out.println("Input N value");
  int N=inp.nextInt();
  int count,n;
  double x,y,f,area;
  count=0;n=0;
  
    while (count<N)
    {
    x=Math.random()*(b-a)+a;
    y=Math.random()*M;
    f=Math.pow(x,3);
    if (y<f) n++;
    count++;
    }
    
    area=n*M*(b-a)/N;
    System.out.println("Area under funcition f from a to b is "+area);
    return;
    }}
    