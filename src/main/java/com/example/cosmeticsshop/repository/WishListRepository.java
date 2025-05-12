package com.example.cosmeticsshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1

import com.example.cosmeticsshop.domain.Product;
import com.example.cosmeticsshop.domain.User;
import com.example.cosmeticsshop.domain.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long>, JpaSpecificationExecutor<WishList> {
    WishList findByUserAndProductId(User user, Long productId);

    List<WishList> findByUser(User user);

    boolean existsByUserAndProduct(User user, Product product);

    void deleteByUserAndProduct(User user, Product product);
<<<<<<< HEAD

    @Modifying
    @Query("DELETE FROM WishList w WHERE w.user = :user")
    void deleteAllByUser(@Param("user") User user);
=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
}
