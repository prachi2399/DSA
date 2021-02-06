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
        que.add(new Pair(root,0));
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
        que.add(new Pair(root,0));
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
        width(minMax,0);
        int n=minMax[0]-minMax[1];
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=new ArrayList<>();
        }

        LinkedList<Pair> que=new LinkedList<>();
        que.add(new Pair(root,0));
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
}
