package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.hoidanit.laptopshop.service.OrderService;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class DashboardController {
    private final OrderService orderService;
    private final ProductService productService;
    private final UserService userService;

    public DashboardController(OrderService orderService, ProductService productService, UserService userService) {
        this.orderService = orderService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String getDashboard(Model model) {
        int totalUsers = 0;
        int totalProducts = 0;
        int totalOrders = 0;

        totalUsers = this.userService.getAllUser().size();
        totalProducts = this.productService.fetchProducts().size();
        totalOrders = this.orderService.fetchOrders().size();

        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("totalOrders", totalOrders);

        return "admin/dashboard/show";
    }
}
