import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}

class GfG {
    public boolean nodeToRootPath(Node root, int data, ArrayList<Integer> ans){
        if(root==null) return false;
        if(root.data==data){
            ans.add(root.data);
            return true;
        }
        boolean res=nodeToRootPath(root.left,data,ans)||nodeToRootPath(root.right,data,ans);
        if(res){
            ans.add(root.data);
        }
        return res;
    }
     ArrayList<Integer> ans1=new ArrayList<>();
      ArrayList<Integer> ans2=new ArrayList<>();
    int findLCA(Node root, int a , int b){
      boolean res1=nodeToRootPath(root,a,ans1);
      boolean res2=nodeToRootPath(root,a,ans2);
      int i=ans1.size()-1;
      int j=ans2.size()-1;
      int lca=0;
      while(i>=0&&j>=0){
          if(ans1.get(i)==ans2.get(j)) lca++;
      }
      return lca;
    }
    int findDist(Node root, int a, int b) {
      if(root==null) return 0;
      int lca=findLCA(root,a,b);
      int size1=ans1.size();
      int size2=ans2.size();
      int res=size1+size2-2*(lca);
      return res;
    }
}