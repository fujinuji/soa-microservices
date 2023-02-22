package ro.ubb.soa.ccojocaru.services.interfaces;

import org.springframework.stereotype.Service;
import ro.ubb.soa.ccojocaru.model.Restaurant;

import java.util.List;

@Service
public interface RestaurantServiceInterface {
    public List<Restaurant> getAllRestaurants();

    public Restaurant findRestaurantById(String id);
}
