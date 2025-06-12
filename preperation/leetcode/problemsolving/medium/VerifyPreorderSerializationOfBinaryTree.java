package preperation.leetcode.problemsolving.medium;

import java.util.Stack;

/*

    https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree

    One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as '#'.

        For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.
        Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.
        It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.
        You may assume that the input format is always valid.

        For example, it could never contain two consecutive commas, such as "1,,3".
        Note: You are not allowed to reconstruct the tree.

         Example 1:
            Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
            Output: true

        Example 2:
            Input: preorder = "1,#"
            Output: false

        Example 3:
            Input: preorder = "9,#,#,1"
            Output: false

 */
public class VerifyPreorderSerializationOfBinaryTree {

    public static boolean isValidSerialization(String preorder) {
        if (preorder == null) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        String[] splittedPreorderString = preorder.split(",");

         for (int position = 0;  splittedPreorderString.length > position; position++) {
            String current = splittedPreorderString[position];
            while (current.equals("#") && !stack.isEmpty() && stack.peek().equals(current)) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(current);
        }

        return stack.size() == 1 && stack.peek().equals("#");
    }

}
