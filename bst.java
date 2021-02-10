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

    public class Pair{
       boolean isBst=true;
       int maxele=-(int)1e8;
       int minEle=(int) 1e8;
       Pair(boolean isBst, int maxele, int minele){
           this.isBst=isBst;
           this.maxele=maxele;
           this.minele=minele;
       }
    }

    public Pair isBST(TreeNode root){
        if(root==null) return new Pair();
        
        Pair lans=isBst(root.left);
        Pair rans=isBst(root.right);
        
        Pair myAns=new Pair();
        if(!lans.isBst||!rans.isBst||left.max>root.val||right.min<root.val){
            myAns.isBst=false;
            return myAns;
        }
        myAns.minele=Math.min(node.data,lans.minele);
        myAns.maxele=Math.max(node.data,lans.maxele);
        return myAns;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.val>val) root.left=insertIntoBST(root.left,val);
        else root.right=insertIntoBST(root.right,val);
        
        return root;
    }

    public TreeNode insertIntoBST_(TreeNode root, int val){
     
    }
    
    public TreeNode DeleteInBST_(TreeNode root, int val){
     if(root==null) return;
     if(root.data>val) root.left= DeleteInBST_(root.right,val);
     else if(root.data<val) root.right=DeleteInBST_(root.right,val);
     else{
          maxele=maxEle(root.left);
          root.val=maxele;
          root.left=DeleteInBST_(root.left,mval);
     }
     return root;
    }

    public TreeNode createBST(int[] arr, int si, int ei) {
        if(si>ei) return null;
        int mid=si+ei/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=createBST(arr,si,mid-1);
        root.right=createBST(arr,mid+1,ei);
        return root;
    }

    ////
    public void KthSmallestElement_(Node root, ArrayList<Integer> ans) 
    {
     if(root==null) return;
      KthSmallestElement_(root.left,ans);
      ans.add(root.data);
      KthSmallestElement_(root.right,ans);
    }
    public int KthSmallestElement(Node root, int k) 
    {
     if(root==null) return 0;
      ArrayList<Integer> ans=new ArrayList<>();
      KthSmallestElement_(root,ans);
      return k>ans.size()?-1:ans.get(k-1);
    }

    //Alt
    public Node KthSmallestElement(Node root, int k) 
    {
      if(root==null) return 0;
      int count=0;
      Node left=KthSmallestElement(root.left,k);
      if(left!=null) return left;
      count++;
      if(count==k) return root; 
      Node right=KthSmallestElement(root.right,k);
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