package com.xny.meituan;

import java.util.*;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 9:57
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] s = scan.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String [] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scan.nextLine();
        }
        int number = n;
        int a = 0;
        int b = 0;
        while (number >= 1 && number%2 == 0){
            a = number/2;
            b = a-1;
            if (strs[a].equals(strs[b])){
                number/=2;
            }else {
                break;
            }
        }
        for (int i = 0; i < number; i++) {
            System.out.println(strs[i]);
        }
    }
}

