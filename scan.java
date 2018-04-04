import java.io.*;
import java.util.*;

public class scan{
	
	public static void main(String[] args) {
		
		try{
			Scanner input = new Scanner(new File("scantext.txt"));
			
			while(input.hasNextLine()){
				String line = input.next();
				System.out.println(line);
			}
			input.close();
		}
		
		catch(FileNotFoundException e) {
			System.exit(0);
		}
	}
	
}