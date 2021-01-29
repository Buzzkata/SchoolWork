import java.util.Random;

public class disjointTester{
	
	static Random rand = new Random();
	
	public static int numGenerator(int min, int max){
		return rand.nextInt(((max-min)+1)+min);
	}
	
	public static void main(String[] args){
		BSTree tree = new BSTree();
		int groupA[] = new int[100];
		int groupB[] = new int[10000];
		
		for(int i = 0;i<100;i++){ //filling up array A and printing it onto screen
			int randNum = numGenerator(1,100);
			groupA[i] = randNum;
			System.out.print(groupA[i] + ", ");
			if((i+1)%10==0){
				System.out.println();
			}
		}
		for(int b = 0;b<10000;b++){ //filling up array B and the binary search tree with random numbers
			int randomN = numGenerator(1,10000);
			groupB[b] = randomN;
			tree.insertNode(groupB[b]); //inserting integers from groupB array into the binary search tree
			if(b<100){ //displaying first 100 values in the tree
				System.out.print(groupB[b] + ", ");
				if((b+1)%10 == 0){
					System.out.println();
				}
			}
		}
		System.out.println();
		
		int height = tree.treeHeight(tree.root); //calculate height of the binary search tree
		System.out.println("height of the binary search tree is: " + height); 
		
		System.out.println();
		
		int comparisons[] = new int[40];
		int totalBST = 0;
		int totalArrComp = 0;
		//unsuccessful searches
		System.out.println("Number     Integer value   BST comparisons   Array comparisons");
		for(int i = 0;i<40;i++){
			comparisons[i] = tree.treeSearch(tree.root, groupA[i]);
			int arrCompare = tree.arrSearch(groupB,groupA[i]);
			totalBST += comparisons[i];
			totalArrComp += arrCompare;
			System.out.println(i+"\t\t" + groupA[i] + "\t\t" + comparisons[i] +"\t\t" + arrCompare);
		}
		
		System.out.println("total BST comparisons: " + totalBST + ", and total arr comparisons: " + totalArrComp);
		System.out.println();
		System.out.println();
		//successfull seaches
		int randArr[] = new int[100];
		for(int i = 0;i<100;i++){
			int randomInt = numGenerator(1,10000);
			randArr[i] = groupB[randomInt];
		}
		
		int totalCompBst = 0;
		int totalArrComp2 = 0;
		
		System.out.println("Number     Integer value   BST comparisons   Array comparisons");
		
		for(int i = 0;i<40;i++){
			int bstComp = tree.treeSearch(tree.root, randArr[i]);
			int arrC = tree.arrSearch(groupB,randArr[i]);
			totalCompBst += bstComp;
			totalArrComp2 += arrC;
			System.out.println(i+"\t\t" + randArr[i] + "\t\t" + bstComp +"\t\t   " + arrC);
		}
		System.out.println("total BST comparisons: " + totalCompBst + ", and total arr comparisons: " + totalArrComp2);
		//missing st deviation, etc
		
	}
}