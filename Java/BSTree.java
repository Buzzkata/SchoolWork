import java.math.*;

public class BSTree{
	class Node{
		int key;
		Node left,right;
	
		public Node(int k){
			key = k;
			left = null;
			right = null;
		}
	}
	
	Node root;
	
	public BSTree(){
		root = null;
	}
	
	public Node insertRec(Node root, int key){
		if(root == null){
			root = new Node(key);
			return root;
		}
		
		if(key<root.key){
			root.left = insertRec(root.left, key);
		}
		else if(key > root.key){
			root.right = insertRec(root.right, key);
		}
		
		return root;
		
	}
	
	void insertNode(int key){
		root = insertRec(root,key);
	}
	public int treeSearch(Node root, int k){
		Node current = root;
		int count = 0;
		while(current !=null){
			if(current.key==k){
				return count;
			}
			else if(current.key>k){
				count++;
				current = current.left;
			}
			else{
				count++;
				current = current.right;
			}
			
		}
		return count;
		
		
	}
	
	public int arrSearch(int arr[],int k){
		int count = 0;
		for(int i = 0;i < arr.length;i++){
			if(arr[i] == k){
				return count;
			}
			else{
				count++;
			}
			
		}
		return count;
	}
	
	public int treeHeight(Node node){
		if(node == null){
			return 0;
		}
		else{
			return 1 + Math.max(treeHeight(node.left),treeHeight(node.right));
		}
	}
	
	
}