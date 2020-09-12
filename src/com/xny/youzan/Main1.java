package com.xny.youzan;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/11 15:39
 * @Version 1.0
 */
class Solution extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    Solution s = null;

    public int[] LRU (int[][] operators, int k) {
        s = new Solution(k);
        List<Integer> list = new ArrayList<>();
        for (int[] operator : operators) {
            for (int i : operator) {
                Integer put = s.put(i, i);
                list.add(put);
            }
        }
        int [] res = new  int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public Solution(int capacity){
        super(capacity, 0.75F, true);
    }

    public int get(int key){
        return super.getOrDefault(key, -1);
    }

    public void set(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

