package com.example.clevertectaskrest.dao.api;

import com.example.clevertectaskrest.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
