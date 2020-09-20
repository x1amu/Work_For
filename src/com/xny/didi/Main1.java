package com.xny.didi;

import java.util.*;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 16:53
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine()); //数据组数
        for (int i = 0; i < T; i++) {
            String [] strings = scanner.nextLine().trim().split(" ");
            int n = Integer.parseInt(strings[0]); //岛数量
            int m = Integer.parseInt(strings[1]); //桥的条数
            int k = Integer.parseInt(strings[2]); //每条桥的成本
            List<String> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                String  s = scanner.nextLine().trim();
                list.add(s);
            }
//            System.out.println(list.size());
            boolean f = getTF(list, n, k);
            if (!f){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }

    private static boolean getTF(List<String> list, int n, int k) {
        boolean flag = true;
        for (String s : list) {
            if (Integer.parseInt(s.split(" ")[2]) > k) {
                flag = false;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
//        System.out.println(list.size());
        for (String s : list) {
            String[] s1 = s.split(" ");
            int num1 = Integer.parseInt(s1[0]);
            int num2 = Integer.parseInt(s1[1]);
            if (map.containsKey(num1)) {
                map.put(num1, map.get(num1) + 1);
            } else {
                map.put(num1, 1);
            }
            if (map.containsKey(num2)) {
                map.put(num2, map.get(num2) + 1);
            } else {
                map.put(num2, 1);
            }
        }
        Set<Integer> keys = map.keySet();
//        System.out.println(keys.size());
        int count = 0;
        for (Integer key : keys) {
//            System.out.println(map.get(key));
            count+=1;
            if (map.get(key) != 2) {
                flag = false;
//                System.out.println(11111);
            }
        }
//        System.out.println(count);
        if (count < n){
            flag = false;
        }
        return flag;
    }
}