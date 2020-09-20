package com.xny.meituan;

import com.sun.tracing.dtrace.ArgsAttributes;

import java.util.*;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 10:49
 * @Version 1.0
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int d = s.nextInt();
        List<List<Integer>> lists = combinationSum(n,k,d);
        System.out.println(lists.size());
    }

    private static List<List<Integer>> combinationSum(int n, int k, int d) {
        List<List<Integer>> lists = new ArrayList<>();
        backTrak(n,k,d,lists,1,new ArrayList<>());
        return lists;
    }

    private static void backTrak(int n, int k, int d, List<List<Integer>> lists, int i, ArrayList<Integer> list) {
        if (n < 0){
            return;
        }
        if (n == 0){
            int max = 0;
            for (Integer num : list) {
                max = Math.max(max, num);
            }
            if (max<d){
                return;
            }
            lists.add(new ArrayList<>());
            return;
        }
        for (int j=1;j<=k;j++){
            list.add(j);
            backTrak(n-j, k, d, lists, j, list);
            list.remove(list.size()-1);
        }
    }
}

