/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_lowestCommonAncestor {
    private TreeNode lca;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca = root;
        lcaRecurse(root, p, q);
        return lca;
    }

    private boolean lcaRecurse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        boolean left = lcaRecurse(root.left, p, q);
        boolean right = lcaRecurse(root.right, p, q);
        boolean self = ((root == p) || (root == q));
        if ((self && left) || (self && right) || (left && right))
            lca = root;
        return (self || left || right);
    }
}


/* Sample input:

    5
1       6
       2        7
             8      9

How it works:

lowestCommonAncestor function:
input 5 2 9
lca = 5
lcaRecurse(5,2,9)

1st call:
5,2,9
left = lcRecurse(1,2,9)

1st recursion:
1,2,9
left = lcaRecurse(null,2,9) = false
right = lcaRecurse(null,2,9) = false
self = false
return false

1st Call:
5,2,9
left = lcRecurse(1,2,9) = false
right = lcRecurse(6,2,9)

1st recursion:
6,2,9
left = lcaRecurse(2,2,9)

2nd recursion:
2,2,9
left = false
right = false
self = true
return true

1st recursion:
6,2,9
left = true;
right = lcRecurse(7,2,9)

2nd recursion:
7,2,9
left = lcaRecurse(8,2,9)

3rd recursion:
8,2,9
left = false
right = false
self = false
return false

2nd recursion:
7,2,9
left = false
right = lcaRecurse(9,2,9)

3rd recursion:
9,2,9
left = false
right = false
self = true
return true

2nd recursion:
7,2,9
left = false
right = true
self = false
return true

1st recursion:
6,2,9
left = true
right = true
self = false
lca = root = 6
return true

1st call:
5, 2, 9
left = false;
right = true
self = false
return true

lowestCommonAncestor function:
return lca(=6)

*/
