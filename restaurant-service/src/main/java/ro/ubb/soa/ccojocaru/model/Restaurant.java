package ro.ubb.soa.ccojocaru.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private Integer resturantPriceRate;
    private String resturantOpeningHour;
    private String restaurantCloseHour;
    private String resturantStartWeekDay;
    private String resturantEndWeekDay;
    private String restaurantDescription;
    @OneToMany
    private List<RestaurantMenuItem> menu;
}
