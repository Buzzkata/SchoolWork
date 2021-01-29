import java.util.Arrays;

public class StringTools{
	public static String reverse(String s){
		char[] inArr = s.toCharArray();
		char temp;
		char temp2;
		int end = inArr.length-1;
		for(int i = 0; i < inArr.length/2;i++){
			temp = inArr[i];
			temp2 = inArr[end];
			inArr[i] = temp2;
			inArr[end] = temp;
			end--;
			
		}
		return new String(inArr);
		
	}
	public static int binaryToDecimal(String s){
		int a = 0;
		int degree = 1;
		int q = s.length()-1;
		for(int f = 0; f < s.length(); f++){
			if(s.charAt(f) == '1' || s.charAt(f) == '0'){
				
				
				a += degree*(s.charAt(q)- '0');
				degree *= 2;
				q--;
				
			}
			else{
				return -1;
				
			}
			
		}
		
		return a;
		
	}
	public static String initials(String s){
		int count = 0;
		for(int n = 0;n < s.length();n++){
			if(s.charAt(n) == ' '){
				count++;
				
				
			}
		}
		if(count == 2){
			s = " " + s; // adding one space to the string. now my spaces are 3.
			String result = "";
			String temp;
			int ifCount = 0;
			for(int i = 0; i < s.length();i++){
				char z = s.charAt(i);
				if(z == ' '){
					 
					if(ifCount < 2){ 
					
						char x = s.charAt(i+1);
						x = Character.toUpperCase(x);
						temp = x + ". ";
						result += x + ". ";
						ifCount++;
						
					
					}
					else{ //Since there are 3 spaces and we want the first two this will execute once ifCount is reached.
						char y = s.charAt(i + 1);
						y = Character.toUpperCase(y);
						String sub = s.substring(i+2, s.length());
						sub = sub.toLowerCase();
						result += y + sub;
						
					}
				}
			}
			
			
			
			return result;
			
			
			
		}
		else{
			return null;
		}
		
	}
	
	public static char mostFrequent(String s){
		int arr[] = new int[s.length()];
		char a;
		int c = 0;
		for(int i = 0; i < s.length();i++){
			a = s.charAt(i);
			c = 1;
			for(int j = i+1;j<s.length();j++){
				if(a == s.charAt(j)){
					c++;
				}
				arr[i] = c;
			}
			
		}
		int max = arr[s.length()-1];
		int pos = s.length();
		for(int k = s.length() - 1;k > 0;k--){
			if(max < arr[k]){
				pos = k;
				max = arr[k];
			}
		}
		
		char result = s.charAt(pos);
		
		return result;
		
	}
	
	public static String replaceSubString(String s1, String s2, String s3){
		if(s1.contains(s2)){
			s1 = s1.replaceAll(s2,s3);
			
		}
		return s1;
		
		
	}
	
	
	

}