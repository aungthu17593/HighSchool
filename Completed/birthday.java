import java.util.Scanner;

public class birthday
{
public static void main (String[]args)
{
    Scanner inp = new Scanner (System.in);
    System.out.println("Input number of students");
    int n = inp.nextInt();
    System.out.println("Input number of trials");
    int trial = inp.nextInt();
    int a=0;
    int same,count, students;
    count=0; same=0; students=0; 
    int bday;
    while (count<trial)
    {
   
    int [] x = new int [365];
    for (int i=0; i<365; i++)
    {
      x[i]=0;
    }
    students=0;
      while (students<n)
      {
        bday = (int)(Math.random()*365);
        students++;
      
        if (x[bday]==1)
        {
        same++;
        break;
        }
        else{ 
        x[bday]=1;
        }
      }
      
      
      count++;
   }
   
    double p = ((double)same)/trial;
    System.out.println("Probability = "+p);
    return;
    }}
    
    
    
    
    
    
     
    
    
    
   