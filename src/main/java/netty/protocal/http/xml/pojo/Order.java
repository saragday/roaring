package netty.protocal.http.xml.pojo;

import lombok.Data;

@Data
public class Order {
    private long orderNumber;
    private Customer customer;
    private Address billTo;
    private Shipping shipping;
    private Address shipTo;
    private Float total;

}
