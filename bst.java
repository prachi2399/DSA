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

    // pred succ in bst;
    public class allSolPair{
        Node prev=null;
        Node pred=null;
        Node succ=null;
    }
    public void predSucc(Node root, allSolPair ans){
        Node pred=null;
        Node succ=null;
        if(node==null) return;
        Node curr=root;
        while(curr!=null){
            if(curr.data==data){
            if(curr.left!=null){
              pred=curr.left;
              while(pred.right!=null){
                  pred=pred.right;
              }
            }else if(curr.right!=null){
                succ=curr.right;
                while(succ.right!=null){
                    succ=succ.right;
                }
              }
        }
        else if(curr.data<data){
            pred=curr;
            curr=curr.right;
        }
        else{
            succ=curr;
            curr=curr.left;
        }
        } 
    }

    //construct bst from level order
    public Node LevelOrder(Node root, int data){
        if(root==null){
            Node newRoot=new Node(data);
            newRoot.left=null; 
            newRoot.right=null;
            root=newRoot;
            return root;
        }
        else if(data<root.data){
           root.left= LevelOrder(root.left,data);
        }else if(data>root.data){
          root.right= LevelOrder(root.right,data);
        }
        return root;
    }
    public Node constructBST(int[] arr){
       Node root=null;
       for(int i=0;i<arr.length;i++){
           root=LevelOrder(root,arr[i]);
       }
       return root;
    }

    //dead end in bst
    public static void putLeafMap(Node root,HashSet<Integer> set, HashSet<Integer> leafSet)
    { 
        if(root==null) return;
        set.add(root.val);
        if(root.left==null||root.right==null){
             leafSet.add(root.val);
             return;
        }     
        putLeafMap(root.left);
        putLeafMap(root.right);
    }
    public static boolean isDeadEnd(Node root)
    {   HashSet<Integer> set = new HashSet<Integer>(); 
        HashSet<Integer> leafSet = new HashSet<Integer>();
        
        putLeafMap(root,set,leafSet);
        for(Integer data: leafSet){
            if(data==1) return true;
            if(set.contains(data-1)&&set.contains(data+1)) return true;
        }
        return false;
    }
    // alternate dead end;
    public static boolean DeadEnd(Node root,int min, int max)
    { if(root==null) return false;
      if(root.data==min+1&&root.data==max-1){
          return true;
      }
      return DeadEnd(root.left,min,root.data)||DeadEnd(root.right,root.data,max);
    }
    public static boolean isDeadEnd(Node root)
    {
        return DeadEnd(root, 0, (int)1e8);
    }
    public Node deleteOutofRangeNode(Node root, int min, int max){
        if(root==null) return null;
        deleteOutofRangeNode(root.left,min,max);
        deleteOutofRangeNode(root.right,min,max);
        if(!(root.val>=min &&root.val<=max)){
            DeleteInBST_(root,root.val);
        }
        return root;
    }   
    static int ksmallestElementSumRec(Node root, int k)
   {
       int count=0;
       int res=ksmallestElementSumRec(root.left,k);
       if(count>k) return res;
       res+=root.data;
       count++;
       if(count>k) return res;
       return res+ksmallestElementSumRec(root.right,k);
   }
   public static Node lca(Node root, int x, int y){
       if(root==null) return null;
       if(root.val>x&&root.val>y) root=root.left;
       else if(root.val<x&&root.val<y) root=root.left;
       else return root;
   }
   public static Node maxNodefromLca(Node p, int x){
    if(node==null) return null;
    int mx=-1;
    while(p.data!=x){
        if(p.data>x){
            mx=Math.max(mx,p.data);
            p=p.left;
        }
        else{
            mx=Math.max(mx,p.data);
            p=p.right;
        }
    }
    return Math.max(mx,x);
}
    public Node findMax(Node node, int x, int y){
       Node lca=lca(node,x,y);
       return Math.max(maxNodefromLca(node,x),maxNodefromLca(node,y));
    }

    static int maxDiff=(int)1e8;
     
    // Return the minimum absolute difference between any tree node and the integer K
    static void findKey(Node root,int K){
        if(root==null) return;
            if(root.data==K) {
                maxDiff=0;
                return ;}
            maxDiff=Math.min(maxDiff,Math.abs(root.data-K));
            if(K<root.data){
              findKey(root.left,K);  
            } else{
            findKey(root.right,K);
            }
    } 
    static int maxDiff(Node  root, int K) 
    { 
        findKey(root,K);
        return maxDiff;
    } 

    static void leafNodes(int preorder[], int n) 
{ 
    int inorder[] = new int[n];  
  
    for (int i = 0; i < n; i++) 
        inorder[i] = preorder[i]; 
  
    Arrays.sort(inorder); 
  
    leafNodesRec(preorder, inorder, 0, n - 1, n); 
} 
    static void leafNodesRec(int[] preorder, int[] inorder, int l, int r, int tle){
        if(l==r){
            System.out.println(preorder[l]);
        }
        if(l<0||r>n||l>r) return;
        int idx=l;
        
        while(inorder[idx]!=preorder[l]){
            idx++;
        }
        leafNodesRec(preorder,inorder,l,idx-1,tle);
        leafNodesRec(preorder,inorder,idx+1,r,tle);
    }

    // 
    int sum=0;
    public void modifyBST(Node root){
        if(root==null) return;
        modifyBST(root.right);
        sum=sum+root.data;
        root.data=sum;
        modifyBST(root.left);
    }
    public Node modify(Node root)
    {   int sum=0;
        modifyBST(root);
        return root;
    }
    
}