package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class ItemController {

    private final ProductService productService;
    private final UserService userService;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    public ItemController(ProductService productService, UserService userService, CartRepository cartRepository, CartDetailRepository cartDetailRepository) {
        this.productService = productService;
        this.userService = userService;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
    }

    @PostMapping("/delete-cart-product/{id}")
    public String deleteCartProduct(@PathVariable long id, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        // Lấy ra id của cartDetail cẫn xóa
        long cartDetailId = id;
        // Lấy ra cartDetail cần xóa
        CartDetail cartDetail = this.cartDetailRepository.findById(cartDetailId).get();
        // Lấy ra cart của cartDetail
        Cart cart = cartDetail.getCart();
        // Xóa cartDetail
        this.cartDetailRepository.delete(cartDetail);

        if(cart.getQuantity() > 1){
            cart.setQuantity(cart.getQuantity() - 1);
            this.cartRepository.save(cart);
            session.setAttribute("quantity", cart.getQuantity());
        }else{
            this.cartRepository.delete(cart);
            session.setAttribute("quantity", 0);
        }
        return "redirect:/cart";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        long productId = id;
        String email = (String)session.getAttribute("email");
        // Truyền vào session để cập nhật dữ liệu lên giao diện trực tiếp
        this.productService.handleAddProductToCart(productId, email, session);

        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = (String)session.getAttribute("email");

        User user = this.userService.getUserByEmail(email);
        Cart cart = user.getCart();
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;
        for(CartDetail cartDetail : cartDetails){
            totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);

        return "client/cart/show";
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
