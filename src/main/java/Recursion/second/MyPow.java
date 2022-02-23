package Recursion.second;

public class MyPow {

    public double myPow(double x, int n) {
        return n < 0 ? _myPow(1 / x, -n) : _myPow(x, n);
    }

    public double _myPow(double x, int n) {
        if (n == 0) return 1d;

        double y = _myPow(x, n / 2);

        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

}
