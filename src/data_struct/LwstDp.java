package data_struct;

public class LwstDp {


    public int lwstDp(char[] a, int n, char[] b, int m) {

        int[][] minDist = new int[n][m];

        // 初始化第一行
        for (int j = 0; j < m; j++) {
            // 因为在初始化第一行的时候，a只有一个元素，而b是完整的一个串，
            // 所以只要a与其中的某个字符相等，那么minDist就应该等于j的下标
            // 假如a与b中小标为4的元素相等，那么b中的元素在第5个位置，也即只要修改4次a就能和b一样
            if (a[0] == b[j]) minDist[0][j] = j;
            // a与当前元素不相等的情况，只需通过前一个minDist+1即可得到答案
            else if (j != 0) minDist[0][j] = minDist[0][j - 1] + 1;
            // 对应a[0] != b[j] 且 j==0 的情况，也就是a和b的第一个元素不相等
            else minDist[0][j] = 1;
        }
        // 初始化第一列
        for (int i = 0; i < n; i++) {
            if (b[0] == a[i]) minDist[i][0] = i;
            else if (i != 0) minDist[i][0] = minDist[i - 1][0] + 1;
            else minDist[i][0] = 1;
        }

        // 按行填表

        for (int i = 1; i < n; i++) {

            for (int j = 1; j < m; j++) {

                if (a[i] == b[j]) {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1]);
                } else {
                    minDist[i][j] = min(minDist[i - 1][j] + 1, minDist[i][j - 1] + 1, minDist[i - 1][j - 1] + 1);
                }
            }
        }
        // 打印每一步
        for (int[] arr: minDist) {
            for (int t : arr) {
                System.out.print(t + " ");
            }
            System.out.println();
        }
        return minDist[n-1][m-1];
    }

    public int min(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    public static void main(String[] args) {
        char[] a = new char[]{'m', 'i', 't', 'c', 'm', 'u'};
        char[] b = new char[]{'m', 't', 'a', 'c', 'n', 'u'};

        LwstDp lwstDp = new LwstDp();

        System.out.println(lwstDp.lwstDp(a, a.length, b, b.length));
    }
}
