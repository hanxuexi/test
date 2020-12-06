package data_struct;

public class Package01 {

    public static void main(String[] args) {
        int[] arr = new int[]{10,5,12,34,52,14,10,30,20,41};
        int maxW = Integer.MIN_VALUE;
        f(0,0, arr,10,100, maxW);

    }
    /*
    *   cw表示当前已经装进去的物品的重量和
    *   i表示考察到哪个物品了
    *   w:表示背包重量
    *   n代表物品数目，放在数组items里面
    *
    *   注：要想理解，把递归树画出来就明白了
    * */
    public static void f(int i, int cw, int[] items, int n, int w, int maxW) {

        if (cw > maxW || i == n) {
            if (cw > maxW) maxW = cw;
            return ;
        }
        f(i+1, cw, items, n, w, maxW);
        if (cw + items[i] <= w) {
            f(i+1,cw+items[i], items, n, w, maxW);
        }
    }


    // 背包问题题解1
    public int knapsack1 (int[] weight, int n, int  w) {

        boolean[][] states = new boolean[n][w+1];

        // 第一行数据要特殊处理，可以利用哨兵优化
        states[0][0] = true;
        states[0][weight[0]] = true;

        for (int i = 1; i < n; i++) {

            // 第i个物品放入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i-1][j] == true) states[i][j+weight[i]] =true;
            }
            // 第i个物品不放背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
        }
        // 输出结果
        for (int i = w; i>=0; i--) {
            if (states[n-1][i] == true) return i;
        }

        return 0;
    }

    // 背包问题题解2

    public int knapsack2(int[] weight, int n, int  w) {

        boolean[] status = new boolean[w+1];
        status[0] = true;
        status[weight[0]] = true;
        for (int i = 1; i < n; i++) {
            // j需要从大到小来处理。
            // 如果我们按照j从小到大处理的话，会出现for循环重复计算的问题
            for (int j = w - weight[i]; j >= 0; j--) {
                // 放入第i个背包
                if (status[j] == true) status[j + weight[i]] = true;
                // 不放的话就默认当前层的状态 = 上一层的 因为不用加上weight
            }

        }

        for (int i = w; i >= 0; i--) {
            if (status[i] == true) return i;
        }

        return 0;
    }

    // 背包问题3
    // 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品
    // 装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
    public int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];

        for (int i = 1; i < n; i++) {

            // 第i个物品不装入背包
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            // 第i个物品装入背包
            for (int j = 0; j <= w - weight[j]; j++) {
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j+weight[j]] = v;
                    }
                }
            }
        }
        int max = -1;
        for (int j = 0; j < n; j--) {
            if (states[n-1][j] > max) max = states[n-1][j];
        }
        return max;
    }
}
