package data_struct;

public class Dp {

    /**
     * 问题：有一个n乘以n的矩阵w[n][n]。矩阵存储的都是正整数。棋子起始位置在左上角，终止位置在右下角。
     * 我们将棋子从左上角移动到右下角。每次只能向右或者向下移动一位。
     * 我们把每条路径经过的数字加起来看作路径的长度。那从左上角移动到右下角的最短路径长度是多少呢
     *
     * 本解法采用状态转移表法
     */

    public static int minDpPath(int[][] arr, int n) {

        /**
         * status[i][j]:代表对应位置到左上角的最短路径长度
         *
         * */
        int[][] status = new int[n][n];
        int sum = 0;
        // 初始化第一行
        for (int i = 0; i < n; i++) {
            sum += arr[0][i];
            status[0][i] = sum;
        }
        sum = 0;
        // 初始化第一列
        for (int j = 0; j < n; j++) {
            sum += arr[j][0];
            status[j][0] = sum;
        }
        // 计算其他位置的mini路径

        for (int i = 1; i < n; i++) {

            for (int j = 1; j < n; j++) {

                status[i][j] = arr[i][j] + Math.min(status[i - 1][j], status[i][j - 1]);
            }
        }
        return status[n - 1][n - 1];
    }

    // 采用状态转移方程来求解
    public static int minDist(int[][] arr, int[][] status, int i, int j) {

        if (i == 0 && j == 0) return arr[i][j];
        if (status[i][j] > 0) return status[i][j];
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        int right = 0;
        if (i-1 >= 0) {
            left = minDist(arr, status, i-1, j);
        }

        if (j - 1 >= 0) {
            up = minDist(arr, status, i, j-1);
        }
        status[i][j] = arr[i][j] + Math.min(left, up);

        return status[i][j];
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {4, 8, 9}};

        System.out.println(minDpPath(arr, 3));
        int n = 3;
        int[][] status = new int[3][3];
        System.out.println(minDist(arr,status, n-1, n-1));
    }
}
