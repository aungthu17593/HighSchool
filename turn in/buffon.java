import java.util.*;
import java.lang.*;

public class buffon{
	
	public static void main (String[]args){
	
		Scanner inp =  new Scanner (System.in);	
		System.out.println("Enter value for d");
		double d = inp.nextDouble();
		System.out.println("Enter value for l");
		double l = inp.nextDouble();
		System.out.println("Enter number of trials");
		int trials = inp.nextInt();
		double rad, p1, p2;
		int count=0;int success=0;
		int c1, c2;
	
	
		while (count<trials){
			p1 = Math.random()*(2*d);
			rad = Math.random()*(2*Math.PI);
			p2 = p1+l*Math.cos(rad);
			c1=Double.compare(p1,d);
			c2=Double.compare(p2,d);
			if(c1<0 && c2>0) success++;
			else if(c1>0 && c2<0) success++;
			else{
				c1=Double.compare(p1,0);
				c2=Double.compare(p2,0);
				if(c1<0 && c2>0) success++;
				else if(c1>0 && c2<0) success++;
				else{
					c1=Double.compare(p1,2*d);
					c2=Double.compare(p2,2*d);
					if(c1<0 && c2>0) success++;
					else if(c1>0 && c2<0) success++;
					}
			}
			count++;
		}
		
		double prob = (double)success/ trials;
		System.out.println("Probability = "+prob);
	}
}