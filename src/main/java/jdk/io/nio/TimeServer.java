package jdk.io.nio;

import java.io.IOException;

public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                // 采用默认值
            }
        }
        MultiplexerTimeServerHandler timerServier = new MultiplexerTimeServerHandler(port);
        new Thread(timerServier, "NIO_MultiplexerTimerServer-001").start();
    }
}
