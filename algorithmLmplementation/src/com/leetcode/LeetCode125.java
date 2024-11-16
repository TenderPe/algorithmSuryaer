package com.leetcode;

import java.util.regex.Pattern;

public class LeetCode125 {
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        char[] str = s.toCharArray();

        while (l < r) {
            char one;
            char two;
            while (l < r && !Character.isLowerCase(str[l]) && !Character.isDigit(str[l]) && !Character.isLetter(str[l])) {
                l++;
            }
            if(Character.isLetter(str[l])) {
                one = Character.toLowerCase(str[l]);
            } else {
                one = str[l];
            }

            while (l < r && !Character.isLowerCase(str[r]) && !Character.isDigit(str[r]) && !Character.isLetter(str[r])) {
                r--;
            }
            if(Character.isLetter(str[r])) {
                two = Character.toLowerCase(str[r]);
            } else {
                two = str[r];
            }
            if (one != two) {
                return false;
            }
            l++;
            r--;

        }
        return true;

    }

    public static void main(String[] args) {
        String s = ".,";
        boolean b = isPalindrome(s);
        System.out.println("dd");

    }
}
