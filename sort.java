import java.util.*;
import java.lang.management.*;


public class sort{

	public static void main(String[] args){

		Scanner inp = new Scanner(System.in);
		System.out.println("Input a");
		double a = inp.nextDouble();
		System.out.println("Input b");
		double b = inp.nextDouble();
		int k; 
		long sum;
		
		/*double[] test = new double[15];

		for(int i=0; i<15; i++){
			test[i]=Math.random()*(b-a)+a;
		}
		System.out.println("Original");
		for (double p : test){
			System.out.println(p);
		}
		System.out.println("");
		
		sort.mergesort(test);
		System.out.println("Sorted");
		for (double p : test){
			System.out.println(p);
		}
		System.out.println("");*/
		double[] set; long startCpuTimeNano, taskCpuTimeNano,startTime, duration;
		for (int n=20000; n<=1000000; n+=20000){
			sum=0;
			k=0;
			while (k<10){
		
				set = new double[n];

				for(int i=0; i<n; i++){
					set[i]=Math.random()*(b-a)+a;
				}
		
				//startTime = System.nanoTime();
				startCpuTimeNano = sort.getCpuTime();
		
				sort.heapsort(set);
		
				taskCpuTimeNano = sort.getCpuTime() - startCpuTimeNano;
				//duration = System.nanoTime() - startTime;

				//System.out.println(taskCpuTimeNano);
				sum+=(taskCpuTimeNano);
				k++;
			}
				System.out.println(sum/10);			
		}
	}
		

	/*public long getCpuTime(long[] ids){
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		if(! bean.isCurrentThreadCpuTimeSupported())
			return 0L; 
		long time = 0L;
		for(int i:ids){
			long t = bean.getThreadCpuTime( ids[i] );
			if ( t != -1)
				time += t;
		}
		return time;
	}*/

	public static long getCpuTime(){
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		return bean.isCurrentThreadCpuTimeSupported() ?
			bean.getCurrentThreadCpuTime() : 0L;
	}

	public static void merge(double[] a, double[] aL, double[] aR){
		int l=0; int r=0; int compare;

		for(int i=0; i<a.length; i++){

			if (aL.length==l){
				a[i]=aR[r];
				r++;
				continue;
			}

			else if(aR.length==r){
				a[i]=aL[l];
				l++;
				continue;
			}

			compare = mergesort.compare(aL[l], aR[r]);
			
			if (compare==-1 || compare==0){
				a[i]=aL[l]; 
				l++;
				continue;
			}

			else if(compare==1){
				a[i]=aR[r];
				r++;
				continue;
			}
		}
		return;
	}

	public static void mergesort(double[] a){
		int n = (int) Math.floor(a.length/2);
		if (a.length==1) return;
		else{
			double[] aL = new double[n];
			double[] aR = new double[a.length-n];
			
			for(int i=0; i<n; i++){
				aL[i]= a[i];
			}

			int j=0;
			for(int i=n; i<a.length; i++){
				aR[j]= a[i];
				j++;
			}

			sort.mergesort(aR);
			sort.mergesort(aL);
			sort.merge(a, aL, aR);

			return;
		}
	}

	public static void selectionsort(double[] set){
		int c; int n=set.length; int m=n; int min=0;
		double temp,comp;

		while(m>1){
			comp=set[n-m];
			for(int i=n-m+1; i<n; i++){
				c = sort.compare(comp,set[i]);
				if(c==1){
					min=i;
					comp=set[i];
				}
			}

			if(comp!=set[n-m]){
			temp=set[n-m];
			set[n-m]=set[min];
			set[min]=temp;
			}
			m--;	
		}
		return;
	}

	public static void bubblesort(double[] set){
		int c; int m=set.length; 
		double temp;
		while(m>1){
			for(int i=0; i<m-1; i++){
				c = sort.compare(set[i],set[i+1]);
				if(c==1){
					temp=set[i];
					set[i]=set[i+1];
					set[i+1]=temp;
				}
			}
			m--;	
		}
		return;
	}

	public static void insertsort(double[] set){
		int c=100; int m=set.length;
		for(int i=1; i<m; i++){
			for(int j=i-1; j>=0; j--){
				c = sort.compare(set[i],set[j]);
				if(c != -1){
					sort.insert(set, i, j+1);
					break;
				}
			}
			if(c ==-1) sort.insert(set, i, 0);
		}
	}

	public static void insert(double[] set, int from, int to){
		double temp, temp2;
		temp=set[to];
		set[to]=set[from];

		for (int i=to+1; i<=from; i++){
			temp2 = set[i];
			set[i] = temp;
			temp = temp2;
		}
		return;
	}

	public static void heapifyparent(double[] heap, int i){
		double temp;
		int parent = (int) Math.ceil(i/2.0)-1;
		int c = sort.compare(heap[i],heap[parent]);
		if(c==-1 || c==0){
			temp = heap[i];
			heap[i]=heap[parent];
			heap[parent]=temp;
			if(parent!=0){
				sort.heapifyparent(heap,parent);
			}
		}
		return;	
	}

	public static double[] iniheapify(double[] set){
		
		double[] heap = new double[set.length];
		heap[0]=set[0];
		for(int i=1; i<set.length; i++){
			heap[i]=set[i];
			sort.heapifyparent(heap,i);
		}
		return(heap);
	}

	public static void heapify(double[] set, int node){

		int left=2*node+1; int right=left+1;
		int lastnode = (int) Math.floor(set.length/2);
		double temp; int c;

		if(node<=lastnode && right<set.length){

			 c =  sort.compare(set[left], set[right]);

			if(c==-1 || c==0){
					c = sort.compare(set[node],set[left]);
					if(c==1){
						temp=set[node];
						set[node]=set[left];
						set[left]=temp;
						sort.heapify(set,left);
					}
			}
		
			else{
				c = sort.compare(set[node],set[right]);
				if (c==1){
					temp=set[node];
					set[node]=set[right];
					set[right]=temp;
					sort.heapify(set,right);
				}
			}
		}

		else if(left<set.length){
			c = sort.compare(set[node],set[left]);
				if(c==1){
					temp=set[node];
					set[node]=set[left];
					set[left]=temp;
					sort.heapify(set,left);
				}
		}
		
		else if(right<set.length){
			c = sort.compare(set[node],set[right]);
			if (c==1){
				temp=set[node];
				set[node]=set[right];
				set[right]=temp;
				sort.heapify(set,right);
			}			
		}
		return;		
	}
	
	public static void quicksort(double[] set, int start, int end){
		if (start<end){
			int pivot = end;
			int cp = sort.partition(set,pivot,start,end);
			if(cp==0) sort.quicksort(set, cp+1, end);
			if(cp==set.length-1) sort.quicksort(set, start, cp-1);
			else{
				sort.quicksort(set, start, cp-1);
				sort.quicksort(set, cp+1, end);
			}	
		}
		return;
	}	
	
	public static void quicksort(double[] set){
		sort.quicksort(set, 0, set.length-1);
		return;
	}
	
	public static int partition(double[] set, int pivot, int start, int end){
		double temp;
		int i=0; int c;
		temp=set[end];
		set[end]=set[pivot];
		set[pivot]= temp;
		
		for(int n=0; n<end; n++){
			c = sort.compare(set[n], set[end]);
			if(c==-1 || c==0){
				temp = set[n];
				set[n] = set[i];
				set[i] = temp;
				i++;
			}
		}
		
		temp = set[end];
		set[end] = set[i];
		set[i] = temp;
		
		return(i);
	}
	
	public static int partition123(double[] set, int pivot, int start, int end){
		double temp;
		int small = start;
		int big = end-1;
		int c;
		
		temp=set[end];
		set[end]=set[pivot];
		set[pivot]= temp;
		
		while (big!=small){
			c = sort.compare(set[small], set[end]);
			if (c==1){
				temp=set[small];
				set[small]=set[big];
				set[big]=temp;
				big--;
			} 
			else if(c==-1 || c==0){
				small++;
			}
		}
		
		c = sort.compare(set[small],set[end]);
		if(c==1){
			temp=set[small];
			set[small]=set[end];
			set[end]=temp;
		}
		else if(c==-1 || c==0){
			small++;
			temp=set[small];
			set[small]=set[end];
			set[end]=temp;
		}
		 return(small);
	}
	
	public static double[] heapsort(double[] set){
		set = sort.iniheapify(set);
		double[] sorted = new double[set.length];
		int i=0;
		while(set.length>0){
			sorted[i]=set[0];
			if(set.length==1) break; 
			set[0]=set[set.length-1];
			set = Arrays.copyOfRange(set, 0, set.length-1);
			sort.heapify(set,0);
			i++;
		}	
		return(sorted);
	}
	
	public static int binarysearch(double[]set, double number){
		sort.mergesort(set);
		return(sort.binarysearch(set, number, 0, set.length-1));
	}
	
	public static int binarysearch(double[] set, double number, int from, int to){
		int index, c,median;
		median=0;
		if (from==to){
			median=from;
			c = sort.compare(number, set[median]);
			if(c==0){
				return(median);
			}
			else{return(set.length+100);}
		}
		else if(from==to-1){
			median=from;
			c = sort.compare(number, set[median]);
			if(c==0){
				return(median);
			}
			median=to;
			c = sort.compare(number, set[median]);
			if(c==0){
				return(median);
			}
			return(set.length+1);
		}
			
		else if(from<to-1){	
			median =  (int)	Math.floor(((from+to)/2.0));
			c = sort.compare(number, set[median]);
			if(c==1) return(sort.binarysearch(set, number, median+1, to));
			else if(c==-1){
				return(sort.binarysearch(set, number, from, median-1));}
			else if (c==0){
			return(median);
			}
		}
		return(set.length+100);
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