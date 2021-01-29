import java.util.Scanner;

public class Question1 {

	
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a value for radius:");
		double in = input.nextDouble();
		System.out.println("Enter a value for height:");
		double in2 = input.nextDouble();
		System.out.println("Sphere Volume: " + sphereVolume(in));
		System.out.println("Sphere Surface Area: " + sphereSurface(in));
		System.out.println("Cone Volume: " + coneVolume(in,in2));
		System.out.println("Cone Surface Area: " + coneSurface(in,in2));
	}
	public static double sphereVolume(double r){
	double num = (4.0/3.0)*Math.PI*Math.pow(r,3);
	return num;
		
	
	}
	public static double sphereSurface(double r){
	double sur = 4*Math.PI*Math.pow(r,2);
	return sur;
	}
	
	public static double coneVolume(double r, double h){
	double cone = Math.PI*Math.pow(r,2)*(h/3);
	return cone;
	}
	public static double coneSurface(double r, double h){
	double surface = (Math.PI*r)*(r+Math.sqrt(Math.pow(h,2)+Math.pow(r,2)));
	return surface;
	}
	
	
}