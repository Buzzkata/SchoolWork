package question1;

/**
 * An abstract class to describe a basic hero.
 * @author Aaron
 *
 */

public abstract class Hero {
	private String name;
	private int health;
	
	/**
	 * Argumented constructor 
	 * @param name Hero's name.
	 */
	public Hero(String name){
		if(name == "" || name.length() == 0)
			this.name = "anonymous";
		else
			this.name = name;
		
		this.health = 100;
	}
	
	/**
	 * Accessor for health.
	 * @return Hero's current health.
	 */
	public int getHealth() { return health; }
	
	/**
	 * Accessor for Name
	 * @return Hero's name.
	 */
	public String getName() { return name; }
	
	/**
	 * Add to the hero's health.
	 * @param addHealth how much health to add.
	 */
	public void heal(int addHealth){ this.health += addHealth; }
	
	/**
	 * Hero takes damage from enemy.
	 * @param damage how much damage to take.
	 */
	public void takeDamage(int damage){ 
		this.health -= damage;
		if(health <= 0)
			health = 0;
	}
	
	/**
	 * If the hero is dead, return true.
	 * @return true if health <= 0, otherwise false
	 */
	public boolean isDead() { return health <= 0; }
	
	/**
	 * To be defined in subclasses
	 * @return how much damage to deal
	 */
	abstract public int dealDamage();
	
	/**
	 * toString for easy printing.
	 */
	public String toString(){
		return "Hero[" + health + ", " + name + "]";
	}

	
}
