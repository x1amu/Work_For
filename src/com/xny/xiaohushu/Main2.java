package com.xny.xiaohushu;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/12 10:51
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        String s = "abaccd";
        System.out.println(solution(s));
    }
    public static int solution(String ss) {
        char[] s = ss.toCharArray();
        int [] minP = new int[1000000+1];
        for (int i = 2; i < minP.length; i++) {
            if (minP[i] < 2){
                for (int j = i; j < minP.length; j+=i) {
                    minP[j] = i;
                }
            }
        }
        int [] dp = new int[s.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            dp[i] = i > 0? dp[i-1]+1:1;
            int n = s[i];
            while (n > 1){
                int f = minP[n];
                int minI = i;
                if (map.containsKey(f)){
                    minI = map.get(f);
                }else {
                    map.put(f, minI);
                }
                if (minI == 0){
                    dp[i] = 1;
                }else {
                    if ((dp[minI-1]+1)<dp[i]){
                        dp[i] = dp[minI-1]+1;
                    }
                }
                if (dp[i]<dp[minI]){
                    map.put(f, i);
                }
                n = n/f;
            }
        }
        return dp[s.length-1];
    }
}

