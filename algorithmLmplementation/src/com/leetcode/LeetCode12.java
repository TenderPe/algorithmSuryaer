package com.leetcode;

public class LeetCode12 {
    public static String intToRoman(int num) {
        String[][] sarr = new String[][]{
                {"", "I", "II", "III", "IV", "V","VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L","LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D","DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"},
        };

        return sarr[3][num / 1000] + sarr[2][num % 1000 / 100] + sarr[1][num % 100 / 10] + sarr[0][num % 10];
    }

    public static void main(String[] args) {
        int num = 765;
        System.out.println(intToRoman(num));
    }
}
