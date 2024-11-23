package com.leetcode.LC150;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: Suryaer
 * @CreateTime: 2024-11-23  21:35
 * @Description: TODO
 */
public class Solution12 {
    Map<Integer, Integer> indexMap;
    Map<Integer, Integer> valueMap;
    int size; // map大小  size为最后一个元素的key
    public Solution12() {
        indexMap = new HashMap<>();
        valueMap = new HashMap<>();
        size = 0;
    }

    public boolean insert(int val) {
        if(!valueMap.containsKey(val)) {
            indexMap.put(size, val);
            valueMap.put(val, size);
            size++;
            return true;
        } else {
            return false;
        }

    }

    public boolean remove(int val) {
        if(valueMap.containsKey(val)) {
            int idx = valueMap.get(val);
            int valLast = indexMap.get(size-1);
            valueMap.put(valLast, idx);
            indexMap.put(idx, valLast);
            indexMap.remove(size-1);
            valueMap.remove(val);
            size--;
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {
        Integer k = new Random().nextInt(size);
        return indexMap.get(k);
    }
}
