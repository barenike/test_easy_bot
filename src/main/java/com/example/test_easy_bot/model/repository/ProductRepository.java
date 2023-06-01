package com.example.test_easy_bot.model.repository;

import com.example.test_easy_bot.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Query("select p from ProductEntity p where p.id = ?1")
    ProductEntity findByProductId(Integer id);
}
