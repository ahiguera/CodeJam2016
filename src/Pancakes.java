import java.io.File;
import java.io.PrintWriter;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;

public class Pancakes {

	
	public static void main(String[] args) {
		Pancakes pk = new Pancakes();
		String fileLine="";
		
		
		try (Scanner sc = new Scanner(new File("B-large-practice.in"));
			 PrintWriter printer = new PrintWriter(new File("Output.txt"))){
			fileLine = sc.nextLine();
			int numberTestCases = Integer.parseInt(fileLine);
			for (int i=1; i<=numberTestCases;i++){
				fileLine = sc.nextLine();
				int count = pk.countFlips(fileLine);
				printer.println("Case #" + i + ": " + count);
			}
			sc.close();
	    }
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	

	
	
	public int countFlips(String stack){
		int numflips=0;
		
		char[] ch = stack.toCharArray();
		
		for (int i = 0; i < ch.length-1; i++) {
			if (ch[i]!=ch[i+1]){
				numflips++;
			}
		}
		if (ch[ch.length-1]== '-'){
			numflips++;
		}
			
		
		return numflips;
	}
	
}
