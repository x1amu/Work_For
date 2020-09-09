package com.xny.a_sort;

import java.util.Arrays;

/**
 * @ClassName MergeSort 归并排序
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/7 11:17
 * @Version 1.0
 * 基本思想：归并算法应用到分治策略。
 *          把一个大问题分解成易于解决的小问题后一个一个解决，最后再把小问题的一步步合并成总问题的解。
 *          此处应用递归将数组分解成一个一个小数组，直到小数组的数位有序，再把有序的小数组两两合并成有序的大数组。
 */
public class MergeSort {
    public static void main(String[] args) {
        int [] arr = {12,3,4,1,4,6,6};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 递归实现归并排序
     * @param arr
     * @param left
     * @param right
     */
    public static void mergeSort(int [] arr, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 合并两个已排好序的数组
     *
     * i++是先进行表达式运算，再进行自增运算
     * ++i是先进行自增或者自减运算，再进行表达式运算。
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int len = right - left + 1; //合并后数组的长度
        int [] temp = new int[len]; //创建合并后的数组
        int k = 0;
        int i = left; //前一个数组的起始索引
        int j = mid + 1; //后一个数组的起始索引
        while (i <= mid && j <= right){
            //选择较小的存入临时数组
            temp[k++] = arr[i] < arr[j]? arr[i++]:arr[j++];
        }
        while (i <= mid){
            temp[k++] = arr[i++];
        }
        while (j <= right){
            temp[k++] = arr[j++];
        }
        //将合并好的临时数组temp的值赋值给原数组arr
        for (int l = 0; l < len; l++) {
            arr[left++] = temp[l];
        }
    }
}