import java.util.*;

public class testcomplex
{
	public static void main (String[]args){
		Scanner inp= new Scanner (System.in);
		
		Complex a= new Complex(1.0,-2.0);
		
		Complex[] z = Complex.rationalpow(a,1,8);
		
		for (int i=0; i<z.length; i++){
		System.out.println(z[i]);	
		}
		
		System.out.println("angle"+a.arg());
		

		System.out.println("");
		Complex[] b = Complex.root((new Complex(1.0,0)),3);
		
		for (int i=0; i<b.length; i++){
		System.out.println(b[i]);	
		}


		System.out.println("Question 2");

		int m = 25;

		Complex[] x= new Complex[m];
		Complex sum = new Complex();	
		Complex xj;

		for(int k=0; k<m+1; k++){
		xj= Complex.divide(new Complex(k,1.0), new Complex (1.0,k));
		sum = sum.add(xj);	
		}
		System.out.println(sum);
		System.out.println(sum.arg());

		m=15;
		Complex P= Complex.divide(new Complex(0,1.0), new Complex(1.0,0));
		for (int k=1; k<m+1; k++){
			xj= Complex.divide(new Complex(k,1.0), new Complex (1.0,k));
			P= P.multiply(xj);
		}
		System.out.println(P);
		System.out.println(P.arg());

		System.out.println("Question 3");

		double[][] M = new double[6][6];
		double x1=2.0;
		for(int i=0; i<6; i++){
			for (int j=0; j<6; j++){
				M[i][j]=Math.pow(x1,j);
			}
			x1+=0.5;
		}
		double det= recursion.determinant(M);
		System.out.println(det);

		System.out.println("Question 4");

		int n= 21;
		Complex[] xn = new Complex[n];
		xn[0]=new Complex();

		for (int i=1; i<n; i++){
			xn[i]= Complex.divide(new Complex(Math.pow(-1,i)*i,0), xn[i-1].add(new Complex(1.0,1.0)));
		}
		System.out.println(xn[20]);
		System.out.println(xn[10].arg());

		return;
	}
}
