import java.util.*;

public class quiz22{
	
	public static void main (String[] args){
		
		Scanner inp = new Scanner (System.in);
		int n = inp.nextInt();
		int trials = inp.nextInt();
		int x, count, tries; 
		count=0; tries=0;
		boolean[] toy = new boolean[n];
		int check;
		
		while(count<trials){
			
			for(int i=0; i<n; i++){
			toy[i]=false;
			}
			
			while(true){
				tries++;
				check=0;
				x = (int)(Math.random()*n);
				toy[x]=true;
				for(int i=0; i<n; i++){
					if(toy[i]==true){
						check++;
					}
				}
				if(check==n){
					break;
				}
			}
		count++;
		}
		double avg = (double)tries/trials;
		System.out.println("Average # of tries "+avg);
	}
}