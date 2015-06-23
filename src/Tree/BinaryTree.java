package Tree;


public class BinaryTree {

	// Node -> key(data)
	//		-> children (left and right child)

	Node root;

	public void add(int data) {
		Node nodeToAdd = new Node(data);

		if(root == null){
			root = nodeToAdd;
			System.out.println("Root " + root.data);
		}

		traverseAndAddNode(root, nodeToAdd);
	}

	public void traverseAndAddNode(Node node, Node nodeToAdd) {

		if(nodeToAdd.data > node.data){
			if(node.rightChild == null){
				node.rightChild = nodeToAdd;
				System.out.println("Right Child" + nodeToAdd.data);
			}
			else{
				traverseAndAddNode(node.rightChild, nodeToAdd);
			}

		}
		else if(nodeToAdd.data < node.data){
			if(node.leftChild == null){
				node.leftChild = nodeToAdd;
				System.out.println("Left Child" + nodeToAdd.data);
			}
			else{
				traverseAndAddNode(node.leftChild, nodeToAdd);
			}
		}

	}

	private boolean delete(int data) {
		// case 1: Node has no children
		// case 2: Node has one child
		// case 3: Node has two children --> Find minimum value in right sub-tree OR maximum in left sub-tree ,copy the value in place of 
		//									 deleted node value and delete duplicate from right subtree 
		
		//case 1:
		
		return false;
	}
	
	public Node find(int val){
		
		if(root != null){
			return findNode(root, val);
		}
		return null;
		
	}
	
	private Node findNode(Node search, int val) {
		
		if(search == null){
			return null;
		}
		if(search.data == val){
			System.out.println();
			System.out.println(search.data);
			return search;
		}
		else if (search.data > val) {
			Node findNode = findNode(search.leftChild, val);
			return findNode;
		}
		else if(search.data < val){
			Node findNode = findNode(search.rightChild, val);
			return findNode;
		}
		
		return null;
	}

	public void traverse(){
		// IN, PRE, POST Order traversal
		System.out.println();
		System.out.print("Inorder Traversal : -> ");
		if(root != null){
			Node nodeToTraverse = root;

			if(nodeToTraverse.leftChild == null && nodeToTraverse.rightChild == null){
				System.out.println("Only Root Element Exist " + nodeToTraverse.data);
			}
			inOrderTraversal(nodeToTraverse);
		}
		else{
			System.out.println("Empty Tree");
		}
	}

	private void inOrderTraversal(Node node) {

		if(node.leftChild != null){
			inOrderTraversal(node.leftChild);
		}
		System.out.print(node.data + " ");
		if(node.rightChild != null){
			inOrderTraversal(node.rightChild);
		}
	}


	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();
		
		binaryTree.add(7);
		binaryTree.add(1);
		binaryTree.add(0);
		binaryTree.add(3);
		binaryTree.add(2);
		binaryTree.add(5);
		binaryTree.add(4);
		binaryTree.add(6);
		binaryTree.add(9);
		binaryTree.add(8);
		
		binaryTree.traverse();
		
		binaryTree.find(9);

	}
}
