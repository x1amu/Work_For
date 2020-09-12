package com.xny.xiaohushu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/12 10:21
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        int [] arr = new int[]{4,32,34,11,22,33,5,15,16,17,18};
        System.out.println(findMin(arr));
    }
    public static int findMin(int [] tree){
//        int max = tree[0];
//        for (int i = 0; i < tree.length; i++) {
//            if (max < tree[i]){
//                max = tree[i];
//            }
//        }
        List<Integer> list = new ArrayList<>();
        for (int i : tree) {
            list.add(i);
        }
        int max = Collections.max(list);
        for (int i = 1; i < max; i++) {
            if (!list.contains(i)){
                return i;
            }
        }
        return 0;
    }
}

