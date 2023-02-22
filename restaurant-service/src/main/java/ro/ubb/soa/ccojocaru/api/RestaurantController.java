package ro.ubb.soa.ccojocaru.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.soa.ccojocaru.model.Restaurant;
import ro.ubb.soa.ccojocaru.model.RestaurantMenuItem;
import ro.ubb.soa.ccojocaru.model.response.RestaurantMenuItemResponse;
import ro.ubb.soa.ccojocaru.model.response.RestaurantMenuResponse;
import ro.ubb.soa.ccojocaru.services.RestaurantService;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Restaurant getRestaurantById(@PathVariable("id") String id) {
        return restaurantService.findRestaurantById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/menu")
    public RestaurantMenuResponse getRestaurantMenu(@PathVariable("id") String restaurantId) {
        Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);

        RestaurantMenuResponse restaurantMenuResponse = new RestaurantMenuResponse();
        restaurantMenuResponse.setRestaurantName(restaurant.getRestaurantName());
        restaurantMenuResponse.setMenu(restaurant.getMenu().stream().map(item -> {
            RestaurantMenuItemResponse restaurantMenuItemResponse = new RestaurantMenuItemResponse();
            restaurantMenuItemResponse.setItemId(item.getItemId());
            restaurantMenuItemResponse.setItemName(item.getItemName());
            restaurantMenuItemResponse.setItemPrice(item.getItemPrice());
            restaurantMenuItemResponse.setIsDinner(item.getIsDinner());
            restaurantMenuItemResponse.setIsSelected(false);

            return restaurantMenuItemResponse;
        }).collect(Collectors.toList()));

        return restaurantMenuResponse;
    }
}
