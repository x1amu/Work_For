package com.xny.xiaohushu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main3
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/12 11:14
 * @Version 1.0
 */
public class Main3 {

    static int count = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            list.add(aChar);
        }
        if (s.length() == 0){
            System.out.println(0);
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        getSubList(list);
        return count;
    }

    public static void getSubList(List<Character> list){
        if (list.size() <= 1){
            return;
        }
        count+=1;
        char i0 = list.get(0);
        char in1 = list.get(list.size()-1);
        if (i0 == in1){
            return;
        }
        int i = list.lastIndexOf(i0);
        if (i == list.size() -1){
            return;
        }
        List<Character> list1 = list.subList(i + 1, list.size() - 1);
        getSubList(list1);
    }
}

