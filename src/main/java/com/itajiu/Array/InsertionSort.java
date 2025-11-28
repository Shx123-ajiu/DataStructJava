/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Array;

public class InsertionSort {

    public static void sort(int[] a){
        insertion(a, 1);  // 从第二个元素开始排序
    }

    private static void insertion(int[] a, int low){
        if(low == a.length){
            return;
        }

        int key = a[low];        // 待插入的元素
        int j = low - 1;         // 已排序区的最后一个元素索引

        while(j >= 0 && a[j] > key){  // 向前查找插入位置
            a[j + 1] = a[j];          // 元素向后移动
            j--;                      // 继续向前查找
        }

        // 找到插入位置
        if(j + 1 != low){
            a[j + 1] = key;
        }

        insertion(a, low + 1);
    }
}
