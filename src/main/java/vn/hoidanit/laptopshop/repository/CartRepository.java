package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.Cart;
import vn.hoidanit.laptopshop.domain.User;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
