package com.example.cosmeticsshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.cosmeticsshop.domain.Product;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
    Product findByName(String name);

    boolean existsByName(String name);

    Page<Product> findByCategoryId(Long id, Pageable pageable);

<<<<<<< HEAD
    Page<Product> findByIdNotIn(List<Long> ids, Pageable pageable);
=======
>>>>>>> cb1e94d527d0d4a608c4adab92e0c6ca81fbaaf1
}
