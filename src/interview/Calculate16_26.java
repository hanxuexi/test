package interview;

import java.lang.annotation.ElementType;
import java.util.Stack;


public class Calculate16_26 {
    public static int calculate(String s) {
        char[] cs = s.trim().toCharArray();
        Stack<Integer> st = new Stack();
        int i = 0;

        while ( i < cs.length) {
            if (cs[i] == ' ') {i++;continue; }
            char tmp = cs[i];
            if (tmp == '*' || tmp == '+' || tmp == '-' || tmp == '/') {
                i++;
                while (i < cs.length && cs[i] == ' ') i++;
            }
            int num = 0;
            while (i < cs.length &&  Character.isDigit(cs[i])) {
                // - '0' ：因为这里遍历的都是字符，要想计算数值，就必须用对应字符的ASCII值 - 字符0的ASCII值
                num = num * 10 + cs[i] - '0';
                i++;
            }
            switch (tmp) {
                case '-':
                    num = -num;
                    break;
                case '*':
                    num = st.pop() * num;
                    break;
                case '/':
                    num = st.pop() / num;
                    break;
                default:
                    break;
            }
            st.push(num);

        }
        int sum = 0;
        while (!st.isEmpty()) sum += st.pop();

        return sum;
    }

    public static void main(String[] args) {
        String s = "0-2147483647";
        System.out.println(calculate(s));
    }
}
