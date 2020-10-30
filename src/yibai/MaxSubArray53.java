package yibai;

public class MaxSubArray53 {


    /**
     *  基于贪心算法
     *  令a表示当前nums[i],currentBeforeSum代表a之前的值之和，max_sum代表当前所有值
     *  若currentBeforeSum<0,则舍弃前面的和，用当前值来代替，
     *  也就是 currentBeforeSum = nums[i]
     *  若currentBeforeSum代表a之前的值之和 >= 0，则若currentBeforeSum代表a之前的值之和 = currentBeforeSum + nums[i]
     *  最后在取currentBeforeSum, max_sum中的最大值
     *
     *  只能知道这样做，但不明白为什么这样做！ 没明白道理
     * **/
    public static int maxSubArray(int[] nums){

        int max_sum = nums[0];
        int currentBeforeSum = nums[0];
        int i = 1;
        while (i < nums.length){
            currentBeforeSum = Math.max(nums[i], currentBeforeSum + nums[i]);
            max_sum = Math.max(currentBeforeSum,max_sum);
            i++;
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
