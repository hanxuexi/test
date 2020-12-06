package data_struct;


/*
* 八皇后算法
* */
public class Cal8queens {

    public static void main(String[] args) {
        int[] result = new int[8];
        cal8queens(result, 0);
    }


    public static void cal8queens(int[] arr, int row) {
        if (row == arr.length) {
            printQueens(arr);
            return ;
        }

        for (int column = 0; column < arr.length; column++) {
            if (isOk(arr, row, column)) {
                arr[row] = column; // 下标代表行，值代表列
                cal8queens(arr,row+1); // 下一行又是一个for循环，可以遍历所有的结果
            }
        }

    }
    // 判断当前落子是否符合要求
    public static boolean isOk(int[] arr, int row, int column) {
        int leftup =  column - 1, rightup = column + 1;

        for (int i = row - 1; i >= 0; i--) {
            if (arr[i] == column) return false; // 检查列
            if (leftup >= 0) {
               if (arr[i] == leftup) return false; // 检查左上对角线
            }
            if (rightup <= arr.length) {
                if (arr[i] == rightup) return false; // 检查右上对角线
            }
            leftup--;
            rightup++;
        }
        return true;
    }

    public static void printQueens(int[] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr.length; column++) {
                if (arr[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
