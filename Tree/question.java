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
    int maxSumLTL = -1e8; // max sum leaf to leaf.
    int leafToLeafPathSum(TreeNode node){
    if(node==null) return -1e8;
    int lPathSum=leafToLeafPathSum(node.left);
    int rPathSum=leafToLeafPathSum(node.right);
    if(root.left==null&&root.right==null) return root.val;
    if(root.left!=null&&root.right!=null){
        maxSumLTL=Math.max(maxSumLTL,lPathSum+rPathSum+root.val);
        return Math.max(lPathSum,rPathSum)+root.val;
    }
}
//leetcode 124 max Path Sum
int maxPathAns=-(int)1e8;
    public int maxPathSum_(TreeNode root) {
        if(root==null) return 0;
        
        int lPathSum=maxPathSum_(root.left);
        int rPathSum=maxPathSum_(root.right);
        
        int maxTillRoot=Math.max(lPathSum,rPathSum)+root.val;
        
        maxPathAns=Math.max(Math.max(maxPathAns,maxTillRoot),Math.max(root.val,lPathSum+rPathSum+root.val));
        return Math.max(maxTillRoot,root.val);
        
    }
     public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxPathSum_(root);
        return maxPathAns;
    }
}