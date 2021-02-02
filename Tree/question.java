public class question{
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null||root.right==null){
            if(targetSum-root.val==0) return true;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }

    //leetcode 113
    public void pathSum(TreeNode root, int targetSum,List<List<Integer>> res, List<Integer> smallAns) {
        if(root==null) return;
        if(root.left==null&&root.right==null){
            if(targetSum-root.val==0){
                List<Integer> base=new ArrayList<>(smallAns);
                base.add(root.val);
                res.add(base);
            }
            return;
        }
        smallAns.add(root.val);  
        pathSum(root.left,targetSum-root.val,res,smallAns);
        pathSum(root.right,targetSum-root.val,res,smallAns);
        smallAns.remove(smallAns.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> res=new ArrayList<>();
         pathSum(root, targetSum, res, new ArrayList<>());
        return res;
    }
    //
}