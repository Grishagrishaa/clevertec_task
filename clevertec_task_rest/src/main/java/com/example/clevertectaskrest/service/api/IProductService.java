package com.example.clevertectaskrest.service.api;

import com.example.clevertectaskrest.dao.entity.Product;
import com.example.clevertectaskrest.service.dto.ReadProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Product getById(Long id);
    Page<Product> getAll(Pageable pageable);
    Product save(Product product);
    void deleteById(Long id);
    Product update(Long id, Product product);
}
