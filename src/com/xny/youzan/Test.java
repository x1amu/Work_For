package com.xny.youzan;

import java.util.*;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/9 15:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {

    }

    public boolean isValid (String statement) {
        if (statement.length() == 0){
            return true;
        }
        char[] chars = statement.toCharArray();
        List<Character> list = new ArrayList<>();
        list.add('(');
        list.add(')');
        list.add('{');
        list.add('}');
        list.add('[');
        list.add(']');
        String s = "";
        for (char aChar : chars) {
            if (list.contains(aChar)){
                s+=String.valueOf(aChar);
            }
        }
        int n = s.length();
        if (n%2 == 1){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('{', '}');
        map.put('[', ']');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty() || stack.peek() != map.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}