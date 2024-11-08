package vn.hoidanit.laptopshop.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("cart", cart);

        return "client/cart/show";
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

    @PostMapping("/add-product-to-cart-from-product-detail")
    public String addProductToCartFromProductDetail(@RequestParam("id") long productId,
            @RequestParam("quantity") long quantity,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = (String)session.getAttribute("email");

        this.productService.handleAddProductToCartFromProductDetail(productId, email, session, quantity);
        return "redirect:/product/" + productId;
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

    @PostMapping("/confirm-checkout")
    public String getCheckoutPage(@ModelAttribute("cart") Cart cart){
        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();
        this.productService.handleUpdateCartBeforeCheckout(cartDetails);

        return "redirect:/checkout";
    }

    @GetMapping("/checkout")
    public String getCheckoutPage(Model model, HttpServletRequest request){
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
        return "client/cart/checkout";
    }

    @PostMapping("/place-order")
    public String handlePlaceOrder(HttpServletRequest request,
                                    @RequestParam("receiverName") String receiverName,
                                    @RequestParam("receiverPhone") String receiverPhone,
                                    @RequestParam("receiverAddress") String receiverAddress){
        HttpSession session = request.getSession(false);
        String email = (String)session.getAttribute("email");
        User user = this.userService.getUserByEmail(email);

        this.productService.handlePlaceOrder(user, session, receiverName, receiverPhone, receiverAddress);
        return "client/cart/thanks";
    }


    @GetMapping("/product/{id}")
    public String getProductPage(Model model, @PathVariable long id) {
        Product pr = this.productService.fetchProductById(id).get();
        model.addAttribute("product", pr);
        return "client/product/detail";
    }

}
