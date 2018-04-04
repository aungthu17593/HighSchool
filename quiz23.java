import java.util.*;

public class quiz23{
	
	public static void main (String[] args){
		
		Scanner inp = new Scanner (System.in);
		double l = inp.nextDouble();
		int trial = inp.nextInt();
		double x,y;
		double[] seg = new double[3];
		int count=0;
		int success=0;
		
		
		while(count<trial){
			x=Math.random()*l;
			y=Math.random()*l;
			if(Double.compare(x,y)<0){
				seg[0]=x;
				seg[1]=y-x;
				seg[2]=l-y;
			}
			else{
				seg[0]=y;
				seg[1]=x-y;
				seg[2]=l-x;
			}
		sort.bubblesort(seg);
		if(Double.compare(seg[0]+seg[1],seg[2])>0){
			success++;
		}		
			count++;
		}
		double p = (double)success/ trial;
		System.out.println("Prob = "+p);
	}
}