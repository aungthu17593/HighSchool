import java.util.Scanner;

public class summation
{
public static void main(String[]args)
{
  Scanner inp =  new Scanner (System.in);
  System.out.println("input value for n");
  int n = inp.nextInt();
  int sum = 0;
  int k = 1;
  
  while (k<=n)
  {
  sum = sum + k;
  k = k+1;
  }
  
  System.out.println(sum);
  return;
  }}