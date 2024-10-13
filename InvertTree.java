/**
 *  Given the root of a binary tree, invert the tree, and return its root.
 */
class InvertTree{

    public static class Node{
        int data;
        Node root;
        Node left;
        Node right;
        Node(){

        }
        Node(int data){
            this.data=data;
        }
    }

    public static Node invertTree(Node root){
        /**
         * Swapping:a=5,b=6,c
         * c=a//c=5
         * a=b //a=6
         * b=c//b=5
         */
        if(root==null || (root.left==null && root.right==null))return root;
        Node temp=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(temp);
        return root;
    }

    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.data+"->");
        if(root.left!=null)System.out.print(root.left.data+", ");
        else System.out.print("null, ");
        if(root.right!=null)System.out.print(root.right.data);
        else System.out.print("null");
        System.out.println();
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
               Node root = new Node(4);
               Node a = new Node(2);
               Node b = new Node(7);
               root.left = a;
               root.right = b;
               Node c = new Node(1);
               Node d = new Node(3);
               a.left = c;
               a.right = d;
               Node e = new Node(6);
               Node f = new Node(9);
               b.left = e;
               b.right = f;
               display(root);
               invertTree(root);
               System.out.println("Tree after Inversion: ");
               display(root);
    }
}