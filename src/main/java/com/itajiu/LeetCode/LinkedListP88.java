/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.LeetCode;

public class LinkedListP88 {
    //合并两个有序数组
    //方法1 递归
    public static void merge1(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2, int k) {
        if (a1[i] < a2[j]) {
            a2[k] = a1[i];
            merge1(a1, i + 1, iEnd, j, jEnd, a2, k + 1);
        } else {
            a2[k] = a1[j];
            merge1(a1, i, iEnd, j + 1, jEnd, a2, k + 1);
        }
        if (i > iEnd) {
            while (j <= jEnd) {
                a1[k++] = a2[j++];
            }
        } else {
            while (i <= iEnd) {
                a1[k++] = a1[i++];
            }
        }
    }

    //方法2
    public static void merge2(int[] a1, int i, int iEnd, int j, int jEnd, int[] a2) {
        int k = 0;
        while (i <= iEnd && j <= jEnd) {
            if (a1[i] < a2[j]) {
                a2[k] = a1[i];
                i++;
                k++;
            } else {
                a2[k] = a2[j];
                j++;
                k++;
            }
        }
        //if(i > iEnd)    System.arraycopy(a1, i, a2, k, iEnd - i + 1);
        //2选1
        while (i <= iEnd) {
            a2[k] = a1[i];
            i++;
            k++;
        }
        //if (j <= jEnd)     System.arraycopy(a2, j, a2, k, jEnd - j + 1);
        //2选1
        while (j <= jEnd) {
            a2[k] = a2[j];
            j++;
            k++;
        }
    }
}
