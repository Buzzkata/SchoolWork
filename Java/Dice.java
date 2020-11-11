
public class Dice {
	private int sideUp;
	private int numSides;
	
	public Dice(int numSides){
		if(numSides < 4 || numSides >100)
			throw new IllegalArgumentException("Invalid number of sides.");
		this.numSides = numSides;
		roll();
			
	}
	public Dice(){
		this(6);
	}
	public int getNumSides(){
		return numSides;
	}
	public int getSideUp(){
		return sideUp;
	}
	public void roll(){
		sideUp = (int)(Math.random()*numSides)+1;
	}

}
