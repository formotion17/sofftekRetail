package com.demo.Comercio.repository;

import com.demo.Comercio.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p " +
            "WHERE p.product_id = :productId " +
            "AND p.brand_id = :brandId " +
            "AND p.start_date <= :fechaAplicacion " +
            "AND p.end_date >= :fechaAplicacion "+
            "ORDER BY p.priority DESC")
    List<Product> findProductByConditions( @Param("fechaAplicacion") Date fechaAplicacion,
                                            @Param("productId") Long productId,
                                           @Param("brandId") BigDecimal brandId);
}
