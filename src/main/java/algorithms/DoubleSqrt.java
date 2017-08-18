package algorithms;

public class DoubleSqrt {

    private static double error = 0.00001;

    public static void main(String[] args) {
        System.out.println(calSqrt(7));
    }

    private static double calSqrt(double n) {
        double result = n;
        double diff;
        do {
            double lastVal = result;
            result = lastVal - lastVal / 2.0 + n / 2.0 / lastVal;
            diff = Math.abs(lastVal - result);
        } while (diff > error);

        return result;
    }
}
