package com.xny.qushi;

import java.util.*;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/12 19:43
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String num = s.nextLine();
        int k = Integer.parseInt(s.nextLine().trim()); //要删除的位数
        System.out.println(getSub(num,k));
    }
    public static String getSub(String s, int k){
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()){
            while (!list.isEmpty() && list.peekLast() > c && k > 0){
                list.removeLast();
                k--;
            }
            list.addLast(c);
        }
        while (k > 0){
            list.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean hz = true;
        for (char c : list) {
            if (c == '0' && hz){
                continue;
            }
            sb.append(c);
            hz = false;
        }
        return sb.toString().equals("")? "0" : sb.toString();
    }
}

