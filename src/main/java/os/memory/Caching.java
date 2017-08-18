package os.memory;

public class Caching {
    private final int SIZE = 10 *1024 * 1024;
    private final int[] DATA = new int[SIZE];

    private void run() {
        for (int i = 0; i < 10000; i++) {
            touchEveryItem();
            touchEveryLine();
        }
        System.out.println("Item Line");
        for (int i = 0; i < 100; i++) {
            long t0 = System.nanoTime();
            touchEveryLine();
            long t1 = System.nanoTime();
            touchEveryItem();
            long t2 = System.nanoTime();
            long every = t2 - t1;
            long line = t1 - t0;
            System.out.println(every + " " + line);
        }

    }

    private void touchEveryLine() {
        for (int i = 0; i < SIZE; i += 16) {
            DATA[i]++;
        }
    }

    private void touchEveryItem() {
        for (int i = 0; i < SIZE; i++) {
            DATA[i]++;
        }
    }

    public static void main(String[] args){
        new Caching().run();
    }

}
