/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Array;

public class MergeSort {

    // 归并排序主方法
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // 数组为空或只有一个元素时无需排序
        }
        // 创建临时数组用于合并操作，避免重复创建
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
    }

    // 递归拆分数组
    private static void sort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = left + (right - left) / 2; // 计算中间索引，避免溢出
            sort(array, left, mid, temp); // 左半部分排序
            sort(array, mid + 1, right, temp); // 右半部分排序
            merge(array, left, mid, right, temp); // 合并两部分
        }
    }

    // 合并两个有序子数组
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left; // 左子数组起始索引
        int j = mid + 1; // 右子数组起始索引
        int t = 0; // 临时数组的当前索引

        // 比较两个子数组元素，将较小的放入临时数组
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }

        // 将左子数组剩余元素放入临时数组
        while (i <= mid) {
            temp[t++] = array[i++];
        }

        // 将右子数组剩余元素放入临时数组
        while (j <= right) {
            temp[t++] = array[j++];
        }

        // 将临时数组中的元素复制回原数组
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }

    // 测试方法
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("排序前的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        mergeSort(array);

        System.out.println("\n排序后的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}