package cycle4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    BSTNode root;

    public BST(String s){
        String[] numStrings = s.split(" ");
        int[] nums = Arrays.stream(numStrings).mapToInt(Integer::parseInt).toArray();

        root = new BSTNode(nums[0]);

        for(int i: nums){
            root.addData(i);
        }
    }

    public String preOrder(){
        StringBuilder sb = new StringBuilder();
        root.preOrder(sb);
        return sb.toString().strip();
    }
    public String postOrder(){
        StringBuilder sb = new StringBuilder();
        root.postOrder(sb);
        return sb.toString().strip();
    }
    public String inOrder(){
        StringBuilder sb = new StringBuilder();
        root.inOrder(sb);
        return sb.toString().strip();
    }
    public String levelOrder(){
        StringBuilder sb = new StringBuilder();

        Queue<BSTNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BSTNode n = q.poll();
            sb.append(n.data).append(" ");

            if(n.left != null){
                q.add(n.left);
            }
            if(n.right != null){
                q.add(n.right);
            }
        }
        return sb.toString().strip();
    }



    private static final class BSTNode {
        BSTNode left, right;
        int data;

        public BSTNode(int data) {
            this.data = data;
        }

        public void addData(int s){

            if(s < data){
                if(left != null){
                    left.addData(s);
                }else{
                    left = new BSTNode(s);
                }
            }
            if(s > data){
                if(right != null){
                    right.addData(s);
                }else{
                    right = new BSTNode(s);
                }
            }

        }

        public void preOrder(StringBuilder sb){

            sb.append(data).append(" ");
            if(left != null){
                left.preOrder(sb);
            }
            if(right != null){
                right.preOrder(sb);
            }
        }
        public void postOrder(StringBuilder sb){
            if(left != null){
                left.postOrder(sb);
            }
            if(right != null){
                right.postOrder(sb);
            }
            sb.append(data).append(" ");
        }
        public void inOrder(StringBuilder sb){

            if(left != null){
                left.inOrder(sb);
            }
            sb.append(data).append(" ");
            if(right != null){
                right.inOrder(sb);
            }
        }


    }
}
