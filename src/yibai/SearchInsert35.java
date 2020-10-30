package yibai;

public class SearchInsert35 {

    public static int searchInsert(int[] nums, int target) {
        int heigh = nums.length - 1;
        int low = 0;
        int mid = 0;
        while (low <= heigh) {
            mid = (low + heigh) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) heigh = mid -1;
            else low = mid + 1;
        }

        return heigh + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }
}
