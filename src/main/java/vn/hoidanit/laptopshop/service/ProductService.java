package vn.hoidanit.laptopshop.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.CartDetail;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.CartDetailRepository;
import vn.hoidanit.laptopshop.repository.CartRepository;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository, CartRepository cartRepository, CartDetailRepository cartDetailRepository, UserService userService) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
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
}
