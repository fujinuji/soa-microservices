package ro.ubb.soa.ccojocaru.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ubb.soa.ccojocaru.model.MenuItem;
import ro.ubb.soa.ccojocaru.model.RestaurantOrder;
import ro.ubb.soa.ccojocaru.sevice.OrderService;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<RestaurantOrder> getAllOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(method = RequestMethod.POST)
    private void saveOrder(@RequestBody RestaurantOrder restaurantOrder) {
        restaurantOrder.setItems(restaurantOrder.getItems().stream().map(item -> {
            MenuItem menuItem = new MenuItem();
            menuItem.setItemName(item.getItemName());

            return menuItem;
        }).collect(Collectors.toList()));
        orderService.saveOrder(restaurantOrder);
    }
}
