/**
 * @ClassName Solution
 * @Author Reimu747
 * @Date 2019/4/6 1:05
 * @Description
 * @Version 1.0
 **/
import java.util.*;

public class Solution {
    public int openLock(String[] deadends, String target) {
        String ori = "0000";
        LinkedList<String> queue = new LinkedList<>();
        Set<String> hasChecked = new HashSet<>();
        queue.add(ori);
        hasChecked.add(ori);
        hasChecked.addAll(Arrays.asList(deadends));
        int res = 0;

        for (String s : deadends) {
            if (target.equals(s)) {
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
        if (ori.charAt(0) == '0') {
            res.add(String.valueOf(Integer.parseInt(ori) + 1000));
            res.add(String.valueOf(Integer.parseInt(ori) + 9000));
        }
        else if (ori.charAt(0) == '9') {
            res.add(String.valueOf(Integer.parseInt(ori) - 1000));
            res.add(String.valueOf(Integer.parseInt(ori) - 9000));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 1000));
            res.add(String.valueOf(Integer.parseInt(ori) + 1000));
        }

        if (ori.charAt(1) == '0') {
            res.add(String.valueOf(Integer.parseInt(ori) + 100));
            res.add(String.valueOf(Integer.parseInt(ori) + 900));
        }
        else if (ori.charAt(1) == '9') {
            res.add(String.valueOf(Integer.parseInt(ori) - 100));
            res.add(String.valueOf(Integer.parseInt(ori) - 900));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 100));
            res.add(String.valueOf(Integer.parseInt(ori) + 100));
        }

        if (ori.charAt(2) == '0') {
            res.add(String.valueOf(Integer.parseInt(ori) + 10));
            res.add(String.valueOf(Integer.parseInt(ori) + 90));
        }
        else if (ori.charAt(2) == '9') {
            res.add(String.valueOf(Integer.parseInt(ori) - 10));
            res.add(String.valueOf(Integer.parseInt(ori) - 90));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 10));
            res.add(String.valueOf(Integer.parseInt(ori) + 10));
        }

        if (ori.charAt(3) == '0') {
            res.add(String.valueOf(Integer.parseInt(ori) + 1));
            res.add(String.valueOf(Integer.parseInt(ori) + 9));
        }
        else if (ori.charAt(3) == '9') {
            res.add(String.valueOf(Integer.parseInt(ori) - 1));
            res.add(String.valueOf(Integer.parseInt(ori) - 9));
        }
        else {
            res.add(String.valueOf(Integer.parseInt(ori) - 1));
            res.add(String.valueOf(Integer.parseInt(ori) + 1));
        }

        for (int i = 0;i < res.size();i++) {
            String temp = "";
            for (int j = 0;j < 4 - res.get(i).length();j++) {
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
