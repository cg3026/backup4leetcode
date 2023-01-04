package medium;

import medium.TreeNode;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Offer_26 {

//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (A==null || B==null){
//            return false;
//        }
//        Queue<TreeNode> queue = new LinkedList();
//        TreeNode loop = A;
//        queue.add(loop);
//        while(!queue.isEmpty()){
//            loop = queue.poll();
//            queue.add(loop.left);
//            queue.add(loop.right);
//            if (loop.val==B.val){
//                String tree_st = getString(loop);
//                String subtree_st = getString(B);
//                if (tree_st.contains(subtree_st)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public String getString(TreeNode tree){
//        StringBuilder sb = new StringBuilder();
//        Queue<TreeNode> queue = new LinkedList();
//        TreeNode loop = tree;
//        queue.add(loop);
//        while(!queue.isEmpty()){
//            loop = queue.poll();
//            sb.append(loop.val);
//            if (loop.left!=null){
//                queue.add(loop.left);
//            }
//            if (loop.right!=null){
//                queue.add(loop.right);
//            }
//        }
//        return sb.toString();
//    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static void main(String[] args) {
        Offer_26 o26 = new Offer_26();
        int[] A = new int[]{3,4,5,1,2};
        int[] B = new int[]{3,4,5};
        TreeInit ti = new TreeInit();
        TreeNode tree = ti.TreeInit(A);
        TreeNode subtree = ti.TreeInit(B);
        System.out.println(o26.isSubStructure(tree, subtree));
    }
}
