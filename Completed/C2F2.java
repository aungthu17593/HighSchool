import java.util.Scanner; 

public class C2F2
{
  public static void main(String[]args)
    {
      Scanner inp = new Scanner(System.in);
      System.out.println("Enter temperatuere in degrees Celsius");
      double C = inp.nextDouble();
      double F = 1.8*C+32.0;
      System.out.println("Temp(F)="+F);
      return;
}
}