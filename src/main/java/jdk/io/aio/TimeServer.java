package jdk.io.aio;

public class TimeServer {
    public static void main(String[] args) {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // use default port
            }
        }

        AsyncTimeServerHandler asyncTimeServerHandler = new AsyncTimeServerHandler(port);
        new Thread(asyncTimeServerHandler, "AIO-AsyncTimeServer-001").start();
    }
}
