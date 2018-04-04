import java.util.Scanner;

public class dicetoss
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter number of experiments");
  int exp = inp.nextInt();
  int n, count;
  double x, avg, y;
  count = 0;
  y= (double)1/6;
  n=0;
  
   while (count<exp)
  {
    while (true)
    { 
    x = Math.random();
    if (x<y)
    {
    count= count+1;
    n+=1;
    break;
    }
    else
    {
    n= n+1;
    }
    
    }
  }
  
  avg = ((double)n)/exp;
  System.out.println("Average number of dice rolls to get a 4 is "+avg);
  return;
  }}