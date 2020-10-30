package sort;

public class Direct_insert {

    public static void sort(int[] arr) {
        // 先排序，然后再比较
        int tmp = 0;
        int j = 0;
        for(int i = 1; i < arr.length; i++) {

            if(arr[i] < arr[i-1]) {
                tmp = arr[i];

                for(j = i-1; arr[j] > tmp; j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = tmp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        sort(new int[]{1,2,2,1,1,3});
    }
}
