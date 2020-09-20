package com.xny.ali;

import java.util.Scanner;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/15 19:01
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] s1 = s.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        String str = s.nextLine().trim();
        if (k == 0){
            System.out.println(str);
            return;
        }
        if (n == 0){
            System.out.println("");
            return;
        }
        for (int i = 0; i < k; i++) {
            str = getSubString(str);
        }
        System.out.println(str);
//        String result = getSubString(str);
    }

    private static String getSubString(String str) {
        if (str.equals("0")){
            return "0";
        }
        if (str.equals("1")){
            return "0";
        }
        if (!(str.contains("0")&&str.contains("1"))){
            return str;
        }
        String s = "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String ss = "";
            if (chars[i] == '0'){
                ss = "1";
            } else if (chars[i] == '1'){
                ss = "0";
            } else {
                ss = String.valueOf(chars[i]);
            }
            s+=ss;
        }
//        System.out.println(s);
//        String s = str.replaceAll("01", "10");
        while (true){
            if (String.valueOf(s.toCharArray()[0]).equals("0")){
                s = s.substring(1);
                if (s.length() == 1){
                    break;
                }
                continue;
            }
            break;
        }
        return s;
    }
}