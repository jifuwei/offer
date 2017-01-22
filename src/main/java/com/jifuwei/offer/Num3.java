package com.jifuwei.offer;

/**
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
 * Created by JFW on 2017/1/21.
 */
public class Num3 {

    public static int change(char[] nowString, int usedLength) {
        if (nowString == null || nowString.length < usedLength) {
            return -1;
        }

        int blankSpaceCount = 0;
        for (char s : nowString) {
            if (s == ' ') {
                blankSpaceCount++;
            }
        }

        if (blankSpaceCount == 0) {//无空白字符
            return usedLength;
        }

        int changeStringLength = blankSpaceCount * 2 + usedLength;
        int temp = changeStringLength;
        if (changeStringLength > nowString.length) {//超出原始字符串范围
            return -1;
        }

        usedLength--; // 从后向前，第一个开始处理的字符
        changeStringLength--; // 处理后的字符放置的位置

        while (usedLength >= 0 && usedLength < changeStringLength) {
            //如果是空格则替换
            if (nowString[usedLength] == ' ') {
                nowString[changeStringLength--] = '0';
                nowString[changeStringLength--] = '2';
                nowString[changeStringLength--] = '%';
            } else {
                nowString[changeStringLength--] = nowString[usedLength];
            }
            usedLength--;
        }
        return temp;
    }

    public static void main(String[] args) {
        char[] string = new char[50];
        string[0] = ' ';
        string[1] = 'e';
        string[2] = ' ';
        string[3] = ' ';
        string[4] = 'r';
        string[5] = 'e';
        string[6] = ' ';
        string[7] = ' ';
        string[8] = 'a';
        string[9] = ' ';
        string[10] = 'p';
        string[11] = ' ';

        int length = change(string, 12);
        System.out.println(new String(string, 0, length));
    }
}
