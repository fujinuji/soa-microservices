package ro.ubb.soa.ccojocaru.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class RestaurantOrder {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String orderId;
    private String name;
    private String phoneNumber;
    private String deliveryAddress;
    private Long totalPrice;
    private String emailAddress;
    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<MenuItem> items;
}
