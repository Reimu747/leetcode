/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:05
 * @Description
 * @Version 1.0
 **/
import java.util.*;

public class Solution {
    private static final char ZERO = '0';
    private static final char ONE = '1';
    private static final char TWO = '2';
    private static final char THREE = '3';
    private static final char FOUR = '4';
    private static final char FIVE = '5';
    private static final char SIX = '6';
    private static final char SEVEN = '7';
    private static final char EIGHT = '8';
    private static final char NINE = '9';

    private static final int NUM_ZERO = 0;
    private static final int NUM_ONE = 1;
    private static final int NUM_TWO = 2;
    private static final int NUM_THREE = 3;
    private static final int NUM_FOUR = 4;

    public int openLock(String[] deadends, String target) {
        String ori = "0000";
        LinkedList<String> queue = new LinkedList<>();
        Set<String> hasChecked = new HashSet<>();
        queue.add(ori);
        hasChecked.add(ori);
        hasChecked.addAll(Arrays.asList(deadends));
        int res = 0;

        for (String s : deadends) {
            if ("0000".equals(s)) {
                return -1;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0;i < size;i++) {
                if (queue.element().equals(target)) {
                    return res;
                }
                List<String> nextNodes = nextNodes(queue.element());
                for (String s : nextNodes) {
                    if (!hasChecked.contains(s)) {
                        queue.add(s);
                        hasChecked.add(s);
                    }
                }
                queue.remove();
            }

            res++;
        }

        return -1;
    }

    private List<String> nextNodes(String ori) {
        List<String> res = new ArrayList<>();
        if (ori.charAt(NUM_ZERO) == ZERO) {
            res.add(String.valueOf(Integer.parseInt(ori) + 1000));
            res.add(String.valueOf(Integer.parseInt(ori) + 9000));
        }
        else if (ori.charAt(NUM_ZERO) == NINE) {
            res.add(String.valueOf(Integer.parseInt(ori) - 1000));
            res.add(String.valueOf(Integer.parseInt(ori) - 9000));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 1000));
            res.add(String.valueOf(Integer.parseInt(ori) + 1000));
        }

        if (ori.charAt(NUM_ONE) == ZERO) {
            res.add(String.valueOf(Integer.parseInt(ori) + 100));
            res.add(String.valueOf(Integer.parseInt(ori) + 900));
        }
        else if (ori.charAt(NUM_ONE) == NINE) {
            res.add(String.valueOf(Integer.parseInt(ori) - 100));
            res.add(String.valueOf(Integer.parseInt(ori) - 900));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 100));
            res.add(String.valueOf(Integer.parseInt(ori) + 100));
        }

        if (ori.charAt(NUM_TWO) == ZERO) {
            res.add(String.valueOf(Integer.parseInt(ori) + 10));
            res.add(String.valueOf(Integer.parseInt(ori) + 90));
        }
        else if (ori.charAt(NUM_TWO) == NINE) {
            res.add(String.valueOf(Integer.parseInt(ori) - 10));
            res.add(String.valueOf(Integer.parseInt(ori) - 90));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 10));
            res.add(String.valueOf(Integer.parseInt(ori) + 10));
        }

        if (ori.charAt(NUM_THREE) == ZERO) {
            res.add(String.valueOf(Integer.parseInt(ori) + 1));
            res.add(String.valueOf(Integer.parseInt(ori) + 9));
        }
        else if (ori.charAt(NUM_THREE) == NINE) {
            res.add(String.valueOf(Integer.parseInt(ori) - 1));
            res.add(String.valueOf(Integer.parseInt(ori) - 9));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 1));
            res.add(String.valueOf(Integer.parseInt(ori) + 1));
        }

        for (int i = 0;i < res.size();i++) {
            String temp = "";
            for (int j = 0;j < NUM_FOUR - res.get(i).length();j++) {
                temp += "0";
            }
            res.set(i, temp + res.get(i));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nextNodes("8092"));

        Set<String> hasChecked = new HashSet<>();
        hasChecked.add("8192");
        hasChecked.add("8002");

        System.out.println(s.nextNodes("8092"));
        System.out.println(s.nextNodes("0000"));

        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(s.openLock(deadends, target));
    }
}
