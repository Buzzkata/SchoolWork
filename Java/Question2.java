//Bozhidar Stoyanov
//question2

public class question2{
	public static void main(String[] args){
		int base = 2;
		int po = 3;
		double c = 5.23415;
		String pas = "String21";
		System.out.println(power(base,po));
		System.out.println(passwordCheck(pas));
		System.out.println(fix(c));
	
	}
	
	public static int power(int a, int r){
		
		int result = a;
		for(int pow = r; pow > 1; pow--){
			result *= a;
		}
		return result;
	}

	public static boolean passwordCheck(String password){
		boolean hasUppercase = !password.equals(password.toUpperCase());
		boolean hasLowercase = !password.equals(password.toLowerCase());
		boolean hasDigit =  password.matches(".*\\d+.*"); //check if there is a digit in the password
		if(password.length() < 8){
			return false;
		}
		else{
			if(hasDigit && hasLowercase && hasUppercase){
				return true;
			}
			return false;
			
		}
	}
	
	
	public static double fix(double r){
		int b = (int)(r);
		double remainder = r - b;
		return remainder;
		
	}
}