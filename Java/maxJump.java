
public class maxJump{
	public static void main(String [] args){
		int[] arr = {2,1,1,2,0,1,3,1,2,5};
		System.out.println(maxJ(arr));
		
	}
	public static boolean maxJ(int[] in){
		
		int n = in.length-1;
		int newnum;
		int j = in[0];
		while(j<n){
			newnum = in[j];
			j+=newnum;
			if(j==n){
				
				return true;
			}
			if(newnum == 0 || j==0){
				
				return false;
			}
			
			if(j>n){ //or ++j>n, since it doesnt count first slot in arr
				
				return false;
			}
			
			
			
			
		}
		return false;
	}
}