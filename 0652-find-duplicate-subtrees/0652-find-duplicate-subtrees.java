/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) 
    {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        encode(root, count, ans);
        return ans;
    }
    private String encode(TreeNode root, Map<String, Integer> count, List<TreeNode> ans)
    {
        if (root == null)
            return "";
        
        final String encoded = root.val + "#" + encode(root.left, count, ans) + "#" + encode(root.right, count, ans);//# for encoding null left and right childs
        count.merge(encoded, 1, Integer::sum);
        //used to add the encoding to the count map. If the encoding already exists in the map, its count is incremented by 1 using the Integer::sum function. If it doesn't exist, a new entry is added with a count of 1. This ensures that each subtree encoding is counted exactly once in the map.
        if (count.get(encoded) == 2)//duplicate subtree
            ans.add(root);//add the roots
        return encoded;
    }
}