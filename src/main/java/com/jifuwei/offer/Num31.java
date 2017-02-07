package com.jifuwei.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 * Created by JFW on 2017/2/6.
 */
public class Num31 {
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length <= 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] str = new String[numbers.length];
        int index = 0;
        for(int i : numbers) str[index++] = i + "";
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = new Num31().PrintMinNumber(new int[]{3,32,321});
        System.out.println(s);
    }
}
