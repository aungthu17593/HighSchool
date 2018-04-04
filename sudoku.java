import java.util.*;

public class sudoku{

	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter the size of n x n sudoku square");
		int n= inp.nextInt();
		if (Math.sqrt(n)%1!=0) System.out.println("Not a valid size for sudoku, restart and retry again.");

		int[][] sudo = new int[n][n];

		System.out.println("Input the sudoku from left to right, up to down, use 0 for blanks");

		for(int i=0; i<n ; i++){
			for (int j=0; j<n ; j++){
				sudo[i][j]=inp.nextInt();
				}
			}

		System.out.println("Original sudoku");

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(sudo[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		boolean solved = solve(sudo);
		
		if(solved){
			System.out.println("Solution");

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					System.out.print(sudo[i][j]+" ");
				}
				System.out.println("");
			}	
		}
		else{System.out.println("No Solution");}
		return;
	}
	
	public static boolean[] possible_digits(int[][] sudo, int row, int column){
		boolean digits[] = new boolean [sudo.length+1];
		for(int i=0; i<sudo.length; i++){
			digits[sudo[row][i]]=true;
			digits[sudo[i][column]]=true;
		}
		int boxsize = (int)Math.sqrt(sudo.length);
		int boxr = boxsize * (int)(row/boxsize);
		int boxc = boxsize * (int)(column/boxsize);
		
		for(int i=0; i<boxsize; i++){
			for(int j=0; j<boxsize; j++){
				digits[sudo[boxr+i][boxc+j]]=true;
			}
		}
		return(digits);
	}
	
	public static boolean solve(int[][] sudo){
			
		int row=0; int column= 0;
		boolean blank=false;
		
		for(row=0; row<sudo.length; row++){
			for(column=0; column<sudo.length; column++){
				if(sudo[row][column]==0){
					blank=true;
					break;
				}
			}
			if(blank) break;
		}
		
		if(!blank) return true;
		
		boolean[] digits = possible_digits(sudo, row, column);
		
		for(int i=0; i<sudo.length+1; i++){
			if(!digits[i]){
				sudo[row][column]=i;
				if(solve(sudo)) return true;
				sudo[row][column]=0;
			}
		}
		
		return false;
		
	}
	
}