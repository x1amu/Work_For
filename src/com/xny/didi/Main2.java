package com.xny.didi;

import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 20:19
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        String [] strs = s.nextLine().trim().split(" ");
        int n = Integer.parseInt(strs[0]); //顶点数
        int m = Integer.parseInt(strs[1]); //边数
        int [][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 10000;
            }
        }

        for (int i = 0; i < m; i++) {
            String [] ss = s.nextLine().trim().split(" ");
            int ii = Integer.parseInt(ss[0]);
            int jj = Integer.parseInt(ss[1]);
            int value = Integer.parseInt(ss[2]);
            arr[ii-1][jj-1] = value;
        }
        String [] str = s.nextLine().trim().split(" ");
        int start = Integer.parseInt(str[0]);
        int end = Integer.parseInt(str[1]);
        String time = str[2];
        int mnoth = Integer.parseInt(time.split("\\.")[0]);
        int day = Integer.parseInt(time.split("\\.")[1].split("/")[0]);
        int hour = Integer.parseInt(time.split("\\.")[1].split("/")[1]);
        int[] dis = dijsk(arr);
        int totalTime = dis[end - 1];
        day = day + ((hour + totalTime) / 24);
        hour = (hour + totalTime) % 24;
        mnoth = mnoth + day%30;
        System.out.println(""+mnoth+"."+day+"/"+hour);
    }

    private static int [] dijsk(int[][] edge) {
        int vartex = edge.length;
        int flag = 0;
        int [] mark = new int[vartex];

        mark[0] = 1; //起点
        int [] distance = new int[vartex];
        for (int i = 0; i < vartex; i++) {
            distance[i] = edge[0][i];
        }
        for (int i = 0; i < vartex; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < vartex; j++) {
                if (mark[j] == 0 && distance[j] < min){
                    min = distance[j];
                    flag = j;
                }
            }
            mark[flag] = 1;
            for (int k = 0; k < vartex; k++) {
                if (distance[k] > distance[flag] + edge[flag][k]){
                    distance[k] = distance[flag] + edge[flag][k];
                }
            }
        }
        return distance;
    }
}

