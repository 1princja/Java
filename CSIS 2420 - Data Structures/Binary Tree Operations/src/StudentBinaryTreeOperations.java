
public class StudentBinaryTreeOperations {

	public void run(){
		Student s1 = new Student(1, "fName1", "lName1", "maj1", .1);
		Student s2 = new Student(2, "fName2", "lName2", "maj2", .2);
		Student s3 = new Student(3, "fName3", "lName3", "maj3", .3);
		Student s4 = new Student(4, "fName4", "lName4", "maj4", .4);
		Student s5 = new Student(5, "fName5", "lName5", "maj5", .5);
		Student s6 = new Student(6, "fName6", "lName6", "maj6", .6);
		Student s7 = new Student(7, "fName7", "lName7", "maj7", .7);
		Student s8 = new Student(8, "fName8", "lName8", "maj8", .8);
		Student s9 = new Student(9, "fName9", "lName9", "maj9", .9);
		Student s10 = new Student(10, "fName10", "lName10", "maj10", .10);
		Student s11 = new Student(11, "fName11", "lName11", "maj11", .11);
		Student s12 = new Student(12, "fName12", "lName12", "maj12", .12);
//
		LinkedBinaryTree<Student> bTree =  new LinkedBinaryTree<Student>(s1);
		bTree.makeLeftChild(bTree.root(), s2);
		bTree.makeRightChild(bTree.root(), s3);

		bTree.makeLeftChild(bTree.root().leftChild, s4);
		bTree.makeRightChild(bTree.root(), s3);

		
//	
		LinkedBinaryTreeNode node1 = new LinkedBinaryTreeNode(s1);
		LinkedBinaryTreeNode node2 = new LinkedBinaryTreeNode(s2);
		LinkedBinaryTreeNode node3 = new LinkedBinaryTreeNode(s3);
		LinkedBinaryTreeNode node4 = new LinkedBinaryTreeNode(s4);
		LinkedBinaryTreeNode node5 = new LinkedBinaryTreeNode(s5);
		LinkedBinaryTreeNode node6 = new LinkedBinaryTreeNode(s6);
		LinkedBinaryTreeNode node7 = new LinkedBinaryTreeNode(s7);
		LinkedBinaryTreeNode node8 = new LinkedBinaryTreeNode(s8);
		LinkedBinaryTreeNode node9 = new LinkedBinaryTreeNode(s9);
		LinkedBinaryTreeNode node10 = new LinkedBinaryTreeNode(s10);
		LinkedBinaryTreeNode node11 = new LinkedBinaryTreeNode(s11);
		LinkedBinaryTreeNode node12 = new LinkedBinaryTreeNode(s12);
		LinkedBinaryTree tree = new LinkedBinaryTree(node1);
		tree.makeLeftChild(node1, node2);
		tree.makeRightChild(node1, node3);
		tree.makeLeftChild(node2, node4);
		tree.makeRightChild(node2, node5);
		tree.makeLeftChild(node3, node6);
		tree.makeRightChild(node3, node7);
		tree.makeLeftChild(node4, node8);
		tree.makeRightChild(node4, node9);
		tree.makeLeftChild(node5, node10);
		tree.makeRightChild(node5, node11);
		tree.makeLeftChild(node6, node12);
		
	    PrintVisitor visitor = new PrintVisitor();
		tree.inOrderTraversal(visitor);
	}
	
	public StudentBinaryTreeOperations() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StudentBinaryTreeOperations go = new StudentBinaryTreeOperations();
		go.run();
		
	}

}
