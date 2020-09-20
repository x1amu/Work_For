package com.xny.aiqiyi;

import java.util.*;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 16:11
 * @Version 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String [] str = s.nextLine().trim().split(" ");
        int [] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < len-2; i++) {
            for (int j = i+1; j < len-1; j++) {
                for (int k = j+1; k < len; k++) {
                    if (nums[i]+nums[j]+nums[k] != 0){
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    if (lists.indexOf(list) < 0){
                        lists.add(list);
                    }
                }
            }
        }
        for (List<Integer> list : lists) {
            for (Integer n : list) {
                System.out.print(n + " ");
            }
            System.out.println("\n");
        }
    }
}
