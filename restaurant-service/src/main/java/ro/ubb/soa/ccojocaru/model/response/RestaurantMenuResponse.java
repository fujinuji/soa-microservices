package ro.ubb.soa.ccojocaru.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestaurantMenuResponse {
    private String restaurantName;
    private List<RestaurantMenuItemResponse> menu;
}
