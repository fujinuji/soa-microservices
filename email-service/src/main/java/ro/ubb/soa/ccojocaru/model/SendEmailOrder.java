package ro.ubb.soa.ccojocaru.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SendEmailOrder {
    private String name;
    private String email;
    private String deliveryAddress;
    private List<String> items;
}
