package com.example.clevertectaskrest.dao.api;

import com.example.clevertectaskrest.dao.entity.SaleCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleCardRepository extends JpaRepository<SaleCard, Long> {
}
