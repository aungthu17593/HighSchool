import java.util.Scanner;

public class shuffle
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("How many numbers?");
  int n = inp.nextInt();
  
  double[] a = new double [n];
  
  System.out.println("Enter the numbers");
  for (int i=0;i<n;i++){
  a[i]=inp.nextDouble();
  }
  
  int x; double y=0;
       for (int i=0;i<n;i++)
        {
        x = (int)(Math.random()*(n-1-i));    
        y = a[n-1-i];  
        a[n-1-i] = a[x];
        a[x] = y;
        }
  
  for (int i=0;i<n;i++){
  System.out.print(a[i]+" ");
  }
  
  return;
  }}
  