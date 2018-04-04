import java.util.Scanner;

public class matrixmulti
{
public static void main(String[]args)
{
  Scanner inp = new Scanner (System.in);
  System.out.println("Enter number of rows and columns for square matrix");
  int n = inp.nextInt();
  System.out.println("Enter value for power");
  int m= inp.nextInt();
  double input;

  System.out.println("Enter values for matrix X");
  
  double [][] x = new double [n][n];
  double [][] A = new double [n][n];
  
  for (int i=0; i<n; i++){
  for (int j=0; j<n; j++){  
    input = inp.nextDouble();
    x[i][j]= input;
    A[i][j]=input;
    }}
  
  for (int k=0; k<m-1; k++){
  A=foo.matrixmultiply (A,x,n,n,n);
   }
  System.out.println(" ");
  System.out.println("Original matrix");  
  for (int i=0; i<n; i++){
  for (int j=0; j<n; j++){
  System.out.print(x[i][j]+" ");
  }
  System.out.println(" ");
  }
  System.out.println(" ");  
  System.out.println("Multiplied matrix");  
  for (int i=0; i<n; i++){
  for (int j=0; j<n; j++){
  System.out.print(A[i][j]+" ");
  }
  System.out.println(" ");
  }
  return;
  }}