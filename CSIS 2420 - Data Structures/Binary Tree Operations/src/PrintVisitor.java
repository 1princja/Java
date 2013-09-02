

public class PrintVisitor<E> implements Visitor{

	@Override
	protected void visit(BinaryTreeNode<E> node) {
		Student s = (Student) node.element();
		System.out.println(s);
	}

}
