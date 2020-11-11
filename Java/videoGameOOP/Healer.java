//Bozhidar Stoyanov, 0353616
//Healer hero
package question1;
public class Healer extends Hero{
	private int dexterity;
	
	public Healer(){
		super("Healer");
		dexterity = 4;
		
	}
	
	public int heal(){
		return 5 + (int)(Math.random()*6);
	}
	public int dealDamage(){
		return 3 + (int)(Math.random()*3);
	}
	public int getDexterity(){
		return dexterity;
	}
	public void addDexterity(int addDex){
		dexterity += addDex;
	}
	public String toString(){
		return "dexterity - " + dexterity;
	}
	
	
}
