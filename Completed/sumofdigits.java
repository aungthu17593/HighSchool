import java.util.Scanner;

public class sumofdigits
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter an integer");
  int n = inp.nextInt();
  int s=0;
  
  if (n<0)
  {
  n= -n;
  }
  
  while (n>0)
  {
    s = s +(n%10);
    n = n/10;
   }
   System.out.println("Sum of digits is "+s);
   return;
   }
   } 
    
  