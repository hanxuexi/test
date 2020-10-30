package yibai;

public class AddBinary67 {

    public static String addBinary(String a, String b) {


        /**
         * 按照位置给结果字符赋值，最后如果有进位，则在前方进行字符串拼接添加进位
         * */
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            // 有进位则为1，无进位为0
            ca = sum / 2;
        }
        // 判断最前面的一位是否有进位，如果有，用1表示，否则用空字符串表示
        ans.append(ca == 1 ? ca : "");
        // 因为是从前往后存的，所以要翻转过来
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1011","1011"));
    }
}
