
import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {

   

/**
 * To return all root-to-leaf paths in any order. (BRUTE FORCE APPROACH:)  )
 */


 static class Node{
     int data;
     Node root;
     Node left;
     Node right;
      Node(int data){
          this.data=data;
      }
 }

 public static void rootToLeaf(Node root,String s)
 {

     List<String> list=new ArrayList<>();
     if(root == null)return;
     s+=root.data+" ";
     if(root.left==null && root.right==null) {
         list.add(s);
     }
     rootToLeaf(root.left,s);
     rootToLeaf(root.right,s);
     for(int i=0;i<list.size();i++){
         if(list.get(i)!="")
             System.out.println(list);
     }
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
        rootToLeaf(root,"");
    }
}

