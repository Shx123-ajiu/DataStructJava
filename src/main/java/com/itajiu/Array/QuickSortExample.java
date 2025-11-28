/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/


package com.itajiu.Array;

public class QuickSortExample {

    // 快速排序主函数
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // 获取基准元素的位置
            quickSort(arr, left, pivotIndex - 1);          // 对左半部分排序
            quickSort(arr, pivotIndex + 1, right);         // 对右半部分排序
        }
    }

    // 分区函数：将小于 pivot 的放左边，大于 pivot 的放右边（以左边为枢轴）
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];  // 选最左侧元素为基准
        int i = left;           // i 指向小于等于 pivot 区域的末尾

        for (int j = left + 1; j <= right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // 将 pivot 放到正确位置
        swap(arr, left, i);
        return i;
    }

    // 交换元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试快速排序
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后的结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
