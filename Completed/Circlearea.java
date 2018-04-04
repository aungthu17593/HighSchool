import java.util.Scanner;

public class Circlearea
{
  public static void main(String[]args)
    {
     Scanner inp = new Scanner(System.in);
     System.out.println("Enter radius");
     double R = inp.nextDouble();
     double A = Math.PI*R*R;
     System.out.println("Area="+A);
     return;
}
}