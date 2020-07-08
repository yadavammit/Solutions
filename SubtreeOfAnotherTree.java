import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class SubtreeOfAnotherTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (isSame(s, t)) {
			return true;
		} else {
			return (isSubtree(s.left, t) || isSubtree(s.right, t));
		}

	}

	private boolean isSame(TreeNode s, TreeNode t){
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
	}

}