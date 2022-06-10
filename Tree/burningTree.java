public class burningTree{

     public class Node{
      int data;
      Node left=null;
      Node right=null;

      Node(int data){
          this.data=data;
      }  
    }
  
HashMap <Node,Node> parent=new HashMap<>();
HashMap <Node,Integer> vis=new HashMap<>();
  
  public void dfs(node *root){

	if(root!=null){

		vis.put(root,1);

		if(root->left and vis.get(root.left) == 0){
			parent.put(root.left, root);
			dfs(root.left);
		}
		if(root->right and vis.get(root.right) == 0){
			parent.put(root.right, root);
			dfs(root.right);
		}
	}
  
  public void bfs(node *root){
	LinkedList<Node> q=new LinkedList<>();
	q.addLast(root);

	vis = new HashMap<>();

	vis.put(root,1);

	int flag = 0;

	while(q.size()!=0){

		int siz = q.size();

		for(int i=0;i<siz;i++){

			node temp = q.getFirst();
			q.removeFirst();

			if(temp) flag = 1, cout<<temp->data<<" ";

			if(temp!=null && temp.left!=null and vis.get(temp.left)== 0) vis.put(temp.left,1) q.addLast(temp.left);
			if(temp!=null && temp.right!=null and vis.get(temp.right)== 0) vis.put(temp.right,1) q.addLast(temp.right);
			if(temp!=null && vis.get(parent.get(temp))==0) vis.put(parent.get(temp), 1) q.push(parent[temp]);

		}

		if(flag == 1) System.out.println("\n");

		flag = 0;
	}
	return;
}

}
