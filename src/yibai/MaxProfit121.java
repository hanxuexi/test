package yibai;

public class MaxProfit121 {


    /**
     * 暴力解法，两次遍历，即可找到最大利润
     * **/
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] < prices[j] && maxProfit < (prices[j] -  prices[i])) {
                    maxProfit =  prices[j] -  prices[i];
                }

            }
        }
        return maxProfit;
    }

    /**
     * 官方解法：
     * */
    public int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                sum += maxprofit;
                maxprofit = prices[i] - minprice;
        }
        return maxprofit>sum?maxprofit:sum;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
