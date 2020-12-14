package data_struct;


/**
 * 位图
 * 布隆过滤器对位图进行了改进
 * */
public class BitMap {

    private char[] bytes;
    private int nbits;

    // nbits表示有多少个数字，相当于置多少位

    public BitMap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits/8+1];
    }

    public void set(int k) {

        if (k > nbits) return;
        int byteIndex = k / 8;
        int nitIndex = k % 8;
        bytes[byteIndex]  |= (1 << nitIndex);
    }
    public boolean get(int k) {
        if (k > nbits) return false;
        int byteIndex = k / 8;
        int nitIndex = k % 8;
        return (bytes[byteIndex] & (1 << nitIndex)) != 0;
    }


}
