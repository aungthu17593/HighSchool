import java.util.Scanner;
public class segments
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter value for point P from 0-1");
  double p = inp.nextDouble();
  System.out.println("Enter number of simulations");
  int points = inp.nextInt();
  double x,sum,avg;
  int count;
   count=0;x=0;sum=0;avg=0;
   
  while (count< points)
  {
  x=Math.random();
  
  if (x<p){
  sum+=(1-x);
  }
  else if (x>p){
  sum+=x;
  }
  count++;
  }
  
  avg=sum/points;
  System.out.println("Average length of segment containing point P is "+avg);
  return;
  }}
  