import java.util.Scanner;

public class transpose 
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter number of rows");
  int m = inp.nextInt();
  System.out.println("Enter number of columns");
  int n = inp.nextInt();
  
  System.out.println("Enter values for matrix X");
  
  double [][] x = new double [m][n];
  
  for (int i=0; i<m; i++){
  for (int j=0; j<n; j++){  
    x[i][j] = inp.nextDouble();
    }}
    
  double [][] xT = new double [n][m];
  
  for (int i=0; i<n; i++){
  for (int j=0; j<m; j++){
    xT[i][j] = x[j][i];
    }}
  
  System.out.println(" ");
  System.out.println("Original matrix X");
  System.out.println(" ");
  
  for (int i=0; i<m; i++){
  for (int j=0; j<n; j++){
  System.out.print(x[i][j]+" ");
  }
  System.out.println(" ");
  }
  
  System.out.println(" ");
  System.out.println(" ");
  System.out.println("Transpose matrix XT");
  System.out.println(" ");  
  
  for (int i=0; i<n; i++){
  for (int j=0; j<m; j++){
  System.out.print(xT[i][j]+" ");
  }
  System.out.println(" ");
  }
  
  return;
  }}
  