package yibai;
/**
 * 题目描述
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * **/
public class Reverse7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }
    public static int reverse(int x){
        int[] save = new int[11];
        // 这里声明为long类型，为的是防止在做计算时，int类型直接越界，而导致n的值为最大值，而不是正确的值从而导致程序出错
        long n = x;
        int i = 0;
        n = x > 0?x:-x;
        while(n!=0) {
            save[i++] = (int) n % 10;
            n = n / 10;
        }
        for(int j = 0; j < i; j++){
            // 采用这种方法，比用Math.pow()方法内存更少
            n = n*10 + save[j];
        }
        if (n > (Math.pow(2,31)-1) || n < (-Math.pow(2,31))) n = 0;
        return (int) ((int) x>0?n:-n);
    }
}
