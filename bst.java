public class bst{
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int size(Node node)
    {
        return node==null?0:size(node.left)+size(node.right)+1;
    }
    
    public static int height(Node node){
        return node==null?-1:Math.max(height(node.left),height(node.right))+1;
    }

    public int minEle(TreeNode root){
        if(root==null) return -1;
        TreeNode curr=root;
        while(curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }

    public int maxEle(TreeNode root){
        if(root==null) return -1;
        TreeNode curr=root;
        while(curr.right!=null){
            curr=curr.right;
        }
        return curr;
    }

    public boolean findData(TreeNode node, int data){
        if(node==null) return false;
        TreeNode curr=root;
        while(curr!=null){
            if(curr.val==data) return true;
            if(node.val>curr.val)  curr=curr.left;
            else curr=curr.right;
        }
        return false;
    }

    public boolean findDataRec(TreeNode node, int data){
        if(node==null) return false;
       
        if(node.val==data) return true;
        if(node.val>data)  return findDataRec(node.left,data);
        else return findDataRec(node.right,data);
        return false;
    }

    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(!isValidBST(root.left)) return false;
        if(prev!=null&&prev.val>=root.val) return false;
        prev=root;
        if(!isValidBST(root.right)) return false;
        return true; 
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.val>val) root.left=insertIntoBST(root.left,val);
        else root.right=insertIntoBST(root.right,val);
        
        return root;
    }

    public TreeNode insertIntoBST_(TreeNode root, int val){

    }
    
    public TreeNode LCA_Bst(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        TreeNode curr=root;
        while(root!=null){
            if(curr.val>p.val&&curr.val>q.val){
                curr=curr.left;
            }
            else if(curr.val<p.val&&curr.val<q.val){
                curr=curr.right;
            }
            else return curr;
        }
        return null;
    }
}