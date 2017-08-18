package jdk.io.aio;

import jdk.io.nio.TimeClientHandler;

public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                // use default
            }
        }

        TimeClientHandler timeClientHandler = new TimeClientHandler("127.0.0.1", port);
        new Thread(timeClientHandler, "AIO-AsyncTimeClient--001").start();
    }
}
