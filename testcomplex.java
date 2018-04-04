import java.util.*;

public class testcomplex
{
	public static void main (String[]args){
		Scanner inp= new Scanner (System.in);
		Complex a= new Complex(1, 0);
		Complex y= new Complex(4.5,-6.6);
		Complex[] z = a.root(2);
		System.out.println(z[0]);

		double[][] x = new double[4][4];
		for(int i=0; i<4; i++){
			for (int j=0; j<4; j++){
				x[i][j]=i*j;
			}
		}

		x=recursion.deleterow(x,1);

		for(int i=0; i<x.length; i++){
		System.out.println(Arrays.toString(x[i]));
		}
	}
}
