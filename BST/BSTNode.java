package assessedExercise2;

public class BSTNode {
	protected BSTNode parent;
	protected int key;
	protected BSTNode leftChild;
	protected BSTNode rigthChild;
	
	public BSTNode(int val) {
		this.parent = null;
		this.key = val;
		this.leftChild = null;
		this.rigthChild = null;
	}

	public BSTNode() {
		this.parent = null;
		this.key = 0;
		this.leftChild= null;
		this.rigthChild = null;
	}
	public BSTNode getParent() {
		return parent;
	}

	public int getKey() {
		return key;
	}

	public BSTNode getLeftChild() {
		return leftChild;
	}

	public BSTNode getRigthChild() {
		return rigthChild;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setLeftChild(BSTNode leftChild) {
		this.leftChild = leftChild;
	}

	public void setRigthChild(BSTNode rigthChild) {
		this.rigthChild = rigthChild;
	}
	
	
}
