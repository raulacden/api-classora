package com.classora.prices.infrastructure.persistence.repository;

import com.classora.prices.infrastructure.persistence.entity.PriceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SpringDataPriceRepository extends JpaRepository<PriceJpaEntity, Long> {

    @Query("""
            SELECT p
            FROM PriceJpaEntity p
            WHERE p.brandId = :brandId
            AND p.productId = :productId
            AND :applicationDate BETWEEN p.startDate AND p.endDate
            ORDER BY p.priority DESC
            """)
    List<PriceJpaEntity> findApplicablePrices(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("applicationDate") LocalDateTime applicationDate
    );
}
