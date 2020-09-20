package com.xny.qushi;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/12 20:05
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String [] str = s.nextLine().trim().split(" ");
        char [] inorder = str[0].toCharArray();
        char [] postorder = str[1].toCharArray();
        TreeNode root = buildTree(inorder, postorder);
        List<Character> list = preorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
    public static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char x){
            val = x;
        }
    }
    private static int find(char[] array, int v){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == v){
                return i;
            }
        }
        return -1;
    }
    private static TreeNode buildTree(char [] inorder, char[] postorder){
        if (postorder.length == 0){
            return null;
        }
        char rootValue = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootValue);
        int leftSize = find(inorder, rootValue);
        char [] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        char [] leftPostOrder = Arrays.copyOfRange(postorder, 0, leftSize);
        root.left = buildTree(leftInorder, leftPostOrder);
        char [] rightInorder = Arrays.copyOfRange(inorder, leftSize+1, inorder.length);
        char [] rightPostorder = Arrays.copyOfRange(postorder, leftSize, postorder.length-1);
        root.right = buildTree(rightInorder, rightPostorder);
        return root;
    }
    public static List<Character> preorderTraversal(TreeNode root){
        List<Character> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }
}

