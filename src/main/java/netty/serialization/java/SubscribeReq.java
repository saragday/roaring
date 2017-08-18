package netty.serialization.java;

import java.io.Serializable;

import lombok.Data;


@Data
class SubscribeReq implements Serializable {
    private static final long serialVersionUID = -5611079835194559638L;
    private int subReqId;
    private String userName;
    private String productName;
    private String phoneNumber;
    private String address;

}
