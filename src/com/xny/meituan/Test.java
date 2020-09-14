package com.xny.meituan;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/12 13:38
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] split = s.nextLine().trim().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, String.valueOf(i));
        }
        for (int i = 0; i < m; i++) {
            String[] sts = s.nextLine().split(" ");
            String order = sts[0];
            int a = Integer.parseInt(sts[1]);
            int b = Integer.parseInt(sts[2]);

            Set<Integer> keys = map.keySet();
            if (order.equals("C")) {
                String string = "";
                for (Integer key : keys) {
                    if (key == a) {
                        string += map.get(key);
                        map.put(key, "");
                    }
                    if (key == b) {
                        map.put(key, string + map.get(key));
                    }
                }
            } else {
                boolean f = false;
                for (Integer key : keys) {
                    String value = map.get(key);
                    if (value.contains(String.valueOf(a)) && value.contains(String.valueOf(b))) {
                        int index1 = value.indexOf(String.valueOf(a));
                        int index2 = value.indexOf(String.valueOf(b));
                        f = true;
                        System.out.println(Math.abs(index2 - index1) - 1);
                        break;
                    }
                }
                if (!f){
                    System.out.println(-1);
                }

            }
        }
    }
}