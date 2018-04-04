import java.util.Scanner;

public class threenumbers
{
  public static void main(String[]args)
    {
      Scanner inp = new Scanner(System.in);
      System.out.println("Enter 3 numbers");
      int A = inp.nextInt();
      int B = inp.nextInt();
      int C = inp.nextInt();
      
  if (A>B && A>C)
   { 
   System.out.println("The Greatest number is "+A);
   }
   else if (B>C && B>A)
   {
   System.out.println("The Greatest number is "+B);
   }
   else if (C>A && C>B)
   {
   System.out.println("The Greatest number is "+C);
   }
   return;
    }
    }