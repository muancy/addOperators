package addOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by munanli on 9/18/15.
 * http://www.cnblogs.com/grandyang/p/4814506.html
 */
public class Solution {
    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(num, target, 0, 0, "", res);
        return res;
    }

    public static void helper(String num, int target, long cur, long diff, String tmp, List<String> list) {
        if (num.length() == 0) {
            if (cur == target) {
                list.add(tmp);
            }
            return;
        }
        for (int i = 1; i <= num.length(); i++) {
            String s = num.substring(0, i);
            if (s.length() > 1 && s.charAt(0) == '0') {
                return;
            }
            String next = num.substring(i);

            if (tmp.length() > 0) {
                helper(next, target, cur + Long.valueOf(s), Long.valueOf(s), tmp + "+" + s, list);
                helper(next, target, cur - Long.valueOf(s), -Long.valueOf(s), tmp + "-" + s, list);
                helper(next, target, cur - diff + diff * Long.valueOf(s), diff * Long.valueOf(s), tmp + "*" + s, list);
            } else {
                helper(next, target, Long.valueOf(s), Long.valueOf(s), s, list);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = addOperators("232", 8);
        System.out.println(res);
    }
}
