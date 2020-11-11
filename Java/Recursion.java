//Bozhidar Stoyanov, 0353616
//This program has 3 methods which solve the problems by calling the
//methods inside themselves. This illustrates the concept of recursion.
public class Recursion {
	public static int exponential(int base, int exp){
		if(exp == 0){
			return 1;
		}
		else if(exp == 1){
			return base;
		}
		else{
			return (base*(exponential(base, exp - 1))); // base * the exponential method again with exp - 1
			
		}
	
	}
	public static String reverseString(String str){
		if((str == null) || (str.length() <= 1)){
			return str;
		} 
		return reverseString(str.substring(1)) + str.charAt(0);
		
	}
	public static int numDigits(int n){
		if(n > -10 && n < 10){
			return 1;
		}
		else{
			return numDigits(n/10) + 1; 
		}
	}
	
	public static void main(String[] args){
		System.out.println(exponential(3,3));
		System.out.println(reverseString("Hello"));
		System.out.println(numDigits(10356));
	}

}
