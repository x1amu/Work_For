package com.xny.mihayou;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/19 20:25
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine().trim();
        String p = scan.nextLine().trim();
        System.out.println(isMatch(s,p));
    }

    public static boolean isMatch(String s, String p){
        char [] str = s.toCharArray();
        char [] pstr = p.toCharArray();
        int sLen = str.length;
        int pLen = pstr.length;;
        boolean [][] dp = new boolean[sLen+1][pLen+1];
        dp[sLen][pLen] = true;
        for (int i = sLen; i >= 0; i--) {
            //当i=slen时，即在判断p[j:]是否与空串匹配
            for (int j = pLen-1; j >= 0 ; j--) {
                //判断当前位置的字符是否匹配
                boolean isCurMatch = i < sLen && (str[i] == pstr[j] || pstr[j] == '.');
                if (j+1 < pLen && (pstr[j+1] == '*' || pstr[j+1] == '+')){
                    dp[i][j] = dp[i][j+2] || isCurMatch && dp[i+1][j];
                } else {
                    dp[i][j] = isCurMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}

