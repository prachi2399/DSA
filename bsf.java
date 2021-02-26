import java.util.LinkedList;
public class bsf{
    public class Node{
        int data;
        Node left=null;
        Node right=null;
  
        Node(int data){
            this.data=data;
        }  
    }
    public static void BSF_01(Node root){
      LinkedList<Node> que=new LinkedList<>();
      que.addLast(root);
      while(que.size()>0){
          Node rem=que.removeFirst();
          System.out.println(rem.data+" ");
          if(node.left!=null) que.addLast(rem.left);
          if(node.right!=null) que.addLast(rem.right);
      }
    }
    //
    public static void BSF_02(Node root){
        LinkedList<Node> que=new LinkedList<>();
        que.addLast(root);
        que.addLast(null);
        while(que.size()>0){
            Node rem=que.removeFirst();
            System.out.print(rem.data+" ");
            if(node.left!=null) que.addLast(rem.left);
            if(node.right!=null) que.addLast(rem.right);
            if(node==null){
                System.out.println();
                que.removeFirst();
                que.addLast(null);
            }
        }
    }
    
    public class BSF_03(Node root){
        LinkedList<Node> que=new LinkedList<>();
        que.addLast(root);
        int level=0;
        System.out.print("Level"+level);
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                Node rem=que.removeFirst();
                System.out.print(rem.data);
                if(rem.left!=null) que.addLast(rem.left);
                if(rem.right!=null) que.addLast(rem.right);
            }
            System.out.println();
            level++;
        }
    }
    //107. Binary Tree Level Order Traversal II

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);
        int level=0;
        while(que.size()>0){
            List<Integer> ans=new ArrayList<>();
            int size=que.size();
            while(size-->0){
                TreeNode rem=que.removeFirst();
                    ans.add(rem.val);
        
                if(rem.left!=null) que.addLast(rem.left);
                if(rem.right!=null) que.addLast(rem.right);
            }
            level++;
            //Collections.reverse(ans);
            res.add(ans);
        }
         Collections.reverse(res);
        return res;
    }
    //103. Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);
        int level=0;
        while(que.size()>0){
            List<Integer> ans=new ArrayList<>();
            int size=que.size();
            while(size-->0){
                TreeNode rem=que.removeFirst();
                if(level%2==0){
                    ans.add(rem.val);
                }
                else{
                    ans.add(0,rem.val);
                }
                if(rem.left!=null) que.addLast(rem.left);
                if(rem.right!=null) que.addLast(rem.right);
            }
            level++;
            res.add(ans);
        }
        return res;
    }
    //left view
    public class leftView(Node root){
        LinkedList<Node> que=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        que.addLast(root);
        int level=0;
        while(que.size()>0){
            int size=que.size();
            ans.add(que.getFirst().data);
            while(size-->0){
                Node rem=que.removeFirst();
                System.out.print(rem.data);
                if(rem.left!=null) que.addLast(rem.left);
                if(rem.right!=null) que.addLast(rem.right);
            }
            System.out.println();
            level++;
        }
        return ans;
    }
    public class rightView(Node root){
        LinkedList<Node> que=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int prev=-1;
        que.addLast(root);
        int level=0;
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                Node rem=que.removeFirst();
                System.out.print(rem.data);
                if(rem.left!=null) que.addLast(rem.left);
                if(rem.right!=null) que.addLast(rem.right);
                prev=rem.data;
            }
            ans.add(prev);
            level++;
        }
        return ans;
    }

    public class Pair{
        TreeNode node;
        int width;
        Pair(TreeNode node, int width){
        this.node=node;
        this.width=width;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root){
        LinkedList<Pair> que=new LinkedList<>();
        que.add(new Pair(root,0));

        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int minWidth=0;
        int maxWidth=0;
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                Pair rem=que.removeFirst();

                map.putIfAbsent(rem.width,new ArrayList<Integer>);
                map.put(rem.width,map.get(rem.width).add(rem.val));

                minWidth=Math.min(minWidth,rem.width);
                maxWidth=Math.min(mazWidth,rem.width);

                if(rem.node.left!=null) que.addLast(new Pair(rem.node.left,rem.width-1));
                if(rem.node.right!=null) que.addLast(new Pair(rem.node.right,rem.width+1));
            }
        }
        List<List<Integer> res=new ArrayList<>();
        while(minWidth<=maxWidth){
            res.add(map.get(minWidth));
            minWidth++;
        }
    }
    // alternate way Vertical Order
    public static void width(int[] minMax, int level){
        if(node==null){return;}
        minMax[0]=Math.min(minMax[0],level);
        minMax[1]=Math.max(minMax[1],level);
        width(minMax.left,level-1);
        width(minMax.right,level+1); 
    }

    public List<List<Integer> verticalTraversal_02(TreeNode root){
        int[] minMax=new int[2];
        width(minMax,0);
        int n=minMax[0]-minMax[1];
        ArrayList<Integer>[] ans=new ArrayList[n];
        for(int i=0;i<n;i++){
            ans[i]=new ArrayList<>();
        }

        LinkedList<Pair> que=new LinkedList<>();
        que.add(new Pair(root,-minMax));
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                TreeNode rem=que.removeFirst();
                ans[rem.width].add(rem.node.val);
                if(rem.node.left!=null) que.addLast(new Pair(rem.node.left,rem.width-1));
                if(rem.node.right!=null) que.addLast(new Pair(rem.node.right,rem.width+1));
            }
        }
    }

    public int[] verticalSum(TreeNode root){
        int[] minMax=new int[2];
        width(minMax,0);
        int n=minMax[0]-minMax[1];
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=new ArrayList<>();
        }

        LinkedList<Pair> que=new LinkedList<>();
        que.add(new Pair(root,-minMax));
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                TreeNode rem=que.removeFirst();
                ans[rem.width]+=rem.node.val;
                if(rem.node.left!=null) que.addLast(new Pair(rem.node.left,rem.width-1));
                if(rem.node.right!=null) que.addLast(new Pair(rem.node.right,rem.width+1));
            }
        }
        return ans;
    }

    public int[] bottomView(TreeNode root){
        int[] minMax=new int[2];
        width(root,minMax,0);
        int n=minMax[1]-minMax[0]+1;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=new ArrayList<>();
        }

        LinkedList<Pair> que=new LinkedList<>();
        que.add(new Pair(root,-minMax[0]));
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                TreeNode rem=que.removeFirst();
                ans[rem.width]=rem.node.val;
                if(rem.node.left!=null) que.addLast(new Pair(rem.node.left,rem.width-1));
                if(rem.node.right!=null) que.addLast(new Pair(rem.node.right,rem.width+1));
            }
        }
        return ans;
    }
    /// vertical order leetcode
    public class Pair2{
        TreeNode node;
        int x;
        int y;
        Pair2(TreeNode node, int x, int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }
    }
    public static void width(TreeNode node, int[] minMax, int level){
       if(node==null){return;}
        minMax[0]=Math.min(minMax[0],level);
        minMax[1]=Math.max(minMax[1],level);
        width(node.left,minMax,level-1);
        width(node.right,minMax,level+1); 
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Pair2> que=new PriorityQueue<>((a,b)->{
            if(a.y!=b.y) return a.y-b.y;
            else return a.node.val-b.node.val;
        });
        int[] minMax=new int[2];
        width(root,minMax,0);
        int n=minMax[1]-minMax[0]+1;
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
        }

        que.add(new Pair2(root,-minMax[0],0));
        while(que.size()>0){
            
                Pair2 rem=que.remove();
                ans.get(rem.x).add(rem.node.val);
                if(rem.node.left!=null) que.add(new Pair2(rem.node.left,rem.x-1,rem.y+1));
                if(rem.node.right!=null) que.add(new Pair2(rem.node.right,rem.x+1,rem.y+1));
            
        }
        return ans;
    }
    //diagonal traversal
    public List<List<Integer>> diagonalTraversal(TreeNode root){
        LinkedList<Pair> que=new LinkedList<>();
        que.add(new Pair(root,0));

        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int minWidth=0;
        int maxWidth=0;
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                Pair rem=que.removeFirst();

                map.putIfAbsent(rem.width,new ArrayList<Integer>);
                map.get(rem.width).add(rem.node.val);

                minWidth=Math.min(minWidth,rem.width);
                maxWidth=Math.min(mazWidth,rem.width);

                if(rem.node.left!=null) que.addLast(new Pair(rem.node.left,rem.width-1));
                if(rem.node.right!=null) que.addLast(new Pair(rem.node.right,rem.width));
            }
        }
        List<List<Integer> res=new ArrayList<>();
        while(minWidth<=maxWidth){
            res.add(map.get(minWidth));
            minWidth++;
        }
        return ans;
    }

    //boundary traversal of tree
    public void printLeftTree(TreeNode node){
        if(node==null) return;
        if(node.left!=null){
            System.out.println(node.data+" ");
            printLeftTree(node.left);
        }
        else if(node.right!=null){
            System.out.print(node.data+" ");
            printLeftTree(node.right);
        }
    }

    public void printRightTree(TreeNode node){
        if(node==null) return;
        if(node.right!=null){
            printRightTree(node.right);
            System.out.println(node.data+" ");
        }
        else if(node.left!=null){
            printRightTree(node.left);
            System.out.println(node.data+" ");
        }
    }
    public void printLeafs(TreeNode node){
        if(node==null) return;

        printLeafs(node.left);
        if(node.left==null&&node.right==null) return true;
        printLeafs(node.right);
    }
    public void boundaryTraversal(TreeNode node){
        if(node==null) return;

        printLeftTree(node.left);
        
        printLeafs(node.left);
        printLeafs(node.right);

        printRightTree(node.right);
    }
    // 
    void printSpecificLevelOrder(Node node)  
    { 
      if(node==null) return;
      System.out.println(node.data);
      LinkedList<Integer> que=new LinkedList<>();
    
      if(node.left.left!=null) return;

      que.add(node.left);
      que.add(node.right);
      while(que.size()>0){
          Node one=que.removeFirst();
          Node two=que.removeFirst();
          System.out.print(" " + one.left.data + " " +two.right.data); 
          System.out.print(" " + one.right.data + " " +two.left.data); 
          if(one.left!=null){ 
             que.push(one.left);
             que.push(two.right);
             que.push(one.right);
             que.push(two.left);
          }
      }
    }
    // connect Node at same level
    public Node connect(Node root) {
        if(root==null) return null;
        LinkedList<Node> que=new LinkedList<>();
        que.add(root);
        Node temp=null;
        while(que.size()>0){
           
            int size=que.size();
            for(int i=0;i<size;i++){
              Node prev=temp;
            temp=que.removeFirst();
            if(i>0){
                prev.next=temp;
            }
            if(temp.left!=null) que.addLast(temp.left);
            if(temp.right!=null) que.addLast(temp.right);
            }
            temp.next=null;
            temp=temp.next;
        } 
         return root;
     }

     //find next right node;
     Node nextRight(Node root, int k) {
        if(root==null) return null;
        LinkedList<Node> que=new LinkedList<>();
        que.add(root);
        Node ans=null;
        while(que.size()>0){
            int size=que.size();
            for(int i=0;i<size;i++){
            Node temp=que.removeFirst();
            if(temp.node.data==k){
                if(i==size-1){
                    ans=null;
                }
                else ans=que.getFirst().node;
            }
            if(temp.left!=null) que.addLast(temp.left);
            if(temp.right!=null) que.addLast(temp.right);
            }
        } 
        return ans;
     }
    //maximum width of binary tree
    int maxWidth(Node root, int k) {
        if(root==null) return null;
        LinkedList<Node> que=new LinkedList<>();
        que.add(root);
        int  maxwidth=0;
        while(que.size()>0){
            int size=que.size();
            maxwidth=Math.max(maxwidth,size);
            for(int i=0;i<size;i++){
            Node temp=que.removeFirst();
            if(temp.node.data==k){
                if(i==size-1){
                    ans=null;
                }
                else ans=que.getFirst().node;
            }
            if(temp.left!=null) que.addLast(temp.left);
            if(temp.right!=null) que.addLast(temp.right);
            }
        } 
        return maxwidth;
     }

     // check if leafs are at same level
     public static boolean checkLeaf(TreeNode root){
         if(root==null) return true
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);
        int level=0;
        int result=-(int) 1e8;
        System.out.print("Level"+level);
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                TreeNode rem=que.removeFirst();
                System.out.print(rem.data);
                if(rem.left!=null) {
                    if(rem.left.left==null&&rem.right.right==null){
                     if(result==-(int)1e8) result=level;
                     else if(result!=level) return true;
                    }
                    que.addLast(rem.left);
                }
                if(rem.right!=null) {
                    if(rem.left.left==null&&rem.right.right==null){
                        if(result==-(int)1e8) result=level;
                        else if(result!=level) return true;
                       }
                    que.addLast(rem.right);
                }
            }
            System.out.println();
            level++;
        }
    }
}
