package ro.ubb.soa.ccojocaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.ubb.soa.ccojocaru.model.RestaurantOrder;

import java.util.List;

public interface OrderRepository extends JpaRepository<RestaurantOrder, String> {

    @Query("SELECT o FROM RestaurantOrder o")
    List<RestaurantOrder> getAlOrders();
}
