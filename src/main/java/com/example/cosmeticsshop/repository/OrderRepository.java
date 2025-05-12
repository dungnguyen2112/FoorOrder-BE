package com.example.cosmeticsshop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.cosmeticsshop.domain.Order;
import com.example.cosmeticsshop.domain.Product;
import com.example.cosmeticsshop.domain.User;

public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
    List<Order> findByUser(User user);

<<<<<<< HEAD
    Order findByPaymentRef(String paymentRef);
=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
}
