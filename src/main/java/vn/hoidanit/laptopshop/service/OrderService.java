package vn.hoidanit.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Order> fetchOrders(Pageable pageable) {
        return this.orderRepository.findAll(pageable);
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

    public void handleDeleteOrder(Order order) {
        this.orderRepository.delete(order);
    }
}
