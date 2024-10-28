package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hoidanit.laptopshop.domain.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
