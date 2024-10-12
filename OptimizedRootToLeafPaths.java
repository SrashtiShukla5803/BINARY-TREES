
import java.util.*;

/**
 * 
 *to return all root-to-leaf paths in any order. 
 */

public class OptimizedRootToLeafPaths {
    static class Node{
        int data;
         Node root;
        Node left;
         Node right;
        Node(int data){
            this.data=data;
        }
    }

    public static void helper(Node root, List<String> list, String s){
        if(root == null)return;
        if(root.left==null && root.right==null)
            list.add(s+root.data);
        helper(root.left,list,s+root.data+" ");
        helper(root.right,list,s+root.data+" ");
    }

    public static List<String> binaryPaths(Node root){
        List<String> list = new ArrayList<>();
        helper(root,list,"");
        return list;
}


    static void display(Node root){
        if(root==null) return;
        System.out.print(root.data+"->");
        if(root.left!=null)
            System.out.print(root.left.data+", ");
        else System.out.print("null, ");
        if(root.right!=null) System.out.print(root.right.data);
        else System.out.print("null");
        System.out.println();
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(10);
        Node a=new Node(8);
        Node b=new Node(2);
        root.left=a;
        root.right=b;
        Node c=new Node(3);
        Node d=new Node(5);
        a.left=c;
        a.right=d;
        Node e=new Node(2);
        b.left=e;
        display(root);
        System.out.println("ROOT_to_LEAF PATHS: ");
        System.out.println(binaryPaths(root));
    }
}
