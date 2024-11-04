package vn.hoidanit.laptopshop.controller.admin;

import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.service.OrderDetailService;
import vn.hoidanit.laptopshop.service.OrderService;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final OrderDetailService orderDetailService;

    public OrderController(OrderService orderService, OrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/admin/order")
    public String getDashboard(Model model) {
        List<Order> orders = this.orderService.fetchOrders();
        model.addAttribute("orders", orders);
        return "/admin/order/show";
    }

    @GetMapping("/admin/order/{id}")
    public String getOrderDetailPage(Model model, @PathVariable long id) {
        List<OrderDetail> orderDetails = this.orderDetailService.fetchOrderDetails();
        model.addAttribute("orderDetails", orderDetails);
        model.addAttribute("id", id);
        return "/admin/order/detail";
    }

    @RequestMapping("/admin/order/update/{id}")
    public String updateOrderStatus(Model model, @PathVariable long id) {
        Order order = this.orderService.findOrderById(id);
        model.addAttribute("order", order);
        return "admin/order/update";
    }

    @RequestMapping("/admin/order/update")
    public String updateOrderStatus(@ModelAttribute("order") Order dataForm) {
        Order updatedOrder = this.orderService.findOrderById(dataForm.getId());
        updatedOrder.setStatus(dataForm.getStatus());
        this.orderService.save(updatedOrder);
        return "redirect:/admin/order";
    }
}
