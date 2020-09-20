package com.xny.meituan;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 9:57
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println(getCount(arr, arr.length, m, k));
    }
    public static int getCount(int [] arr, int n,int m ,int k){
        int c = 0;
        int [] dp = new int[n];
        dp[0] = arr[0] >= k? 1:0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = arr[i]>=k?1+dp[i-1]:0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (dp[i] >= m){
                c++;
            }
        }
        return c;
    }
}

