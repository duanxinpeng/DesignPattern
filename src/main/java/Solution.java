
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
      int val;
     TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}


public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode intoStack = root;
        while (intoStack!=null || !stack.isEmpty()) {
            while (intoStack!=null) {
                stack.push(intoStack);
                intoStack = intoStack.left;
            }
            TreeNode outStack = stack.pop();
            res.add(outStack.val);
            intoStack = outStack.right;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
