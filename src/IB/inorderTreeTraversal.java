package IB;
import java.util.ArrayList;

class node{
    int val;
    node right;
    node left;

    node(int x){
        val = x;
    }
}
public class inorderTreeTraversal {
    public static void main(String[] args) {
        node a = new node(9);
        node b = new node(8);
        node c = new node(7);
        node d = new node(6);
        node e = new node(10);
        node f = new node(11);
        node g = new node(12);

        a.left = b;
        b.right = c;
        b.left = d;
        a.right = f;
        f.left = e;
        f.right = g;
        inorderTreeTraversal in = new inorderTreeTraversal();
        ArrayList<Integer> res = new ArrayList<>();
        res = in.inorderTraversal(a,res);
        for (Integer x:res) {
            System.out.println(x);
        }
//        node a = new node(9);
//        node a = new node(9);

    }
    public ArrayList<Integer> inorderTraversal(node a,ArrayList<Integer> result) {
        result.add(a.val);
        if(a.left != null){
            inorderTraversal(a.left,result);
        }
        if(a.right != null){
            inorderTraversal(a.right,result);
        }

        return result;
    }
}