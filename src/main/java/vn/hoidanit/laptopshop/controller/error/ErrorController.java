package vn.hoidanit.laptopshop.controller.error;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/403")
    public String accessDenied() {
        return "/error_403";
    }

    @GetMapping("/404")
    public String notFound() {
        return "/error_404";
    }
}