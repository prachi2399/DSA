public class tree_basics{

     public class Node{
      int data;
      Node left=null;
      Node right=null;

      Node(int data){
          this.data=data;
      }  
    }

    static int idx=0;
    public static Node constructTree(int[] arr){
      if(idx>=arr.length||arr[idx]==-1){
          idx++;
          return null;
      }
      Node node=new Node(arr[idx++]);
      node.left=constructTree(arr);
      node.right=constructTree(arr);
      return node;
    } 
    
    public static void display(Node node){
        if(node==null) return;

        StringBuilder sb=new StringBuilder();
        sb.append((node.left==null?".":node.left.data+""));
        sb.append("<-" + node.data + "->");
        sb.append((node.right==null?".":node.right.data+""));

        display(node.left);
        display(node.right);
    }
    
    public static int size(Node node)
    {
        return node==null?0:size(node.left)+size(node.right)+1;
    }
    
    public static int height(Node node){
        return node==null?-1:Math.max(height(node.left),height(node.right))+1;
    }

    public static boolean find(Node node, int data){
        if(node == null) return false;
        if(node.data==data) return true;
        return find(node.left,data)||find(node.right,data); 
    }

    public static boolean nodeToRootPath(Node node, int data, ArrayList<Node> ans){
        if(node==null) return false;
        if(node.data==data){
           // ArrayList<Node> base=new ArrayList<Node>
            ans.add(node);
            return false;
        }
        boolean res=nodeToRootPath(node.left, data,ans)||nodeToRootPath(node.right,data,ans);
        if(res){
            ans.add(node);
             return true;
        }
        return false;
    }
    // public static ArrayList<Node> nodeToRootPath2(Node node, int data){
    //     if(node==null) return null;
    //     ArrayList<Node> base=new ArrayList<Node>();
    //     if(node.data==data) 
    //     {   ans.add(node);
    //         return true;
    //     }
    //     boolean res=nodeToRootPath(node.left,data,ans)||nodeToRootPath(node.right,data,ans);
    //     if(res){
    //         ans.add(node);
    //         return ans;
    //     }
    //     return ans;
    // }

    public static boolean rootToNodePath(Node node, int data,ArrayList<Node> ans){
        if(node==null) return false;
        if(node.data==data) 
        {   ans.add(node);
            return true;
        }
        ans.add(node);
        boolean res=rootToNodePath(node.left,data,ans)||rootToNodePath(node.right,data,ans);
        if(!res)
        {
            ans.remove(ans.size()-1);
        }
        return true;
    }
    public static Node LCA(Node node, int a, int b){
        ArrayList<Node> list1=new ArrayList<>();
        ArrayList<Node> list2=new ArrayList<>();
        nodeToRootPath(node,a,list1);
        nodeToRootPath(node,b,list2);
        int lca;
        int i=list1.size()-1;
        int j=list2.size()-1;
        while(i>=0&&j>=0){
            if(list1.get(i)==list2.get(j)) lca=list1.get(i);
            i--;j--;

        }
        return lca;
    }
      
    static Node LCA=null;
    public static Node LCA_Better(Node node, int d1, int d2){
        if(node==null) return false;

        boolean sf=false;
        if(node.data==d1||node.data==d2) sf=true;
        boolean lf=LCA_Better(node.left,d1,d2);
        if(LCA!=null) return true;
        boolean rf=LCA_Better(node.right,d1,d2);
        if(LCA!=null) return true;
        if((lf&&rf)||(lf&&sf)||(rf&&sf)) LCA=node;
        return lf||rf||sf;
    }
    public static void kDown(Node node, Node block, int k, ArrayList<Integer> ans){
        if(node==null||node==block||k<0){
            return;
        }
        if(k==0) {
            ans.add(node.data);
            return;
        }
        kDown(node.left,block, k-1, ans);
        kDown(node.right,block,k-1,ans);  
    }

    public static void kFar(Node node , int data, int k){
        ArrayList<Node> list=new ArrayList<>();
        nodeToRootPath(node,data,list);
        ArrayList<Integer> ans=new ArrayList<>();
        Node prev=null;
        for(int i=0;i<ans.size();i++){
            kDown(list.get(i),prev,k-i,ans);
            prev=list.get(i);
        }
    }
    
    public static int kFar2(Node node, int data, int k, ArrayList<Integer> ans){
        if(node==null) return -1;
        if(node.data==data){
            kDown(node,null,k,ans);
        }
        int ld=kFar2(node.left,data,k,ans);
        if(ld!=-1){
            kDown(node,node.left,k-ld,ans);
            return ld+1;
        }
        int rd=kFar2(node.right,data,k,ans);
        if(rd!=-1){
            kDown(node,node.right,data,k-rd,ans);
            return rd+1;
        }
    }

    public static int diameter_01(Node node){
        if(node==null) return 0;
        int ld=diameter_01(node.left);
        int rd=diameter_01(node.right);
        
        int lh=height(node.left);
        int rh=height(node.right);

        return Math.max(Math.max(ld,rd),lh+rh+2);
    }
    
    public static int[] diameter_02(Node node){
        if(node==null) return new int[]{0,-1};

        int[] ls=diameter_02(node.left);
        int[] rs=diameter_02(node.right);

        int dia=Math.max(Math.max(ls[0],rs[0]),ls[1]+rs[1]+2);
        int hei=Math.max(ls[1],rs[1])+1;
        return new int[]{dia,hei};
    }
//here we return height in fun and store dia in static ans
     static int diaAns=0;
    public static int diameter_03(Node node){
        if(node==null) return -1;

        int lh=diameter_03(node.left);
        int rh=diameter_03(node.right);
        
        diaAns=Math.max(diaAns,lh+rh+2);
        return Math.max(lh,rh)+1;
    }
     // without using static 
    public static int diameter_04(Node node, int[] diaAns){
        if(node==null) return -1;

        int lh=diameter_03(node.left,diaAns);
        int rh=diameter_03(node.right,diaAns);
        
        diaAns[0]=Math.max(diaAns[0],lh+rh+2);
        return Math.max(lh,rh)+1;
    }

    // 
    public static void widthDiagonal(Node node, int level, int[] res){
        if(node==null) return;
        res[0]=Math.min(level,res[0]);
        widthDiagonal(node.left,level-1,res);
        widthDiagonal(node.right,level,res);
    }
    public static void diagonlaView(Node node, int level, ArrayList<Integer>[] ans){
        if(node == null) return;
        ans[level].add(node.data);
        diagonlaView(node.left,level-1,ans);
        diagonlaView(node.right,level,ans);
    }
    public static void diagonlaView(Node node){
        int[] res=new int[1];
        widthDiagonal(node,0, res);
        ArrayList<Integer>[] ans=new ArrayList[0-res[0]+1];
        diagonlaView(node,-res[0],ans);
    }


//pred, succ, ceil, floor in BT

    public static class allSol{
        Node prev=null;
        Node pred=null;
        Node succ=null;
        Node ceil=null;
        Node floor=null;

    }
    public static void allSolution(Node node){
        if(node==null) return;
        allSolution(node.left);
        if(node.data==data){
            ans.pred=ans.prev;
        }
        if(ans.prev!=null&&ans.prev.data==data){
            ans.succ=node;
        }
        if(node.data>data){
            ans.ceil=Math.min(node.data,ans.ciel);
        }
        if(node.data<data){
            ans.floor=Math.max(node.data,ans.floor);
        }
        ans.prev=node;
        allSolution(node.right);
        if(node.data==data){
            ans.pred=ans.prev;
        }
        if(ans.prev!=null&&ans.prev.data=data){
            ans.succ=node;
        }

    }
    
    public TreeNode doubleTree(TreeNode node){
        if(node==null) return node;
        
        TreeNode lans=doubleTree(node.left);
        TreeNode rans=doubleTree(node.right);
        
        TreeNode nNode=new TreeNode(node.val);
        node.left=nNode;
        nNode.left=lans;
        node.right=rans;
    }

    public class allSolPair{
        Node prev=null;
        Node pred=null;
        Node succ=null;
        Node ceil=(int)1e8;
        Node floor=-(int)1e8;
    }
    public static void predSucc(Node root, allSolPair ans){
       if(root==null) return;
       predSucc(root.left);
        if(node.data==data){
           ans.pred=ans.prev;
        }
        if(node.data>data) {
         ceil=Math.min(ceil,node.data);
        }
        else if(node.data<data){
         floor=Math.max(floor,node.data);
        }
        if(ans.prev!=null&&ans.pred.data==data){
            ans.succ=node;
        }
        ans.prev=node;
       predSucc(root.right);
    }
    //contruct tree from inorder preorder
    public TreeNode construct(int[] preorder, int psi, int pei, int [] inorder, int isi, int iei){
        if(psi>pei) return null;
        int idx=isi;
        TreeNode root=new TreeNode(preorder[psi]);
        while(inorder[idx]!=preorder[psi]){
            idx++;
        }
        int count=idx-isi;
        root.left=construct(preorder,psi+1,psi+count, inorder, isi, idx-1);
        root.right=construct(preorder,psi+count+1,pei, inorder, idx+1,iei);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        return construct(preorder,0,n-1,inorder,0,n-1);
    }
    //inorder postorder 
    public TreeNode construct(int[] postorder, int psi, int pei, int [] inorder, int isi, int iei){
        if(psi>pei) return null;
        TreeNode root=new TreeNode(postorder[pei]);
        int idx=isi; 
        while(inorder[idx]!=postorder[pei]){
            idx++;
        }
        int count=idx-isi;
        root.left=construct(postorder,psi,psi+count-1, inorder, isi, idx-1);
        root.right=construct(postorder,psi+count,pei-1, inorder, idx+1,iei);
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int n=postorder.length;
        return construct(postorder,0,n-1,inorder,0,n-1);
    }
    
    //postorder preorder
    public TreeNode construct(int[] pre, int psi, int pei, int [] post, int ppsi, int ppei){
        if(psi>pei) return null;  
        TreeNode root=new TreeNode(pre[psi]);
        if(psi==pei) return root;
        int idx=ppsi; 
        while(post[idx]!=pre[psi+1]){
            idx++;
        }
        int count=idx-ppsi+1;
        root.left=construct(pre,psi+1,psi+count, post, ppsi, idx);
        root.right=construct(pre,psi+count+1,pei, post, idx+1,ppei-1);
        return root;
        
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int n=pre.length;
        return construct(pre,0,n-1,post,0,n-1);
    }

    public static void solve(){
        int[] arr={10,20,40,-1,-1,50,80,-1,-1,90,-1,-1,30,60,100,-1,-1,-1,70,110,-1,-1,120,-1,-1};
        Node root=constructTree(arr);
        display(root);
    }

    public static void main(String[] args){
        solve();
     }
  
}