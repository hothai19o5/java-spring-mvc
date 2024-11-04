package vn.hoidanit.laptopshop.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.OrderDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.OrderDetailRepository;
import vn.hoidanit.laptopshop.repository.OrderRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository, CartDetailRepository cartDetailRepository, UserService userService, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> fetchProducts() {
        return this.productRepository.findAll();
    }

    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }

    public Product findProductById(long id) {
        return this.productRepository.findOneById(id);
    }

    public void handleDeleteProduct(Product product) {
        this.productRepository.delete(product);
    }

    public void handleAddProductToCart(long productId, String email, HttpSession session){
        User user = this.userService.getUserByEmail(email);

        if(user != null){
            Cart cart = this.cartRepository.findByUser(user);

            if(cart == null){
                // Nếu người dùng chưa có giỏ hàng thì tạo ra giỏ hàng
                Cart newCart = new Cart();
                newCart.setUser(user);
                newCart.setQuantity(0);

                cart = newCart;
                // Lưu vào db
                this.cartRepository.save(cart);
            }

            Optional<Product> productOptional = this.productRepository.findById(productId);

            if(productOptional.isPresent()){
                Product product = productOptional.get();
                // Tìm ra sản phẩm trong giỏ hàng
                CartDetail oldDetail = this.cartDetailRepository.findByCartAndProduct(cart, product);

                if(oldDetail == null){
                    // Nếu trong giỏ hàng chưa có sản phẩm này
                    CartDetail cartDetail = new CartDetail();

                    cartDetail.setCart(cart);
                    cartDetail.setPrice(product.getPrice());
                    cartDetail.setQuantity(1);
                    cartDetail.setProduct(product);

                    this.cartDetailRepository.save(cartDetail);
                    // Tăng số lượng giỏ hàng lên
                    long quantityCart = cart.getQuantity() + 1;
                    cart.setQuantity(quantityCart);
                    // Lưu số lượng gió hàng vào trong session để có thể cập nhật trực tiếp lên giao diện
                    session.setAttribute("quantity", quantityCart);
                    // Lưu vào trong db
                    this.cartRepository.save(cart);
                } else {
                    // Nếu giỏ hàng đã có thì chỉ tăng số lượng sản phẩm
                    oldDetail.setQuantity(oldDetail.getQuantity()+1);
                    // Lưu vào trong db
                    this.cartDetailRepository.save(oldDetail);
                }
            }
        }
    }

    public void handleUpdateCartBeforeCheckout(List<CartDetail> cartDetails){
        for(CartDetail cartDetail : cartDetails){
            Optional<CartDetail> cartDetailOptional = this.cartDetailRepository.findById(cartDetail.getId());
            if(cartDetailOptional.isPresent()){
                CartDetail cartDetailCurrent = cartDetailOptional.get();
                cartDetailCurrent.setQuantity(cartDetail.getQuantity());
                this.cartDetailRepository.save(cartDetailCurrent);
            }
        }
    }

    public void handlePlaceOrder(User user, HttpSession session, String receiverName, String receiverPhone, String receiverAddress){
        Cart cart = user.getCart();

        Order order = new Order();
        order.setUser(user);
        order.setReceiverName(receiverName);
        order.setReceiverPhone(receiverPhone);
        order.setReceiverAddress(receiverAddress);
        order.setStatus("PENDING");

        double totalPrice = 0;
        for(CartDetail cartDetail : cart.getCartDetails()){
             totalPrice += cartDetail.getPrice() * cartDetail.getQuantity();
        }
        order.setTotalPrice(totalPrice);

        this.orderRepository.save(order);

        List<CartDetail> cartDetails = cart.getCartDetails();

        for(CartDetail cartDetail : cartDetails){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(cartDetail.getProduct());
            orderDetail.setPrice(cartDetail.getPrice());
            orderDetail.setQuantity(cartDetail.getQuantity());
            this.orderDetailRepository.save(orderDetail);
        }

        this.cartDetailRepository.deleteAll(cartDetails);

        this.cartRepository.delete(cart);

        session.setAttribute("quantity", 0);
    }
}
