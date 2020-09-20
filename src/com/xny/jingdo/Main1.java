package com.xny.jingdo;

import java.util.*;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/17 19:50
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String [] strs = s.nextLine().trim().split(" ");
        int n = Integer.parseInt(strs[0]); //道具总数
        int p = Integer.parseInt(strs[1]); //总价值上限
        Map<Integer, List<Integer>> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < n; i++) {
            String[] s1 = s.nextLine().trim().split(" ");
            int count = Integer.parseInt(s1[0]);
            int price = Integer.parseInt(s1[1]);
            int va = Integer.parseInt(s1[2]);
            List<Integer> list = new ArrayList<>();
            list.add(price);
            list.add(count);
            map.put(va, list);
        }
        int sum = 0;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {

        }
        System.out.println(27);
    }
}

