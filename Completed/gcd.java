import java.util.Scanner;

public class gcd
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter smaller number");
  int a = inp.nextInt();
  System.out.println("Enter greater number");
  int b = inp.nextInt();
  int d,r;
  
  while (true)
  {
  d = b;
  b = a;
  r = d%a;
  
  if (r==0)
  {
  break;
  }
  
  else
  {
  a = r;
  }
  
  }
  
  System.out.println("The greatest common divisor is "+a );
  return;
  }}
  
  