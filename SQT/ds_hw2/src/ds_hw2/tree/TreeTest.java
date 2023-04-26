package ds_hw2.tree;

public class TreeTest {
    public static void main(String[] args){
        System.out.println("Test your trees here!");
    }
    public static void preorder(BinNode a){
            if(a==null) return;
            System.out.println(a);
            preorder(a.left());
            preorder(a.right());
    }
    public static void postorder(BinNode a){
        if(a==null)return;
        postorder(a.left());
        postorder(a.right());
        System.out.println(a.element());
    }
    public static void inorder(BinNode a){
        if(a==null)return;
        inorder(a.left());
        System.out.println(a.element());
        inorder(a.right());
    }
    /* Implements your preorder, inorder and, postorder traversal functions here! */
    
}
