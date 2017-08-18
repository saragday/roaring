package netty.protocal.http.xml.pojo;

import lombok.Data;

@Data
class Address {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String postcode;

}
