package com.xny.meituan;

import java.util.*;

/**
 * @ClassName Main0
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/13 11:11
 * @Version 1.0
 */
public class Main0 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        /*Map<Integer, List<Integer>> map = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
        );*/
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            String [] strs = s.nextLine().trim().split(" ");
            list.add(Integer.parseInt(strs[0]));
            list1.add(Integer.parseInt(strs[0]));
            list.add(Integer.parseInt(strs[1]));
            list2.add(Integer.parseInt(strs[1]));
            map.put(i, list);
        }
//        Set<Integer> keys = map.keySet();
//        for (Integer key : keys) {
//            System.out.print(key+"\n");
//        }
        Collections.sort(list1);
        Collections.sort(list2);
        List<Integer> rest = new ArrayList<>();
        Set<Integer> keyss = map.keySet();
        for (Integer k : keyss) {
            List<Integer> list = map.get(k);
            int v1 = list.get(0);
            int v2 = list.get(1);
            rest.add(list2.indexOf(v2)+1);
        }
        for (Integer ks : rest) {
            System.out.print(ks+" ");
        }
    }
}

