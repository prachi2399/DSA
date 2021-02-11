public class avl{
    public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       int ht=-1;
       int bal=0;
        TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right,int ht, int bal) {
           this.val = val;
           this.left = left;
           this.right = right;
           this.ht=ht;
           this.bal=bal;
      }
   }

   public static void updateHeightBalance(TreeNode node){
       if(node==null) return;
       int lh=-1;
       int rh=-1;
       if(node.left!=null) lh=node.left.ht;
       if(node.right!=null) rh=node.right.ht;
       node.bal=lh-rh;
       node.ht=Math.max(lh,rh)+1;
   }
    
    public static TreeNode rightRotation(TreeNode A){
        if(node==null) return null;
        TreeNode B=A.left;
        TreeNode BRight=B.right;
        B.right=A;
        A.left=BRight;
        updateHeightBalance(A);
        updateHeightBalance(B);
    }

    public static TreeNode leftRotation(TreeNode A){
        if(node==null) return null;
        TreeNode B=A.right;
        TreeNode BLeft=B.left;
        B.left=A;
        A.right=BLeft;
        updateHeightBalance(A);
        updateHeightBalance(B);
    }
    public static TreeNode getRotation(TreeNode node){
       updateHeightBalance(node);
       if(node.bal==2){//ll,lr
         if(node.left.bal=1){//ll
            return rightRotation(node);
         }else{//lr
            node.left=leftRotation(node.left);
            return rightRotation(node);
         }
       }else{
          if(node.right.bal==-1){//rr
            return leftRotation(node);
          }
          else{//rl
            node.right=rightRotation(node.left);
            return leftRotation(node);
          }
       }
   } 

   // bst function
    public static Node addData(TreeNode node, int data){
       if(root==null) return new TreeNode(data);
       if(node.data>data) addData(node.left,data);
       else if(node.data<data) addData(node.right,data);
   }
    
    public static int maximum(Node node) {
    Node curr = node;
    while (curr.right != null) {
        curr = curr.right;
    }
    return curr.data;
    }
    
    public static Node removeData(TreeNode node, int data){
        if(node.data > data){
            removeData(node.left,data);
        }
        else if(node.data < data){
            removeData(node.right,data);
        }
        else if(node.data==data){
           if(node.left==null||node.right==null){
               node.left==null?node.right:node.left;
           }
           else{
               int max=maximum(node);
               node.val=max;
               removeData(node,max);
           }
            return rotateSubTree(node);
        }
    }
    // bst to avl
    public static Node postOrder(Node node){
        if(node==null) return null;
        node.left=postOrder(node.left);
        node.right=postOrder(node.right);
        return getRotation(node);
    }
    public static void display(TreeNode node){
        if (node == null)
            return;
        String str = "";
        str += node.left != null ? node.left.data : ".";
        str += " <- " + node.data + " -> ";
        str += node.right != null ? node.right.data : ".";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static void solve() {
        int[] arr = new int[15];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (i + 1) * 10;

        Node root = null;
        for (int ele : arr)
            root = addData(root, ele);

        display(root);
        System.out.println();
        int i = 0;
        for (int ele : arr) {
            root = removeData(root, ele);
            if (i++ == 6)
                break;
        }
        display(root);
    }
    public static void main(String[] args) {
        solve();
    }


}