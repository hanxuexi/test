package yibai;

public class StrStr28 {

    /**
     * 思路是与正确答案是一致的，即：
     *
     * 但是代码却非常啰嗦，繁琐，需要借鉴一下大佬是如何编写代码的！
     * **/
    public static int strStr1(String haystack, String needle) {

        if (needle.length() == 0) return 0;
        int p = 0;
        int q = 0;
        int k = 0;
        int s = 0;
        boolean tag = false;
        while (p < haystack.length() && q < needle.length()) {
            if (tag) {
                if (haystack.charAt(p) != needle.charAt(q)) {
                    q = 0;
                    p = k;
                    tag = false;
                }
                else {
                    p++;
                    q++;
                    s++;
                }
            } else {
                if (haystack.charAt(p) != needle.charAt(q)) {
                    p++;
                }
                else {
                    p++;
                    q++;
                    k = p;
                    s = 1;
                    tag = true;

                }
            }
        }
        return (tag==true && s==needle.length()) ? p-needle.length():-1;
    }
    /**
     * 官方解答
     * 移动 pn 指针，直到 pn 所指向位置的字符与 needle 字符串第一个字符相等。
     * 通过 pn，pL，curr_len 计算匹配长度。
     * 如果完全匹配（即 curr_len == L），返回匹配子串的起始坐标（即 pn - L）。
     * 如果不完全匹配，回溯。使 pn = pn - curr_len + 1， pL = 0， curr_len = 0。
     *
     * **/
    public static int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            // find the position of the first needle character
            // in the haystack string
            while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

            // compute the max match string
            int currLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                ++pn;
                ++pL;
                ++currLen;
            }

            // if the whole needle string is found,
            // return its start position
            if (currLen == L) return pn - L;

            // otherwise, backtrack
            pn = pn - currLen + 1;
        }
        return -1;
    }
    public static void main(String[] args) {

        System.out.println(strStr("mississippi","issipi"));
    }
}
