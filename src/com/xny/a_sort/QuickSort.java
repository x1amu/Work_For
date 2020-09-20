package com.xny.a_sort;

import java.util.Arrays;

/**
 * @ClassName QuickSort 快速排序
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/7 8:56
 * @Version 1.0
 *
 *快排思想：选取一个基准元素，通常为数组的第一个元素。
 *          通过从后向前便来和从前向后遍历，把数组元素和基准元素进行比较，
 *          将数组分成两份，一份比基准元素大，一份比基准元素小，
 *          再利用分治策略从已经分好的两组中分别进行以上步骤，
 *          直到排序完成。
 *          nlogn   坏n^2  最好n   不稳定
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 2, 5, 6, 8};
        quicktSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicktSort(int [] arr, int left, int right){
        if (left >= right){
            return;
        }
        int index = getIndex(arr, left, right);
        quicktSort(arr, left, index - 1);
        quicktSort(arr, index + 1, right);
    }

    /**
     * 划分函数，将数组换分成两份，一份比基准元素小，一份比基准元素大
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int getIndex(int[] arr, int left, int right) {
        int key = arr[left]; //以第一个元素为基准元素
        while (left < right){
            //当右边元素大于基准元素时，向左移动指针
            while (left < right && arr[right] >= key){
                right--;
            }
            //当右边元素小于基准元素时，将右边元素赋值给左边元素
            arr[left] = arr[right];
            //当左边元素小于基准元素时，向右移动指针
            while (left < right && arr[left] <= key){
                left++;
            }
            //当左边元素大于基准元素时，将左边元素赋值给右边元素
            arr[right] = arr[left];
        }
        //循环结束时，left==right，此时left或right就是key索引位置(三个值索引一致)
        //将left或right位置的值改为基准值
        arr[left] = key;
        return left;
    }
}

