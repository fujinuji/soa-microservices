package ro.ubb.soa.ccojocaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.soa.ccojocaru.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    @Query("SELECT r FROM Restaurant r")
    List<Restaurant> getAllRestaurants();

    @Query("SELECT restaurant FROM Restaurant restaurant WHERE restaurant.restaurantId = ?1")
    Optional<Restaurant> getById(String id);
}
