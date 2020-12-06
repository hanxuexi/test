package data_struct;

public class YanghuiTriangle {


    public int[][] minPath(int[][] arr, int n) {

        int[][] path = new int[arr.length][arr[0].length];

        path[0][n - 1] = arr[0][n - 1];

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < arr[0].length; j++) {

                // 上一层节点左下角的值
                if (path[i - 1][j] >= 0) {
                    int v = path[i - 1][j] + arr[i][j - 1];
                    if (path[i][j - 1] >= 0) {
                        if (v < path[i][j - 1]) path[i][j - 1] = v;
                    } else path[i][j - 1] = v;

                    // 上一层节点右下角的值
                    int tmp = path[i - 1][j] + arr[i][j + 1];
                    if (path[i][j + 1] >= 0) {
                        if (tmp < path[i][j + 1]) path[i][j + 1] = tmp;
                    } else path[i][j + 1] = tmp;
                }
            }
        }


        return path;

    }
}
