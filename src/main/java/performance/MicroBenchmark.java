package performance;

public class MicroBenchmark {


    /**
     * The biggest problem with this code is that it never actually changes any program state.
     * Because the result of the Fibonacci calculation is never used, the compiler is free to discard that calculation
     */
    private void benchmarkCalFibonacci() {
        double l;
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++)  {
            l = calFibonacci(50);
        }
        end = System.currentTimeMillis();
        System.out.printf("total costs: " + (end - start));
    }

    private double calFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("illegal argument n");
        }
        if (n == 0 || n == 1) {
            return n;
        } else {
            return calFibonacci(n - 1) + calFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        new MicroBenchmark().benchmarkCalFibonacci();
    }

}
