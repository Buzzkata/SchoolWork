//Bozhidar Stoyanov, 0353616
//String tools tester program: The program tests the methods in the StringTools method

public class StringToolsTester{
	public static void main(String[] args){
		StringTools st1 = new StringTools();
		System.out.println(st1.reverse("Darko"));
		System.out.println(st1.binaryToDecimal("1111112"));
		System.out.println(st1.initials("dameS FEnrychaolliASi gand hoi"));
		System.out.println(st1.mostFrequent("helloo"));
		System.out.println(st1.replaceSubString("the dog was going wild in the house", "the", "that"));
	}

}