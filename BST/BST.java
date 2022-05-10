package assessedExercise2;

public class BST {
	protected BSTNode root;
	protected int height;
	
	/*
	 * Constructor
	 */
	public BST() {
		this.root = null;
		this.height = 0;
	}
	
	/*
	 * Operation to get the height of the tree.
	 * 
	 * @returns the height of the tree.
	 */
	public int setSize() {
		return this.height;
	}
	
	/*
	 * Operation to check whether the tree is empty or not.
	 * 
	 * @returns A boolean value with respect to whether the tree is empty or not.
	 */
	public boolean setEmpty() {
		return root == null;
	}
	
	/*
	 * Operation to insert an element into the BST. The element is 
	 * inserted if and only if the number is not in the set.
	 * 
	 * @param val - The values to be added to the set.
	 */
	public void add(int val) {
		if(this.isElement(val)!=null) {
			return;
		}
		BSTNode insNode = new BSTNode(val);
		BSTNode y = new BSTNode();
		y = null;
		BSTNode x = root;
		while(x != null) {
			y = x;
			if(insNode.key < x.key) {
				x = x.leftChild;
			}
			else {
				x = x.rigthChild;
			}
		}
		insNode.parent = y;
		if(y == null) {
			this.root = insNode;
			this.height++;
		}
		else if(insNode.key < y.key) {
			y.leftChild = insNode;
			this.height++;
		}
		else {
			y.rigthChild = insNode;
			this.height++;
		}
	}
	
	/*
	 * This method is a helper method used to remove a node from the tree 
	 * and is used in the remove method.
	 * 
	 * @param u - It is the U is the node being removed
	 * @param v - It is the node which takes u's place.
	 */
	public void transplant(BSTNode u, BSTNode v) {
		if(u.parent == null) {
			this.root = v;
		}
		else if(u == u.parent.leftChild) {
			u.parent.leftChild = v;
		}
		else {
			u.parent.rigthChild = v;
		}
		if(v != null) {
			v.parent = u.parent;
		}
	}
	
	/* 
	 * Operation to find the minimum value of the tree.
	 * 
	 * @param tree - The tree to find the minimum value of.
	 * 
	 * @returns A BSTNode which is the pointer to that number.
	 */
	public BSTNode minimum(BSTNode tree) {
		BSTNode min = tree;
		while(min != null) {
			min = min.leftChild;
		}
		return min;
	}
	
	/* 
	 * Operation to search for a value in the tree.
	 * 
	 *  @param val - The tree is searched for this number.
	 *  
	 *  @returns A BSTNode object which is a pointer to the number.
	 */
	public BSTNode isElement(int val) {
		BSTNode sNode = root;
		while(sNode != null && val != sNode.key) {
			if(val < sNode.key) {
				sNode = sNode.leftChild;
			}
			else {
				sNode = sNode.rigthChild;
			}
		}
		return sNode;
	}
	
	/*
	 * A method used to remove a specified number from the set.
	 * 
	 * @param val - The value to be removed from the set.
	 */
	public void remove(int val) {
		try {
		BSTNode remNode = this.isElement(val);
		if(remNode==null) {
			System.out.println("The number is not in the list!");
			return;
		}
		if(remNode.leftChild == null) {
			this.transplant(remNode, remNode.rigthChild);
		}
		else if(remNode.rigthChild == null) {
			this.transplant(remNode, remNode.leftChild);
		}
		else {
			BSTNode y = minimum(remNode.rigthChild);
			if(y.parent != remNode) {
				this.transplant(y, y.rigthChild);
				y.rigthChild = remNode.rigthChild;
				y.rigthChild.parent = y;
			}
			this.transplant(remNode, y);
			y.leftChild = remNode.leftChild;
			y.leftChild.parent = y;
			height--;
		}}
		catch(Exception ex) {
			
		}
	}
	
	/*
	 * Method used to print all the values of the tree in order.
	 * 
	 * @param root - It is the node from which the printing should start.
	 */
	public void inorderPrint(BSTNode root) {
		if(root != null) {
			inorderPrint(root.leftChild);
			System.out.print(root.key+" ");
			inorderPrint(root.rigthChild);
		}
	}
	
	/*
	 * Finds the difference between the two tree, this and Stree. The difference is 
	 * performed as this object - Stree object.
	 * 
	 *  @param Stree - The tree with which the difference is being taken.
	 *  @param Atree - A new tree which is going to contain the difference.
	 *  @param a - A node used to traverse down the tree.
	 */
	public void diff(BST Stree, BST Atree, BSTNode a) {
		if(a != null) {
			this.diff(Stree, Atree, a.leftChild);
			if(Stree.isElement(a.key)==null) {
				Atree.add(a.key);
			}
			this.diff(Stree, Atree, a.rigthChild);
		}
	}
	
	/*
	 * Method used to find the difference of this object from BST T.
	 * 
	 * @param T - The tree with which the difference is taken
	 * 
	 * @returns A BST which contains the difference of the two trees.
	 */
	public BST difference(BST T) {
		BST newTree = new BST();
		this.diff(T, newTree, root);
		return newTree;
	}
	
	/*
	 * This helper method is used to find the common numbers between the two trees 
	 * and add them to the new tree which is passed in as a parameter.
	 * 
	 * @param Stree - Is the tree which is used for the intersection.
	 * @param Atree - Atree is the new rtee which contains the common values between the two sets.
	 */
	public void common(BST Stree, BST Atree, BSTNode a) {
		if(a != null) {
			this.common(Stree,Atree, a.leftChild);
			if(Stree.isElement(a.key)!=null) {
				Atree.add(a.key);
			}
			this.common(Stree,Atree, a.rigthChild);
		}
	}
	
	/*
	 * The method is used to find the common numbers between to the two BST trees.
	 * 
	 *  @param T - The tree with which we are going to perform intersection.
	 *  
	 *  @returns A BST containing all the common values of the two trees.
	 */
	public BST intersection(BST T) {
		BST newTree = new BST();
		this.common(T, newTree, root);
		return newTree;
	}
	
	/*
	 * Adds every element of this BST to the BST T that has been passed as the parameter.
	 * 
	 * @param tree - It is the tree to which we add all the values
	 * @param a - It is used to traverse down the tree.
	 */
	public void insert(BST tree,BSTNode a) {
		if(a != null) {
			this.insert(tree, a.leftChild);
			tree.add(a.key);
			this.insert(tree, a.rigthChild);
		}
	}
	
	/*
	 * By using the insert method T has become the new union set and is therefore returned.
	 * 
	 *  @param T - It is the tree with which we find the union of this BST.
	 *  
	 *  @returns A BST which contains the union of the two trees.
	 */
	public BST union(BST T) {
		this.insert(T, root);
		return T;
	}
	
	/*
	 * Helper method to check and increment a counter variable that accounts for the number of common numbers.
	 * 
	 *  @param tree - It is the tree which is checked to have a subset.
	 *  @param a - It is the node used to traverse down the tree.
	 *  @param common - Maintains the count of the common numbers between the two trees.
	 *  
	 *  @returns The number of common terms in the two trees
	 */
	public int check(BST tree,BSTNode a, int counter) {
		if(a != null) {
			counter = this.check(tree, a.leftChild, counter);
			if(tree.isElement(a.key)!=null) {
				counter++;
			}
			counter = this.check(tree, a.rigthChild, counter);
		}
		return counter;
	}
	
	/*
	 * Gets the number from this object that are in the BST T and returns whether this is a subset of the T or not.
	 * 
	 * @param T - Check whether this object is a subset of the BST T.
	 * 
	 * @returns A boolean a value with respect to whether this is a subset of T.
	 */
	public boolean subset(BST T) {
		int y =0;
		int counter = this.check(T, root, y);
		return counter==height;
	}
	
	public int getHeight(BSTNode node) {
		if(node==null) {
			return 0;
		}
		if(node.leftChild==null && node.rigthChild==null) {
			return 0;
		}
		return max(this.getHeight(node.leftChild), this.getHeight(node.rigthChild))+1;
	}
	
	public static int max(int a, int b) {
		if(a>b) {
			return a;
		}
		else {
			return b;
		}
	}
	
	public static void main(String[] arg) {
		BST a = new BST();
		a.add(1);
		a.add(3);
		a.add(11);
		a.add(15);
		//a.inorderPrint(a.root);
		BST b = new BST();
		b.add(1);
		b.add(2);
		b.add(3);
		b.add(14);
		b.add(11);
		b.inorderPrint(b.root);
		System.out.println(a.subset(b));
		//b.inorderPrint(b.root);
//		BST c = ;
//		c.inorderPrint(c.root);
		//System.out.println(a.subset(b));
	}
}
