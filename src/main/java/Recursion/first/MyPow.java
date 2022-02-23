package Recursion.first;

/**
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author 包成
 */
public class MyPow {

    public double myPow(double x, int n) {
        return n < 0 ? 1.0 / quickMul(x, n) : quickMul(x, -n);
    }

    private Double quickMul(Double x, int n) {
        // 任何一个数的0次方都是1
        if (n == 0) return 1.00;
        // 算出平方数一半的结果
        Double y = quickMul(x, n / 2);
        // 是偶数, y*y; 是奇数, y*y*x
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.out.println(1 / 2);
    }

}
