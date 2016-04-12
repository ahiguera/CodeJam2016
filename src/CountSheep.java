import java.io.File;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Vector;

public class CountSheep {
    
	
	public static void main(String[] args) {
		CountSheep cs = new CountSheep();
		String fileLine="";
		
		
		try (Scanner sc = new Scanner(new File("input.txt"));
			 PrintWriter printer = new PrintWriter(new File("Output.txt"))){
			fileLine = sc.nextLine();
			int numberTestCases = Integer.parseInt(fileLine);
			for (int i=1; i<=numberTestCases;i++){
				fileLine = sc.nextLine();
				String count = cs.countingSheep(Integer.parseInt(fileLine));
				printer.println("Case #" + i + ": " + count);
			}
			sc.close();
	    }
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public Hashtable<Integer, Integer> getDigits(int number){
		Integer digit;
		Hashtable<Integer, Integer> ht = new Hashtable<>();
		while (number > 0) {
		    digit = Integer.valueOf(( number % 10));
		    number = number / 10;
		    ht.put(digit, digit);
		}
		return ht;
	}
	
	
	public String countingSheep(int pickedNumber){
		if (pickedNumber==0){
			return "INSOMNIA";
		}
		
		int i=0;
		Hashtable<Integer, Integer> ht = new Hashtable<Integer,Integer>();
		boolean keepProcess = true;
		
		while (keepProcess){
			i++;
			ht.putAll(getDigits(pickedNumber*i));
			if (ht.size()==10){
				return String.valueOf(pickedNumber*i) ;
			}
		}
		return null;
    }
}
