import java.awt.DisplayMode;
import org.w3c.dom.Node;

public class PreInPostTraversal {

    static class Node{

        int data;
        Node root;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static void preorder(Node root)
    //Preorder Traversal-> root left right
    {
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root)
    // Inorder Traversal-> left root right
    {
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void postorder(Node root)
    // Postorder Traversal-> left right root
    {
        if(root==null)return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
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
        Node root=new Node(2);
        Node a = new Node(4);
        root.left=a;
        Node b = new Node(10);
        root.right=b;
        Node c = new Node(6);
        a.left=c;
        Node d = new Node(5);
        a.right=d;
        Node e = new Node(11);
        b.right=e;
        display(root);
        System.out.println("Preorder Traversal: ");
        preorder(root);
        System.out.println();
        System.out.println("Inorder Traversal: ");
        inorder(root);
        System.out.println();
        System.out.println("Postorder Traversal: ");
        postorder(root);
    }
}
