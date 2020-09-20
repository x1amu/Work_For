package com.xny.jingdo;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/17 20:19
 * @Version 1.0
 */
public class Main2 {
    static char [][] mp = new char[101][101];
    static boolean [][][] vis = new boolean[101][101][2];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s2 = s.nextLine().trim();
        int T = Integer.parseInt(s2); //数据的组数
        if (T <= 0){
            return;
        }
        for (int i1 = 0; i1 < T; i1++) {
            String [] sts = s.nextLine().trim().split(" ");
            int n = Integer.parseInt(sts[0]); //行
            int m = Integer.parseInt(sts[1]); //列
            if (n <= 0 || m <= 0){
                continue;
            }
            Character [][] arr = new Character[n][m];
            for (int j = 0; j < arr.length; j++) {
                String str = s.nextLine().trim();
                for (int k = 0; k < arr[j].length; k++) {
                    char c = str.charAt(k);
                    arr[j][k] = c;
                }
            }
            int x = 0;
            int y = 0;
            boolean ans = false;
            for (int i = 0; i < n; i++) { //走到王子起始位置
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 'S'){
                        x = i;
                        y = j;
                    }
                }
            }
            dfs(x,y,0, n, m);
            for (int i = 0; i < n; i++) { //走到公主的位置
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 'E'){
                        x = i;
                        y = j;
                    }
                }
            }
            dfs(x, y, 1 ,n ,m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (vis[i][j][0] || vis[i][j][1]){
                        ans = true;
                    }
                }
            }
            if (ans){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void dfs(int x, int y, int d, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y][d] || mp[x][y] == '#'){
            return;
        }
        vis[x][y][d] = true;
        dfs(x-(2-d), y, d, n, m);
        dfs(x+(2-d), y, d, n, m);
        dfs(x, y-(2-d), d, n, m);
        dfs(x, y+(2-d), d, n, m);
    }
}

