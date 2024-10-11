package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DetailPageController {

    @GetMapping("/product")
    public String getDetailPage() {
        return "client/product/detail";
    }
}
