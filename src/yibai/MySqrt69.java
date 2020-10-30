package yibai;

import org.junit.Test;

public class MySqrt69 {

    public static int mySqrt1(int x) {
        if (x<=1) return x;
        for (int i = 0; i <= x/2; i++) {
            if (x/i>=i && x/(i+1)<(i+1)) return i;
        }
        return 0;
    }
    public static int mySqrt(int x) {
        if (x<=1) return x;
        int left = 1;
        int right = x;
        int mid = 0;
        while (left < right){
            mid = (left + right + 1) / 2 ;
            if (x / mid == mid) return mid;
            else if (x / mid < mid) right = mid-1;
            else left = mid + 1;
        }
        return right;
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
