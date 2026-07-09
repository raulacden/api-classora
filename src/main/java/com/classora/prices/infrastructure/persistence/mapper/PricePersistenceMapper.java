package com.classora.prices.infrastructure.persistence.mapper;

import com.classora.prices.domain.model.Price;
import com.classora.prices.infrastructure.persistence.entity.PriceJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class PricePersistenceMapper {

    public Price toDomain(PriceJpaEntity entity) {
        return new Price(
                entity.getBrandId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPriceList(),
                entity.getProductId(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency()
        );
    }
}
