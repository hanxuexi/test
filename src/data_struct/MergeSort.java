package data_struct;


/*
*  采用归并排序统计数组中的逆序数个数
*
* */
public class MergeSort {
    private int num = 0;

    public int count(int[] a, int n) {
        num = 0;
        mergerSortCounting(a, 0, n-1);
        System.out.println("num is :" + num);
        return num;
    }


    public void mergerSortCounting(int[] a, int p, int r) {
        if (p >= r) return ;
        int q = (p + r) / 2;
        mergerSortCounting(a, p, q);
        mergerSortCounting(a, q+1, r);
        merge(a, p, q, r);
    }


    public void merge(int[] a, int p, int q, int r) {

        int i = p, j = q + 1, k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                this.num += (q - i + 1); // 统计p-q之间，比a[j]大的元素个数
                tmp[k++] = a[j++];
            }
        }
        while (i <= q) {
            tmp[k++] = a[i++];
        }
        while (j <= r) {
            tmp[k++] = a[j++];
        }
        for(i = 0; i <= r-p; i++) {
            a[p+i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,6,2,3,4};
        MergeSort sort = new MergeSort();
        sort.count(arr, arr.length);
        for(int a:arr) {
            System.out.print(a + " ");
        }
    }
}
