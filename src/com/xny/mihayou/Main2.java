package com.xny.mihayou;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/19 20:51
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] sts = scanner.nextLine().trim().split(" ");
        int M = Integer.parseInt(sts[0]);
        int N = Integer.parseInt(sts[1]);
        int flag = 0;
        int num1 = 0;
        int num2 = 1;
        int i = 0;
        int j = 0;
        char str = 'A';
        char [][] arr = new char[31][31];
        arr[0][0] = str;
        while (flag < M*N - 1){
            switch (num2%4){
                case 1:
                    ++j;
                    if (j == N - num1 - 1){
                        num2++;
                    }
                    break;
                case 2:
                    ++i;
                    if (i == M - num1 - 1){
                        num2++;
                    }
                    break;
                case 3:
                    --j;
                    if (j == num1){
                        num2++;
                    }
                    break;
                case 0:
                    --i;
                    if (i == num1 + 1){
                        num2++;
                        num1++;
                    }
                    break;
            }
            if (++str == 'Z' + 1){
                str = 'A';
            }
            arr[i][j] = str;
            flag++;
        }
        for (int k = 0; k < M; k++) {
            for (int l = 0; l < N; l++) {
                System.out.print(arr[k][l] + " ");
            }
            System.out.println();
        }
    }
}

