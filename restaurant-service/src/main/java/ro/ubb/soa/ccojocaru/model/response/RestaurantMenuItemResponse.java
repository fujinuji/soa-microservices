package ro.ubb.soa.ccojocaru.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestaurantMenuItemResponse {
    private String itemId;
    private String itemName;
    private Long itemPrice;
    private Boolean isDinner;
    private Boolean isSelected;
}
