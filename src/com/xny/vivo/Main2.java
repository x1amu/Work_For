package com.xny.vivo;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/12 20:31
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine().trim();
        boolean b = validP(str);
        if (!b){
            System.out.println("false");
        }
    }
    public static boolean validP(String s){
        if (s == null){
            System.out.println("");
            return true;
        }
        if (s.length() == 1){
            System.out.println(s);
            return true;
        }
        if (s.length() == 2){
            System.out.println(s.substring(1));
            return true;
        }
        char [] ch = s.toCharArray();

        int i = 0;
        int j = ch.length-1;
        while (i<j){
            if (ch[i] != ch[j]){
                return isP(ch, i+1, j) || isP(ch, i, j-1);
            }
            i++;
            j--;
        }
        System.out.println(s.substring(0,i)+s.substring(i+1, -1));
        return true;
    }
    public static boolean isP(char [] ch, int begin, int end){
        while (begin < end) {
            if (ch[begin] != ch[end]) {
                return false;
            } else {
                begin++;
                end--;
            }
        }
        String str = "";
        for (int i = 0; i < ch.length; i++) {
            if (i != begin){
                str+=String.valueOf(ch[i]);
            }
        }
        System.out.println(str);
        return true;
    }
}
