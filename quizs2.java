import java.util.*;

public class quizs2{
	
	public static void main(String[]args){
		
		Scanner inp= new Scanner(System.in);
		int n = inp.nextInt();
		int a = inp.nextInt();
		int b = inp.nextInt();
		double c = inp.nextDouble();
		double d = inp.nextDouble();
		int trial=inp.nextInt();
		int counter=0;
		int success=0;
		
		while(counter<trial){
			
		double[] set = new double[n];
		for(int i=0; i<n; i++){
			set[i]=(Math.random()*(b-a))+a;
		}
		
		sort.mergesort(set);
		int median=(int)Math.floor(set.length/2.0);
		int c1=sort.compare(set[median],c);
		int c2=sort.compare(set[median],d);
		if(c1==1 && c2==-1){
			success++;
		}
		counter++;
		}
		double p = (double)success/trial;
		System.out.println(success);
		System.out.println("p = "+p);
	}
	
	public static int compare(double a, double b){
		double e = 0.000000001;
		int r = 5;
		if (Math.abs(a-b)<=e){
			return(0);
		}

		else if (a-b>e){
			return(1);
		}

		else if (a-b<0){
			r=-1;
		}
		return(r);
	}
}