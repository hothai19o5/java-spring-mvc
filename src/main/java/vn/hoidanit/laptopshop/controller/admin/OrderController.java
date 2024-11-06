package vn.hoidanit.laptopshop.controller.admin;

import java.nio.file.Path;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.Product;
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
    public String getDashboard(Model model, @RequestParam(value = "page", defaultValue = "1") int page) {
        Page<Order> orders = this.orderService.fetchOrders(PageRequest.of(page - 1, 6));
        List<Order> listOrders = orders.getContent();
        model.addAttribute("orders", listOrders);

        model.addAttribute("totalPages", orders.getTotalPages());
        model.addAttribute("currentPage", page);
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

    @GetMapping("/admin/order/delete/{id}")
    public String getDeleteOrderPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        Order order = this.orderService.findOrderById(id);
        model.addAttribute("order", order);
        return "/admin/order/delete";
    }

    @PostMapping("admin/order/delete")
    public String postDeleteOrder(Model model, @ModelAttribute("id") long id) {
        List<OrderDetail> orderDetail = this.orderDetailService.fetchOrderDetails();
        for(OrderDetail detail : orderDetail) {
            if(detail.getOrder().getId() == id) {
                this.orderDetailService.handleDeleteOrderDetail(detail);
            }
        }
        Order order = this.orderService.findOrderById(id);
        this.orderService.handleDeleteOrder(order);
        return "redirect:/admin/order";
    }

    @GetMapping("/order-history")
    public String getOrderHistoryPage(Model model) {
        List<Order> orders = this.orderService.fetchOrders();
        model.addAttribute("orders", orders);
        List<OrderDetail> orderDetails = this.orderDetailService.fetchOrderDetails();
        model.addAttribute("orderDetails", orderDetails);
        return "client/cart/orderHistory";
    }

}
