package s30Coding;

//Time Complexity :- O(n) where n is the total number node in the binary tree
//Space Complexity :- O(h) where h is the height of the tree
//LeetCode :- yes

public class FlattenBinaryTreeToLinkedList {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            return;
        }
    
        if(root.left != null){
            flatten(root.left);
            
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            
            while(root.right != null){
                root = root.right;
            }
            root.right = temp;
        }
    flatten(root.right);
}
}
