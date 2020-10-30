package yibai;

public class IsLongPressedName925 {


    /**
     * 思路：双指针法 i，j，进行遍历两个字符串
     * 如果name[i] == typed[j] 则 i++ ,j++
     * 如果不相等：
     *          当typed[j-1] == typed[j]，说明重复输入了，此时只需要将j++
     *          当typed[j-1] != typed[j]，直接返回false
     *
     * */
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {

            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i ++;
                j ++;
            }
            else if (j > 0 && typed.charAt(j) == typed.charAt(j-1)) j ++;

            else return false;
        }


        return i == name.length();
    }

    public static void main(String[] args) {
        System.out.println(isLongPressedName("saeed", "ssaaeedd"));
    }
}
