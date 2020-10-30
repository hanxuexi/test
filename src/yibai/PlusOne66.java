package yibai;

public class PlusOne66 {


    /**
     * 思路：先将最后一位+1 若加完之后<10 则直接返回即可
     *      若>=10 则当前一位 = 当前值 - 10，前面一位进1，直到遍历到第二位，结束
     *      若第一位>=10,则加一位，生成一个长度为n+1的数组，此时第一位为1，第二位为历史第一位-10 如10 0 0 1 ---1 0 0 0 1
     *
     * **/
    public static int[] plusOne(int[] digits){
        int length = digits.length;
        digits[digits.length-1]++;
        int i = length - 1;
        while (i>0){
            if (digits[i]>=10) {
                digits[i] = digits[i] - 10;
                digits[i-1]++;
            }
            else return digits;
            i--;
        }
        if (digits[0]>9) {
            int[] temp = new int[length+1];
            temp[0] = 1;
            temp[1] = digits[0] - 10;
            for (int j = 1; j < length; j++) {
                temp[j+1] = digits[j];
            }
            return temp;
        }else {
            return digits;
        }
    }

    public static void main(String[] args) {
//        int[] digits = new int[]{2,4,9,3,9};
        int[] digits = new int[]{9};
        int[] a = plusOne(digits);
        for (int di:a){
            System.out.println(di);
        }
    }
}
