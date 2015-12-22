package codility.tools;

import codility.Tree;

public class TreeBuilder {

	public static Tree t(int x, Tree l, Tree r) {
		Tree tree = new Tree();
		tree.l = l;
		tree.r = r;
		tree.x = x;
		return tree;
	}

	public static Tree t(int x) {
		return t(x, null, null);
	}
	
}
