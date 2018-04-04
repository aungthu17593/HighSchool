import java.util.*;

public class testsudoku{

public static void main(String[]args)
{
  Scanner inp= new Scanner(System.in);
  System.out.println("Enter the size of sudoku square");
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

		boolean[][] flag= sudoku.flag(sudo);
		boolean test= sudoku.test(sudo,1,2,1);
		System.out.println(test);

		int boxsize = (int)Math.sqrt(sudo.length);
		int boxr = (int) Math.floor(1/boxsize)+1;
		int boxc = (int) Math.floor(2/boxsize)+1;

		System.out.println(boxr);
		System.out.println(boxc);
		System.out.println("yes");


}
}