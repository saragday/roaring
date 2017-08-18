package netty.serialization.java;

import java.io.Serializable;

import lombok.Data;

@Data
class SubscribeResp implements Serializable {

    private static final long serialVersionUID = 5800158866248908467L;

    private int subReqId;
    private int respCode;
    private String desc;


}
