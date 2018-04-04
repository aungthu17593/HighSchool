import java.util.Scanner;

public class craps
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter number of trials");
  int trial = inp.nextInt();
 
  int n, count, a, b,c;
  n=0;
  count = 0;
  
  double x, y, p;
  
  while (count<trial)
  {
    while (true)
    {
      x = Math.random();
      y = Math.random();
      a = (int)(x*6+1);
      b = (int)(y*6+1);
      c = a+b;
    if ( c==7 || c==11 )
    {
      n +=1;
      count +=1;
      break;
    }
    else if ( c==2 || c==3 || c==12 )
    {
      count+=1;
      break;
    }
    
    else
    {
    int point = c;
      while (true)
      {  
        x = Math.random();
        y = Math.random();
        a = (int)(x*6+1);
        b = (int)(y*6+1);
        c = a+b;
       
        if ( c==point )
      {
        n +=1;
        count +=1;
        break;
      }
      else if ( c==7 )
      {
      count+=1;
      break;
      }
     }
      break;
    }
    
    }}
   
    p = ((double)n)/trial;
    System.out.println("Probability of winning is "+p);
    return;
    }}
    
    
    
    
    
    