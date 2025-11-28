/**
 * @discription 阿鸠本人所著，未经许可，不得转发，否则追求法律责任
 * @author 阿鸠
 * @date 2025/11/24 19:57
 * @param null
 * @return {@code null}
 **/

package com.itajiu.Factorial;

import java.util.Arrays;

public class Fibonacci {

    public static int fibonacci(int n){
        int[] cache = new int[n+1];
        Arrays.fill(cache, -1);//[-1, -1, -1, -1, -1, -1]
        cache[0] = 0;
        cache[1] = 1;
        return fib(n, cache);
    }

    public static int fib(int n , int[] cache){
        if(cache[n] != -1){
            return cache[n];
        }

        int x = fib(n-1, cache);
        int y = fib(n-2, cache);
        cache[n] = x + y;
        return cache[n];
    }



}
