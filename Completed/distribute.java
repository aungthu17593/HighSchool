import java.util.Scanner;

public class distribute
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter number of students");
  int n = inp.nextInt();
  System.out.println("Enter number of trials");
  int trial = inp.nextInt();
  int count, f;
  double[] b;
  double p;
  count = 0; f=0;
  
  double[] a = new double [n];
    for (int i=0; i<n; i++)
    { 
    a[i]=i;
    }
  
  while (count<trial)
    {
     b = foo.shuffle(a,n);
     
     for (int i=0; i<n; i++)
     {
     
      if (b[i]==i)
      {
      f++;
      break;
     }}
     
     count++;
    }
    
    p = (double) (trial-f)/ trial;
    System.out.println("Probability of none of the students getting their book is "+p);
    
    return;
    }}
     
    
