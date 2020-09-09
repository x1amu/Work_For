package com.xny.yuanjing;

import java.util.*;

/**
 * @ClassName Main1
 * @Description TODO
 * @Author Xnymph
 * @Date 2020/9/9 14:55
 * @Version 1.0
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] chars = s.nextLine().trim().toCharArray();
        String result = "";
        List<Character> list = new ArrayList<>();
        list.add('{');
        list.add('}');
        list.add('[');
        list.add(']');
        list.add('(');
        list.add(')');
        for (int i = 0; i < chars.length; i++) {
            if (list.contains(chars[i])){
                result+=String.valueOf(chars[i]);
            }
        }
        /*if (result.length() == 0){
            System.out.println("flase");
            return;
        }*/
        System.out.println(isValid(result));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

