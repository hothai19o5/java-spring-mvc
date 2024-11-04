package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.repository.OrderRepository;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> fetchOrders() {
        return this.orderRepository.findAll();
    }

    public Order findOrderById(long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        if(order.isPresent()){
            return order.get();
        }
        return null;
    }

    public void save(Order order) {
        this.orderRepository.save(order);
    }
}
