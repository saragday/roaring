package netty.serialization.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class TestSubscribeReqProto {
    private static byte[] encode(SubscribeReqProto.SubscribeReq req) {
        return req.toByteArray();
    }

    private static SubscribeReqProto.SubscribeReq decode(byte[] bytes) throws InvalidProtocolBufferException {
        return SubscribeReqProto.SubscribeReq.parseFrom(bytes);
    }

    private static SubscribeReqProto.SubscribeReq createSubscribeReq() {
        SubscribeReqProto.SubscribeReq.Builder builder = SubscribeReqProto.SubscribeReq.newBuilder();
        builder.setSubReqId(1);
        builder.setUserName("Star");
        builder.setProductName("Netty Book");
        builder.setAddress("He Ping Hotel");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqProto.SubscribeReq req = createSubscribeReq();
        System.out.println("before encode : " + req.toString());
        byte[] encode = encode(req);
        SubscribeReqProto.SubscribeReq reqDecoded = decode(encode);
        System.out.println("after decode : " + reqDecoded.toString());
        System.out.println("Assert equals : " + reqDecoded.equals(req));
    }
}
