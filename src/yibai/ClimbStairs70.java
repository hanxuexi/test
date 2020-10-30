package yibai;

public class ClimbStairs70 {

    /**
     * 自顶向上，采用递归实现 用f(n)来表示爬到n阶楼梯的方法数
     * f(n) = f(n-1) + f(n-2)
     * **/
    public static int climbStairs1(int n) {

        if (n == 0 || n == 1) return 1;
        else return climbStairs(n-1) + climbStairs(n-2);
    }

    // 自底向下,这个与前面的相反
    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
       return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
