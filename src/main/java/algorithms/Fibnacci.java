package algorithms;

import java.util.Arrays;

public class Fibnacci {

    private long[] cache;
    private int n;

    private Fibnacci(int n) {
        this.n = n;
        this.cache = new long[n + 1];
        Arrays.fill(cache, -1);
    }

    private long f(int n) {
        if (cache[n] != -1) {
            return cache[n];
        }

        if (n == 0) return 0;
        if (n == 1) return 1;

        long fn = f(n - 1) + f(n - 2);
        cache[n] = fn;
        return fn;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int n = 0; n < 100; n++) {
            System.out.println(n + " " + new Fibnacci(n).f(n));
        }
        long end = System.currentTimeMillis();
        System.out.println("Cost " + (end - start) / 100 + " s");
    }
}
