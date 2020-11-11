//Bozhidar Stoyanov, 0353616
//Fighter hero
package question1;
public class Fighter extends Hero{
	private int strength;
	
	public Fighter(){
		super("Fighter");
		strength = 3;
	}
	public int dealDamage(){
		return 7 + (int)(Math.random()*4);
	}
	public int berserk(){
		if(strength >0){
			int x = (int)getHealth()/3;
			int y = (int)getHealth()/4;
			this.takeDamage(y);
			strength--;
			return x;
		}
		else{
			
			return 7 + (int)(Math.random()*4);
		}
		
	}
	public int getStrength(){
		return strength;
	}
	public void addStrength(int adds){
		strength += adds;
	}
	public String toString(){
		return "strength - " + strength;
	}
	
	
}
