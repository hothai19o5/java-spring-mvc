package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User hothai);

    List<User> findOneByEmail(String email);

    User findOneById(long id);

    Boolean existsByEmail(String email);

    User findByEmail(String email);
}
