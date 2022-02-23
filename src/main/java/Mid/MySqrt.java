package Mid;

import java.text.NumberFormat;

/**
 * x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * @author 包成
 */
public class MySqrt {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int ret = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
                // 最接近的
                ret = mid;
            }
        }

        return ret;
    }

    public int _mySqrt(int x, int ret, int left, int right) {
        if (left > right) return ret;

        int mid = left + (right - left) / 2;
        if ((long) mid * mid > x) {
            right = mid - 1;
        } else {
            left = mid + 1;
            ret = mid;
        }

        return _mySqrt(x, ret, left, right);
    }

    public double mySqrt(int x, int accuracy) {
        if (x <= 0)
            return 0;
        if (x == 1)
            return 1;
        double result = 0;
        double left = 0, right = x;
        while (left <= right) {
            double mid = (left + right) / 2;
            double s = mid * mid;
            if (Math.abs(s - x) <= Math.pow(0.1, accuracy)) {
                result = mid;
                break;
            }
            if (s > x)
                right = mid;
            else if (s < x)
                left = mid;
        }

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(accuracy);
        return Double.parseDouble(nf.format(result));
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(0.1, 5));

        MySqrt mySqrt = new MySqrt();
        double v = mySqrt.mySqrt(2, 5);
        System.out.println(v);
    }

}
