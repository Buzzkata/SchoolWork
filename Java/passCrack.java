public class passCrack{
	public static void main(String[] args){
		System.out.println(crackPassword("aaba"));
	
	}
	public static boolean equalsTo(String a, String b){
		int len = a.length();
		char[] c1 = a.toCharArray();
		char[] c2 = b.toCharArray();
		
		
		if(a.length() != b.length()){
			return false;
		}
		for(int i = 0;i<len;i++){
			if(c1[i]!=c2[i]){
				return false;
			}
		}
		return true;
	}
	public static String crackPassword(String s){
		String userIn = s;
		int iterations = 0;
		String result = "Match found after: ";
		
		
		String[] arrCharcs = new String[13];
		arrCharcs[0]="a";
		arrCharcs[1]="b";
		arrCharcs[2]="c";
		arrCharcs[3]="d";
		arrCharcs[4]="e";
		arrCharcs[5]="f";
		arrCharcs[6]="g";
		arrCharcs[7]="h";
		arrCharcs[8]="i";
		arrCharcs[9]="j";
		arrCharcs[10]="k";
		arrCharcs[11]="l";
		arrCharcs[12]="m";
		int size = arrCharcs.length;
		String compare,c2,c3,c4,num;
	
		for(int i = 0;i<size;i++){
			compare = arrCharcs[i];
			++iterations;
			for(int j =0;j<size;j++){
				c2=compare + arrCharcs[j];
				++iterations;
				for(int k = 0;k<size;k++){
					c3=c2 + arrCharcs[k];
					++iterations;
					for(int l = 0;l<size;l++){
						c4=c3 + arrCharcs[l];
						++iterations;
						if(c4.equals(userIn)){ //equals
							num = Integer.toString(iterations);
							result+=num;
							return result;
						}
					}
				}
				
			}
		}
		return "Match not found";
		
	}
}