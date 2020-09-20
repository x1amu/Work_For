package com.xny.aiqiyi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 15:38
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().trim();
//        System.out.println(str);
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int tem = 0;
        for (int j = 0; j < str.length(); j++) {
            int i = map.getOrDefault(str.charAt(j), -1);
            map.put(str.charAt(j), j);
            tem = tem < j - i ? tem + 1 : j - i;
            res = Math.max(res, tem);
        }
        System.out.println(res);
    }
}

