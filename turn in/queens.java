import java.util.*;

public class queens{
	
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in);
		System.out.println("Input the value of N for NxN chess board");
		int n = inp.nextInt();
		
		int[][] board = new int[n][n];
		ArrayList<int[][]> solutions = new ArrayList<int[][]>();
		
		reset(board);
		
		allsolutions(solutions, board, 0);
		return;
	}
	
	public static void clean(int[][] board){
		int n= board.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]==-1) board[i][j]=0;
			}
		}
		return;
	}
	
	public static int[][] cleanr(int[][] board){
		int[][] ret = new int[board.length][board.length];
		int n= board.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]==-1) ret[i][j]=0;
				else{ret[i][j]=board[i][j];}
			}
		}
		return ret;
	}
	
	public static void reset(int[][] board, int r, int c){
		int n= board.length;
		for(int i=r; i<n; i++){
			for(int j=c; j<n; j++){
				board[i][j]=0;
			}
		}
		return;
	}
	
	public static void reset(int[][] board){
		reset(board,0,0);
		return;
	}
	
	public static void refresh(int[][] board){
		int n= board.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]==-1){
					board[i][j]=0;
				}	
			}
		}
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(board[i][j]==1){
					eliminate(board, i, j);
				}	
			}
		}
		return;
	}

	public static void eliminate(int[][] board, int r, int c){
		int i; int j;
		for(i=0; i<board.length; i++){
			if(i!=c){
				board[r][i]=-1;
			}
			if(i!=r){
				board[i][c]=-1;
			}
		}
		
		i=r; j=c;
		while(i>=0 && j>=0){
			if(i!=r && j!=c) board[i][j]=-1;
			i--;j--;
		}
		
		i=r; j=c;
		while(i<board.length && j<board.length){
			if(i!=r && j!=c) board[i][j]=-1;
			i++; j++;
		}
		
		i=r; j=c;
		while(i<board.length && j>=0){
			if(i!=r && j!=c) board[i][j]=-1;
			i++; j--;
		}
		
		i=r; j=c;
		while(i>=0 && j<board.length){
			if(i!=r && j!=c) board[i][j]=-1;
			i--; j++;
		}
		
		return;
	}
	
	public static boolean unique(ArrayList<int[][]> solutions, int[][] board){
		
		for(int i=0; i<solutions.size(); i++){
			if(Arrays.deepEquals(solutions.get(i),board)) return false;
		}
		return true;
	}
	
	public static void add(ArrayList<int[][]> solutions, int[][] board){
		solutions.add(board);
		int[][] reB = new int[board.length][board.length];
		reB = reflectH(board);
		solutions.add(reB);
		for(int i=0; i<3 ;i++){
			board=rotateRight(board);
			reB=rotateRight(reB);
			solutions.add(board);
			solutions.add(reB);
		}
		return;
	}
	
	public static boolean allsolutions(ArrayList<int[][]> solutions, int[][] board, int queen){
		int n=board.length;
		
		if(queen==n){
			int[][] cop=new int[n][n];
			cop=cleanr(board);
			if(unique(solutions, cop)){
				System.out.println("");
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						System.out.print(cop[i][j]+" ");
					}
					System.out.println("");
				}
				add(solutions,cop);	
				return false;
			}
			else{
				return false;
			}
		}
		
		for(int i=0; i<n; i++){
			
			if(board[i][queen]==0){
				board[i][queen]=1;
				refresh(board);
				if(allsolutions(solutions,board, queen+1)) return true;
			}
			board[i][queen]=0;
			refresh(board);
		}

		return false;	
	}
	
	public static boolean solve(int[][]board, int queen){
		int n=board.length;
		
		if(queen==n)return true;
		for(int i=0; i<n; i++){
			if(board[i][queen]==0){
				board[i][queen]=1;
				refresh(board);
				if(solve(board, queen+1)) return true;
			}
			board[i][queen]=0;
			refresh(board);
		}
		return false;
	}
	
	public static int[][] rotateRight(int[][] board){
		int[][] ret =  new int[board.length][board.length];
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length; j++){
				ret[i][j]= board[board.length - j - 1][i];
			}
		}
		return ret;
	}
	
	public static int[][] reflectV(int[][] board){
		int[][] ret =  new int[board.length][board.length];
		
		for(int i=0; i<board.length; i++){
			ret[i]=board[board.length-i-1];
		}
		return(ret);
	}
	
	public static int[][] reflectH(int[][] board){
		int[][] ret = new int[board.length][board.length];
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length; j++){
				ret[i][j]=board[i][board.length-j-1];
			}
		}
		return(ret);
	}
}