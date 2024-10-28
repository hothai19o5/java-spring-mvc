package vn.hoidanit.laptopshop.service;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Service;

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

    public void handleAddProductToCart(long productId, String email){
        User user = this.userService.getUserByEmail(email);

        if(user != null){
            Cart cart = this.cartRepository.findByUser(user);

            if(cart == null){
                Cart newCart = new Cart();
                newCart.setUser(user);
                newCart.setQuantity(1);

                cart = newCart;

                this.cartRepository.save(newCart);
            }

            Product product = this.productRepository.findOneById(productId);

            CartDetail cartDetail = new CartDetail();

            cartDetail.setCart(cart);
            cartDetail.setPrice(product.getPrice());
            cartDetail.setQuantity(cart.getQuantity());
            cartDetail.setProduct(product);

            this.cartDetailRepository.save(cartDetail);
        }
    }
}
