
import java.util.Scanner;

public class decimal2baseN
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter the number in decimal");
  double N = inp.nextDouble();
  System.out.println("Enter output base from 2-9");
  long r=inp.nextLong();
  
    long I, remainder, output, k;
    double decimal,e, multi, bide, check,t;
   
    remainder=0;k=0; output=0;check=0; bide=0;
    I=(long) N;
    decimal = N-I; 
    multi = decimal;
    t=(-1); e=1;
    
     while (I>0)
     {
     remainder = I%r;
     I = I/r;
     output += remainder*(Math.pow(10,k));
     k++;
     }
  k=1;
    
  while(e>0.00001)
    {
      multi *=r;
      for (int i=(int)r-1; i>0; i--)
      {
      if (multi>=i)
      {
      bide+= i*Math.pow(10,t);
      multi-=i;  
      check+=i*Math.pow(r,t);
      break;
      }
      }  
     t--;
     k++;
     
     e=Math.abs((decimal-check)/decimal);
     }
    
     
  double z = output+bide;
  System.out.println("Z = "+z);
  }}