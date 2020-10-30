package yibai;

public class Merge88 {

    /*
    * 自己的思路：从前往后进行比较计算
    * 若nums1[i] <= nums2[j] ,则nus1指针向后移动一位
    * 反之，从i的位置开始，整体向后移动一位，给要插入的nums2[j]腾出位置
    * 若i=m，则表示nums1的所有元素都已放在正确的位置，则将nums2剩余的元素放入nuns1即可
    * */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j =0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            }
            // 移动数组的元素
            else {
                for(int s=nums1.length-1; s > i; s--){
                    nums1[s] = nums1[s-1];
                }
                nums1[i++] = nums2[j++];
                m++;// nums1插入了一个新元素，自然m要+1
            }
        }
        while (j < n) {
            nums1[i++] = nums2[j++];
        }
        for (int k:nums1){
            System.out.print(k+"  ");
        }

    }
    /**
     *  最佳解法，从后向前比较赋值
     *  因为 nums1 的空间都集中在后面，所以从后向前处理排序的数据会更好，节省空间，一边遍历一边将值填充进去
     *  设置指针 i和 j 分别指向 nums1 和 nums2 的有数字尾部，从尾部值开始比较遍历，同时设置指针 fi 指向 nums1 的最末尾，每次遍历比较值大小之后，则进行填充
     *  当 i<0 时遍历结束，此时 j 中海油数据未拷贝完全，将其直接拷贝到 nums1 的前面，最后得到结果数组
     *
     * **/
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int fi = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i>=0 && j>=0) {
            nums1[fi--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为j+1
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
        for (int k:nums1){
            System.out.print(k+"  ");
        }
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1,3,nums2,3);
    }
}
