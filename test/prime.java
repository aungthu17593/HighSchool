import java.util.Scanner;

public class prime
{
public static void main (String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter n");
  int n = inp.nextInt();
  int number, count;
  double check=0;
  check=0;
  count= 1; number=3;
  int [] x = new int[n];
  x[0]=2; 
  
  while (count<n){
  
  for (int i=0; i<count; i++)
  {
    
    check = number%x[i];
    if (check==0)
    {break;}
  }
    if (!(check==0)){
    x[count]=number;
    count++;
     }
    number+=2;
   
  } 
  
 
 
    System.out.println("Nth prime number is "+ x[n-1]);

  return;
  }}
 