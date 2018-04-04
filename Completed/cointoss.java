import java.util.Scanner;

public class cointoss
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Number of coin toss");
  int n = inp.nextInt();
  double x;
  double k, h, p;
  k=1;
  h=0;
 
  while (k<=n)
  {
  x = Math.random();
  if (x<0.5)
  {
  k = k+1;
  h = h+1;
  }
  else 
  {
  k = k+1;
  }
  }
  
  p = ((double)h)/n;
  System.out.println("Probability of heads " + p);
  return;
  }}