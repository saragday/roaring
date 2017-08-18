package netty.protocal.http.xml.pojo;

import java.util.List;

import lombok.Data;

@Data
class Customer {
    private long customerNumber;
    private String firstName;
    private String lastName;
    private List<String> middleNames;

}
