import java.io.*;
import java.util.*;

public class Translator{
	
	public static void main(String[] args) {
	
		HashMap<String, String> DNAmap = new HashMap<String,String>();
		String strand1="";
		String DNA,pro;
		
		try{
			Scanner input = new Scanner(new File("TheStandardCode.txt"));
	
			while(input.hasNext()){
				DNA = input.next();
				pro = input.next();
				DNAmap.put(DNA, pro);
			}	
			input.close();
		}
		
		catch(FileNotFoundException e){
			System.exit(0);
		}
		
		try{
			Scanner inp= new Scanner(new File("DNAstrand.txt"));
			strand1 = inp.nextLine();
			inp.close();
		}
		
		catch(FileNotFoundException e){
			System.exit(0);
		}
		
		int a = strand1.indexOf("TTG", 0);
		if(a<0) a= 10000000;
		int b = strand1.indexOf("CTG", 0);
		if(b<0) b= 10000000;
		int c = strand1.indexOf("ATG", 0);
		if(c<0) c= 10000000;
		int starti = Math.min(Math.min(a,b),c);
		
		a = strand1.indexOf("TAA", starti);
		if(a<0) a= 10000000;
		b = strand1.indexOf("TAG", starti);
		if(b<0) b= 10000000;
		c = strand1.indexOf("TGA", starti);
		if(c<0) c= 10000000;
		int stopi = Math.min(Math.min(a,b),c)+3;
		
		strand1 = strand1.substring(starti, stopi);
			
		String strand2 = new StringBuilder(strand1).reverse().toString(); 
		strand2 = strand2.replace('T','*').replace('A','T').replace('*','A');
		strand2 = strand2.replace('C','*').replace('G','C').replace('*','G');
		
		String[] protein = new String[6];
		for(int i=0; i<6; i++){
			protein[i]="";
		}
		
		for(int n=0; n<3; n++){
			for(int i=n; i<strand1.length()-3; i+=3){
				protein[n]+= DNAmap.get(strand1.substring(i,i+3))+" ";
			}
		}
		
		for(int n=0; n<3; n++){
			for(int i=n; i<strand2.length()-3; i+=3){
				protein[n+3]+= DNAmap.get(strand2.substring(i,i+3))+" ";
			}
		}
		
		for (String p : protein){
			System.out.println(p);
			System.out.println(" ");
		}
		return;
	}	
}

//start codon TTG, CTG, ATG
//stop codon TAA, TAG, TGA
//int indexOf(string str, int fromIndex)