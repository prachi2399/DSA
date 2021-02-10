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
    //deepest left node
    static int maxLevel=0;
    static Node result=null;
    void deepestLeftLeafUtil(Node node,  int lvl, boolean isLeft){
        if(node==null) return ;
        if(isLeft&&node.left==null&&node.right==null&&lvl>maxLevel){
            maxLevel=lvl;
            result=node;
        }
        deepestLeftLeafUtil(node.left,lvl+1,true);
        deepestLeftLeafUtil(node.right,lvl+1,false);
    }
    void deepestLeftLeaf(Node node)  
    { 
        if(node==null) return null;
        deepestLeftLeafUtil(node, 0, false); 
        System.out.println(result);
    } 
    //count subtree with given sum;
    int countSubtreeSum(Node node, int count, int X){
        if(node==null) return 0;
        int lans=countSubtreeSum(node.left,count,x);
        int rans=countSubtreeSum(node.right,count,x);
        int sum=lans+rans+root.data;
        if(sum==X) count++;
        return sum; 
    }
    int subtreeSum(Node node, int X){
        int count=0;
        countSubtreeSum(node,count,X);
        return count;
    }

       //convert tree to sum tree;
       int sumTree(Node node){
           if(node==null) return 0;
           int nodeVal=node.data;
           int lans=sumTree(node.left);
           int rans=sumTree(node.right);
           node.data=lans+rans;
           return node.data+nodeVal;
       }

       // convert tree into left sum;
       int LeftSumTree(Node node){
        if(node==null) return 0;
        if(node.left==null&&node.right==null) return node.data;
        int lans=sumTree(node.left);
        int rans=sumTree(node.right);
        node.data=lans+node.data;
        return node.data+rans;
    }

    //clone tree with random pointers
    public static Tree copyLeftRightTree(Tree tree,HashMap<Tree,Tree> map){
        if(tree==null) return null;
        Tree clone=new Tree(tree.data);
        map.put(tree,clone);
        clone.left=copyLeftRightTree(tree.left,map);
        clone.right=copyLeftRightTree(tree.right,map);
        return clone;
      }
      
     public static void copyRandom(Tree root, Tree clone , HashMap<Tree,Tree> map){
         if(root==null) return;
         clone.random=map.get(root.random);
         copyRandom(root.left,clone.left,map);
         copyRandom(root.right,clone.right,map);
     } 
     public static Tree cloneTree(Tree tree){
        HashMap<Tree,Tree> map=new HashMap<>();
        Tree clone=copyLeftRightTree(tree,map);
         copyRandom(tree,clone,map);
         return clone;
     }
     //maximum leaf to root path;
     public int maxSum=0;
     public TreeNode leafNode=null;
     public int maxPath(TreeNode root, int currSum){
          if(node==null) return 0;
          currSum+=node.val;
          if(node.left==null&&node.right==null){
            if(currSum>maxSum){
                maxSum=currSum;
                leafNode=node;
            }
          }
          maxPath(root.left,currSum);
          maxPath(root.right,currSum);
     }

     public int maxPath(TreeNode root){
         if(root==null) return 0;
         maxPath(root,0);
     }
     //
     public static boolean leafSameLevel(TreeNode node){
       if(node==null) return true;
       int leftLevel=0;
       int curr=node;
       while(curr.left!=null){
           leftLevel++;
           curr=curr.left;
         } 
        if(node.left==null&&node.right==null){
        return leftLevel==level;
       } 
       return leafSameLevel(node.left)&&leafSameLevel(node.right);
     }
}