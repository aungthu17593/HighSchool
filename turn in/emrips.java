import java.util.*;

public class emrips{
	
	public static void main(String[]args){
		
		Scanner inp = new Scanner (System.in);
		System.out.println("Input n");
		int n = inp.nextInt();
		
		int number = 3; int count = 0; int check =0; 
		 
		int re;
		
		ArrayList<Integer> prime = new ArrayList<Integer>();
		int[] emrip = new int[n];
		
		prime.add(2);
		prime.add(3);
		
		while(count<n){
			number+=2;
			for(int i=0; i<prime.size(); i++){
				if((Double.compare((double)prime.get(i),Math.sqrt(number)))>0) break;
				check= number%prime.get(i);
				if(check==0) break;
			}
			
			if(check!=0){
				prime.add(number);
				re = reverse(number);
				
				if(re!=number && re>number && re%2==1){
					for(int i=0; i<prime.size(); i++){
						if((Double.compare((double)prime.get(i),Math.sqrt(re)))>0) break;
						check= re%prime.get(i);
						if(check==0) break;
					}
					
					if(check!=0){
						emrip[count]=number;
						count++;
					}
				}
			}
		}
  
		System.out.println("Nth pair of emrips is "+emrip[n-1]+" and "+reverse(emrip[n-1]));
	
		return;
	}
	
	public static int reverse(int n){
		int temp=n;
		int reverse=0;
		
		while (temp>=1){
			reverse*=10;
			reverse+=temp%10;
			temp=(int)temp/10;
		}
		return(reverse);		
	}
	
}
