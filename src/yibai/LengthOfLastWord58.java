package yibai;

public class LengthOfLastWord58 {


    /**
     * 最简单的方法是切割按空格切分字符串，然后返回最后一个字符串的长度即可
     *
     * **/
    public static int lengthOfLastWord1(String s) {
       String [] arr = s.split("\\s+");
        return arr.length==0?0:arr[arr.length-1].length();
    }

    /**
     * 官方做法：从尾部开始向前遍历，则有以下两种情况
     * 1. 末尾没有空字符串，如‘hello world’, 这样 从后向前依次遍历，第一个读到空格的位置end - 第二此读到的位置start
     * 2. 末尾有空字符串，如‘hello world  ’，这样，这个时候一定要定位到单词前的第一个空格end，其他和前面一样
     * **/
    public static int lengthOfLastWord(String s) {
        int end = s.length()-1;
        while (end>=0 && (s.charAt(end)==' ')) end--;
        int start = end;
        while (start>=0 && (s.charAt(start)!=' ')) start--;
        return end - start;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
