package ro.ubb.soa.ccojocaru.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ro.ubb.soa.ccojocaru.model.RestaurantOrder;
import ro.ubb.soa.ccojocaru.model.SendEmailOrder;
import ro.ubb.soa.ccojocaru.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, SendEmailOrder> kafkaTemplate;

    @Autowired
    public OrderService(OrderRepository orderRepository, KafkaTemplate<String, SendEmailOrder> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<RestaurantOrder> getAllOrders() {
        return orderRepository.getAlOrders();
    }

    public void saveOrder(RestaurantOrder restaurantOrder) {
        orderRepository.save(restaurantOrder);
    }

    private void sendEmail(RestaurantOrder order) {
        SendEmailOrder sendEmailOrder = new SendEmailOrder();
        sendEmailOrder.setName(order.getName());

        kafkaTemplate.send("order-email", sendEmailOrder);
    }
}
