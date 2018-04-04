import java.util.Scanner;

public class quiz1
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Input E value");
  double E = inp.nextDouble();
  System.out.println("Input x value");
  double x = inp.nextDouble();
  int n=0;
  double er,Sn,Sn1;
  Sn=0;
  Sn1=0;
  er=E;
  
  while (!(er<E))
  {
  n++;
  Sn=0;
  Sn1=0;
  
  for (int i=0; i<n; i++)
  { 
  Sn+= Math.pow(-1,i)*Math.pow(x,i+1)/(i+1);
  }
  
  for (int i=0; i<n+1; i++)
  {
  Sn1+=Math.pow(-1,i)*Math.pow(x,i+1)/(i+1);
  }
 
  er = Math.abs((Sn1-Sn)/Sn1);
  }
  
  System.out.println("Sn(x) = "+Sn);
  System.out.println("Sn+1(x) = "+Sn1);
  System.out.println("n = "+n);
  
  return;
  
  }}
  