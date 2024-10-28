package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;

@Controller
public class ItemController {

    private final ProductService productService;

    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id) {

        return "redirect:/";
    }

    // @GetMapping("/product/{id}")
    // public String getProductPage(Model model, @PathVariable long id) {
    //     Product pr = this.productService.fetchProductById(id).get();
    //     model.addAttribute("product", pr);
    //     return "client/product/detail";
    // }

    @GetMapping("/product/1")
    public String getProductPage1(Model model) {
        Product pr = this.productService.fetchProductById(1).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/2")
    public String getProductPage2(Model model) {
        Product pr = this.productService.fetchProductById(2).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/3")
    public String getProductPage3(Model model) {
        Product pr = this.productService.fetchProductById(3).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/4")
    public String getProductPage4(Model model) {
        Product pr = this.productService.fetchProductById(4).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/5")
    public String getProductPage5(Model model) {
        Product pr = this.productService.fetchProductById(5).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/6")
    public String getProductPage6(Model model) {
        Product pr = this.productService.fetchProductById(6).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/7")
    public String getProductPage7(Model model) {
        Product pr = this.productService.fetchProductById(7).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/8")
    public String getProductPage8(Model model) {
        Product pr = this.productService.fetchProductById(8).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/9")
    public String getProductPage9(Model model) {
        Product pr = this.productService.fetchProductById(9).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/10")
    public String getProductPage10(Model model) {
        Product pr = this.productService.fetchProductById(10).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/11")
    public String getProductPage11(Model model) {
        Product pr = this.productService.fetchProductById(11).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
    @GetMapping("/product/12")
    public String getProductPage12(Model model) {
        Product pr = this.productService.fetchProductById(12).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }
}
