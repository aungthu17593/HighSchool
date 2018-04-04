import java.util.Scanner;

public class standarddeviation
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter value for a");
  double a = inp.nextDouble();
  System.out.println("Enter value for b");
  double b = inp.nextDouble();
  System.out.println("Enter value for n");
  int n = inp.nextInt();
  double sum, avg, s, sum2;
  sum=0;
  sum2=0;
  
  double [] x = new double [n];
  
  for (int i=0; i<n; i++)
  {
  x[i] = Math.random() * (b-a)+a;
  sum += x[i];
  }
  
  avg = sum/n;
  
  for (int i=0; i<n; i++)
  {
  sum2 += (x[i]-avg)*(x[i]-avg);
  }
  
  s = Math.sqrt( sum2/ (n-1)); 
  
  System.out.println("The standard deviation is "+s);

  return;
  }}