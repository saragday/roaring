package jdk.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeServerHandler implements Runnable {
    private int port;
    CountDownLatch latch;
    AsynchronousServerSocketChannel asyncServerSocketChannel;


    AsyncTimeServerHandler(int port) {
        this.port = port;

        try {
            asyncServerSocketChannel = AsynchronousServerSocketChannel.open();
            asyncServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("Time server started at port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {
        asyncServerSocketChannel.accept(this, new AcceptCompletionHandler());
    }
}
