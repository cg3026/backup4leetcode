package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer_32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ressult = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(ressult.size() % 2 == 0) {
                    assert node != null;
                    tmp.addLast(node.val); // 偶数层 -> 队列头部
                }
                else {
                    assert node != null;
                    tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ressult.add(tmp);
        }
        return ressult;
    }

    public static void main(String[] args) {
        Offer_32_3 o323 = new Offer_32_3();
        int[] tree = new int[]{3,9,20,-1,-1,15,7};
        TreeInit treeInit = new TreeInit();
        TreeNode head = treeInit.TreeInit(tree);
        System.out.println(o323.levelOrder(head).toString());

    }
}
