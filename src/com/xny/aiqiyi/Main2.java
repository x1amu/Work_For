package com.xny.aiqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 15:43
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String [] str = s.nextLine().trim().split(" ");
        int [] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i+ arr.length/2]){
                System.out.println(arr[i]);
                break;
            }
        }
        System.out.println("");
    }
}

