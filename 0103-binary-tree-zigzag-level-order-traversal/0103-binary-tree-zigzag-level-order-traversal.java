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
class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
//     }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
       if(root == null){
            return res;
       }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        
        while(queue.size() > 0){
            int lsize = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            
            
            for (int i = 0; i < lsize; i++) {
                TreeNode temp = queue.remove();
                                
                list.add(temp.val);
                
                if(temp.left != null){
                    queue.add(temp.left);
                }
    
                if(temp.right != null){
                    queue.add(temp.right);
                }               
                
            }
            
            if(count % 2 == 1) Collections.reverse(list);
            res.add(list);
            count++;
    
        }
        
        return res;
    }
}