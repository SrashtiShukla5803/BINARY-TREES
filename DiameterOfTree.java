

/**
 * To print its diameter: 
 The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.The length of a path between two nodes is 
represented by the number of edges between them.
*
 */

public class DiameterOfTree {

    static class Node{
        int data;
        Node root;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }


    public static int height(Node root){
        if(root==null || (root.left==null && root.right==null))return 0;
        return 1+Math.max(height(root.left),height(root.right));

    }

    public static int diameter(Node root)

    {
        if(root==null || (root.left==null && root.right==null))return 0;
        int leftAns=diameter(root.left);
        int rightAns=diameter(root.right);
        int mid= height(root.left)+height(root.right);
        if(root.left!=null)mid++;
        if(root.right!=null)mid++;
        return Math.max(leftAns,Math.max(rightAns,mid));
    }

    public static void display(Node root) {
        if(root==null)return;
        System.out.print(root.data+"->");
        if(root.left!=null)
        System.out.print(root.left.data+", ");
        else
        System.out.print("null, ");
        if(root.right!=null)
        System.out.print(root.right.data);
        else System.out.print("null");
        System.out.println();
        display(root.left);
        display(root.right);
    }

   public static void main(String[] args) {
    Node root=new Node(1);
    Node a=new Node(2);
    Node b=new Node(3);
    root.left=a;
    root.right=b;
    Node c=new Node(4);
    Node d=new Node(5);
    a.left=c;
    a.right=d;
    display(root);
    System.out.println("Diameter of the Tree is: "+ diameter(root));

    
   }
}

