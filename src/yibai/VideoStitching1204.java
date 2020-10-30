package yibai;

import java.util.Arrays;

public class VideoStitching1204 {

    public int videoStitching(int [][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {

            for (int[] c:clips) {
                if (i > c[0] && i <= c[1]) {
                    dp[i] = Math.min(dp[i], dp[c[0]] + 1);
                }
            }

        }

        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
