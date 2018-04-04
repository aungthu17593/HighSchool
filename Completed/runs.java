import java.util.Scanner;

public class runs
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter total number of games played");
  int G = inp.nextInt();
  System.out.println("Enter total number of games won");
  int m = inp.nextInt();
  System.out.println("Enter number of runs");
  int run = inp.nextInt();
  System.out.println("Input number of trials");
  int t = inp.nextInt();
  double[] s;
  int runs=0;
  int success=0;
  int count=0;
  
  while (count<t)
  {
  runs=0;
  double[] matches = new double [G];
  
  for (int i=0; i<m; i++)
  {
    matches[i]=1;
   }
  for (int i=m; i<G; i++)
  {
  matches[i]=0;
  }
  
  s=foo.shuffle(matches, G);
  
  for (int i=1; i<G; i++)
    {
    if (matches[i-1]==0 && matches[i]==1){
    runs +=1;
    }
    }
  if(matches[0]==1);
    {
    runs +=1;
    }
  if (runs==run)
  {
  success+=1;
  }
  count ++;
  }
  double p = (double) success/ t;
  System.out.println("Probability of having "+run+" runs of wins is "+p);  
  return;
  }}
  