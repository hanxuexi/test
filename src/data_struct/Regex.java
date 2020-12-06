package data_struct;

public class Regex {

    private boolean matched = false;
    private char[] pattern; // 正则表达式
    private int plen; // 正在表达式的长度

    public Regex(char[] pattern, int plen) {
        this.pattern = pattern;
        this.plen = plen;
    }

    public boolean match(char[] text, int tlen) { // 文本串及长度
        matched = false;
        rmatch(0, 0, text, tlen);
        return matched;
    }

    private void rmatch(int ti, int pj, char[] text, int tlen) {

        if (matched) return;
        // 正则表达式已经到结尾了
        if (pj == plen) {
            if (ti == tlen) matched = true;
            return;
        }
        // *匹配任意个字符
        if (pattern[pj] == '*') {
            for (int k = 0; k <= tlen - ti; k++) {
                rmatch(ti+k,pj+1,text,tlen);
            }
        } else if (pattern[pj] == '?') {
            // 匹配0个或1个字符
            rmatch(ti,pj+1, text, tlen);
            rmatch(ti+1,pj+1, text, tlen);
        } else if (ti < tlen && pattern[pj] == text[ti]) {
            // 纯字符匹配才行
            rmatch(ti+1, pj+1, text, tlen);
        }


    }

}
