package question1;

import java.util.Random;
//Bozhidar Stoyanov, 0353616
//Hero tester
public class HeroTester {
	public static void main(String[] args){
		Hero[] heros = new Hero[3];
		Hero hero1 = new Healer();
		Hero hero2 = new Magician();
		Hero hero3 = new Fighter();
		heros[0]=hero1;
		heros[1]=hero2;
		heros[2]=hero3;
		
		
		
		
		Goblin goblin1 = new Goblin();
		Goblin goblin2 = new Goblin();
		Goblin goblin3 = new Goblin();
		
		Goblin[] goblins = new Goblin[3];
		goblins[0] = goblin1;
		goblins[1] = goblin2;
		goblins[2] = goblin3;
		
		while((!goblin1.isDead() && !goblin2.isDead() && !goblin3.isDead()) || (!hero2.isDead() && !hero1.isDead() && !hero3.isDead())){
			//the winner is ..
			
			
			
			Random r = new Random();
			int prob = r.nextInt(100);
			if(!goblins[0].isDead()){
				
				if(prob<40){
					goblin1.takeDamage(((Magician)hero2).lightning());
				}
				else{
					goblin1.takeDamage(hero2.dealDamage());
				}
			}
			else if(!goblins[1].isDead()){
				Random r2 = new Random();
				int prob2 = r2.nextInt(100);
				if(prob2<40){
					goblin2.takeDamage(((Magician)hero2).lightning());
				}
				else{
					goblin2.takeDamage(hero2.dealDamage());
				}
				
			}
			else{
				Random r2 = new Random();
				int prob2 = r2.nextInt(100);
				if(prob2<40){
					goblin3.takeDamage(((Magician)hero2).lightning());
				}
				else{
					goblin3.takeDamage(hero2.dealDamage());
				}
				
			}
			
			if(!goblins[0].isDead()){
				Random t = new Random();
				int p = t.nextInt(100);
				if(p<40){
					goblin1.takeDamage(((Fighter)hero3).berserk());
				}
				else{
					goblin1.takeDamage(hero3.dealDamage());
				}
			}
			else if(!goblins[1].isDead()){
				Random t = new Random();
				int p = t.nextInt(100);
				if(p<40){
					goblin2.takeDamage(((Fighter)hero3).berserk());
				}
				else{
					goblin2.takeDamage(hero3.dealDamage());
				}
				
			}
			else{
				Random t = new Random();
				int p = t.nextInt(100);
				if(p<40){
					goblin3.takeDamage(((Fighter)hero3).berserk());
				}
				else{
					goblin3.takeDamage(hero3.dealDamage());
				}
			}
	
			if(!goblins[0].isDead()){
				Random e = new Random();
				int s = e.nextInt(100);
				if(s<40){
					goblin1.takeDamage(hero1.dealDamage()); //should be healing
				}
				else{
					goblin1.takeDamage(hero1.dealDamage());
				}
			}
			else if(!goblins[1].isDead()){
				Random e = new Random();
				int s = e.nextInt(100);
				if(s<40){
					goblin2.takeDamage(hero1.dealDamage());
				}
				else{
					goblin2.takeDamage(hero1.dealDamage());
				}
			}
			else{
				Random e = new Random();
				int s = e.nextInt(100);
				if(s<40){
					goblin3.takeDamage(hero1.dealDamage());
				}
				else{
					goblin3.takeDamage(hero1.dealDamage());
				}
			}
	
			
			hero1.takeDamage(goblin1.dealDamage());
			hero3.takeDamage(goblin2.dealDamage());
			hero2.takeDamage(goblin3.dealDamage());
			System.out.println(hero2.getName() + ", health- " + hero2.getHealth() + hero2);
			System.out.println(goblin1);
			
		}
		if(goblin1.isDead()){
			System.out.println("Hero won");
		}
		else{
			System.out.println("Goblin won");
		}
		
	}
}
