import java.util.*;

public class cramer{
	
	public static void main (String[]args){
	
	Scanner inp =  new Scanner (System.in);	
	System.out.println("How many unknowns?");
	int n = inp.nextInt();
	
	double[][] A = new double[n][n];
	double[][] Xn = new double[n][n];
	double[] C = new double[n];
	double[] X = new double[n];
	double deno;
	
	for(int i=0; i<n; i++){
		for (int j=0; j<n; j++){
			System.out.println("Input A"+i+j);
			A[i][j]=inp.nextDouble();
		}
	}
	
	deno = recursion.determinant(A);
	
	for(int k=0; k<n; k++){
		System.out.println("Input C"+k);
		C[k]= inp.nextDouble();
	}
	
	for(int k=0; k<n; k++){
		for(int i=0; i<n; i++){
			for (int j=0; j<n; j++){
			
			if(j==k) Xn[i][j]= C[i];
			else{
				Xn[i][j]=A[i][j];
			}
			X[k]=recursion.determinant(Xn)/deno;
			}
		}
	}
	
	System.out.println();
	for(int i=0; i<n; i++)
		System.out.println("X"+i+" = "+X[i]);
	return;
	}
}