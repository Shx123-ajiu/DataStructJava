/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Array;

public class QuickSortImproved {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        // 选择中点作为基准值
        int pivot = arr[left + (right - left) / 2]; //计算的是在当前处理区间 [left, right] 内的中点位置
        int i = left - 1, j = right + 1;

        while (i < j) {
            // 从左边找到第一个大于等于pivot的元素
            do {
                i++;
            } while (arr[i] < pivot);
            // 从右边找到第一个小于等于pivot的元素
            do {
                j--;
            } while (arr[j] > pivot);
            // 如果两个指针未相遇，则交换元素
            if (i < j) {
                swap(arr, i, j);
            }
        }

        // 递归排序左右两部分
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }

    // 交换元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 改进的快速排序
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
