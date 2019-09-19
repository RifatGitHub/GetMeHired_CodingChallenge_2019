/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_isValidBST {
  public boolean isValid_recurse(TreeNode node, Integer lower, Integer upper) {
    if (node == null) 
	return true;

    int val = node.val;

    if (lower != null && val <= lower) 
	return false;

    if (upper != null && val >= upper) 
	return false;

    if (! isValid_recurse(node.right, val, upper)) 
	return false;

    if (! isValid_recurse(node.left, lower, val)) 
	return false;

    return true;
  }

  public boolean isValidBST(TreeNode root) {
    return isValid_recurse(root, null, null);
  }
}

/*

Sample input:

    5
1       6
       2        7
             8      9

1st call:
5,null,null
val = 5
isValid_recurse(6, 5, null)

1st recursion:
6,5,null
val = 6
isValid_recurse(7, 6, null)

2nd recursion:
7,6,null
val = 7
isValid_recurse(9, 7, null)

3rd recursion:
9,7,null
val = 9
isValid_recurse(null, 9, null) = true
return true

2nd recursion:
7,6,null
val = 7
isValid_recurse(8, null, 7)

3rd recursion:
8,null,7
val = 8
return false

...
...

1st call:
return false

*/
