import java.io.File;
import java.io.PrintWriter;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.time.chrono.MinguoChronology;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JamCoin {

	
	public static void main(String[] args) {
		JamCoin pk = new JamCoin();
		String fileLine="";
		
		
		try (Scanner sc = new Scanner(new File("C-small-practice.in"));
			 PrintWriter printer = new PrintWriter(new File("Output.txt"))){
			fileLine = sc.nextLine();
			int numberTestCases = Integer.parseInt(fileLine);
			for (int i=1; i<=numberTestCases;i++){
				fileLine = sc.nextLine();
				StringTokenizer st = new StringTokenizer(fileLine);
				String n = st.nextToken();
				String j = st.nextToken();
				Map result = pk.produceJamCoins(Integer.parseInt(j), Integer.parseInt(n));
				printer.println("Case #" + i + ":");
				for (Iterator iterator = result.keySet().iterator(); iterator.hasNext();) {
					String key = (String) iterator.next();
					printer.print(key + " ");
					long[] dividers = (long[]) result.get(key);
					for (int k = 2; k < dividers.length; k++) {
						if (k == dividers.length-1){
							printer.println(dividers[k]);
						}
						else {
							printer.print(dividers[k] + " ");
						}
					}
				}
			}
			sc.close();
	    }
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/*
 public static void main(String[] args) {
	JamCoin jc = new JamCoin();
	jc.produceJamCoins(7, 6);
}
*/
	private boolean isPrime(long number){
		System.out.println("inidia detrminad si es primo " + number);
		boolean result = true;
		
		if (number%2 == 0){
			return false;
		}
		for (long i=3; i<Math.sqrt(number)+1 ; i+=2){
			if (number%i == 0){
				result = false;
				break;
			}
		}
		System.out.println("finaliza detrminad si es primo");
		return result;
	}
	
	private long[] getInterpretations(String bits){
		
		long[] interpretations = new long[11];
		for (int i=2;i<=10;i++){
			interpretations[i]=Long.parseLong(bits, i);
		}
		return interpretations;
	}
	
	
	private long[]  getNonTrivialDivisor(long[] interpretations){
		System.out.println("Busca divisor no trivial");
		long[] result = new long[11];
		
		for (int i = 2; i < interpretations.length; i++) {
			for (int j=2; j<=interpretations[i]/2; j++) {
				if (interpretations[i]%j ==0){
					result[i]=j;
					break;
				}
			}
		}
		System.out.println("Finaliza divisor no trivial");
		return result;
	}
	
	private String buildFirstNumber(int n){
		String firstNumber = "1";
		for(int i=1;i<n-1;i++){
			firstNumber += "0";
		}
		firstNumber+=1;
		return firstNumber;
	}
	
	
	private Map<String,int[]> produceJamCoins(int j, int n){
		
		HashMap result = new HashMap<String,int[]>();
		int jamCoinsProduced = 0;
		boolean isJamCoin=true;
		String fistNumber = buildFirstNumber(n);
		long decimal = Integer.parseInt(fistNumber,2);
		while (jamCoinsProduced<j){
			isJamCoin=true;
			long interpretations[] = getInterpretations(Long.toString(decimal,2));

		
			for (int i = 2; i < interpretations.length; i++) {
				if (isPrime(interpretations[i])){
					isJamCoin=false;
					break;
				}
				
			}
			System.out.println(Long.toString(decimal,2) + " " + isJamCoin) ;
			
			if (isJamCoin){
				long[] divisors = getNonTrivialDivisor(interpretations);
				jamCoinsProduced++;
				//System.out.println("Numero:" + Integer.toString(decimal,2)  + "Divisores: " + divisors);
				result.put(Long.toString(decimal,2), divisors);
			}
			
			decimal+=2;
			
		}
		return result;
		
		
	}
}
