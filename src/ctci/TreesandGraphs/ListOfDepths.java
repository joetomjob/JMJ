package ctci.TreesandGraphs;

import ctci.LinkedList.List;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by joetomjob on 8/20/19.
 */
public class ListOfDepths {
    static void createLevelListDFS(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;

        LinkedList<TreeNode> list = null;
        if(level == lists.size()) {
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelListDFS(root.left, lists, level+1);
        createLevelListDFS(root.right, lists, level+1);
    }

    static ArrayList<LinkedList<TreeNode>> createLevelListDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelListDFS(root, lists, 0);
        return lists;
    }

    static ArrayList<LinkedList<TreeNode>> createLevelListBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null){
            current.add(root);
        }

        while (current.size() > 0) {
            lists.add(current); // add previous level

            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();

            for (TreeNode a : parents) {
                if(a.left != null) {
                    current.add(a.left);
                }
                if(a.right != null) {
                    current.add(a.right);
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {

    }
}
