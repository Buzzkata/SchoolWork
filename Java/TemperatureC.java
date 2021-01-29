

public class TemperatureC{
	private double setC;
	TemperatureC(double setC){
		this.setC = setC;
		if(setC < -273.15){
			setC = -273.15;
		}
		
	}
	public void setC(double setC){
		this.setC = setC;
		if(setC < -273.15){
			setC = -273.15;
		}
	}
	public double getC(){
		return setC;
	}
	public double getF(){
		return ((setC * 1.8)+32);
	}
	public double getK(){
		return (setC + 273.15);
		
	}

}