//Bozhidar Stoyanov, 0353616
//Magician hero
package question1;
public class Magician extends Hero{
	private int mana;
	
	public Magician(){
		super("Magician");
		mana = 4;
	}
	
	
	public int dealDamage(){
		return 4 + (int)(Math.random()* 3);
	}
	
	public int lightning(){
		mana--;
		return (dealDamage()*4);
		
	}
	public int getMana(){
		return mana;
	}
	public void addMana(int addm){
		mana += addm;
	}
	
	public String toString(){
		return "mana - " + mana;
	}

}
