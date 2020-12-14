package data_struct;

public class Lcs {


    public int lcs(char[] a, int n, char[] b, int m) {

        int[][] maxLcs = new int[n][m];

        // 初始化第1行
        for (int j = 0; j < m; j++) {
            // 这里是拿a[0] 与整个b串进行比较
            // b的当前位置不等与a[0], 那么此处他们的最长公共字串的长度就为上一个元素的最长公共字符串的长度
            if (a[0] == b[j]) maxLcs[0][j] = 1;
            else if (j != 0) maxLcs[0][j] = maxLcs[0][j - 1];
            else maxLcs[0][j] = 0;
        }

        for (int i = 0; i < n; i++) {

            if (b[0] == a[i]) maxLcs[i][0] = 1;
            else if (i != 0) maxLcs[i][0] = maxLcs[i - 1][0];
            else maxLcs[i][0] = 0;
        }
        // 开始填表
        for (int i = 1; i < n; i++) {

            for (int j = 1; j < m; j++) {

                // 问题：这里只有maxLcs[i][j]加了1，maxLcs[i][j]对应的是上一个也匹配的意思
                // 其他两种情况就相当于j前面的元素没有匹配，然后做了处理，与当前元素j进行比较了，所以不需要+1
                if (a[i] == b[j]) maxLcs[i][j] = max(maxLcs[i - 1][j], maxLcs[i][j - 1], maxLcs[i-1][j-1] + 1);
                else maxLcs[i][j] = max(maxLcs[i - 1][j], maxLcs[i][j - 1], maxLcs[i-1][j-1]);
            }
        }
        return maxLcs[n - 1][m - 1];


    }

    private int max(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    public static void main(String[] args) {
        char[] a = new char[]{'m', 'i', 't', 'c', 'm', 'u'};
        char[] b = new char[]{'m', 't', 'a', 'c', 'n'};

        Lcs lcs = new Lcs();

        System.out.println(lcs.lcs(a, a.length, b, b.length));
    }
}
