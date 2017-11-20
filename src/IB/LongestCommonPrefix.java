package IB;

/**
 * Created by joetomjob on 6/8/17.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = {"abcdefgh","aefghijk","abcefgh"};
        l.longestCommonPrefix(strs);
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}


