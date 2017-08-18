package netty.serialization.java;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqClientHandler extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : [" + msg + "]");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private SubscribeReq subReq(int subReqId) {
        SubscribeReq subReq = new SubscribeReq();
        subReq.setSubReqId(subReqId);
        subReq.setUserName("Star");
        subReq.setPhoneNumber("131xxxxxxxx");
        subReq.setProductName("Planet Lonely");
        subReq.setAddress("上海和平饭店");
        return subReq;
    }
}
