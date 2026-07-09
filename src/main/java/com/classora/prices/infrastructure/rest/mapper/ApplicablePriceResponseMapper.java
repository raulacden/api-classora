package com.classora.prices.infrastructure.rest.mapper;

import com.classora.prices.domain.model.Price;
import com.classora.prices.infrastructure.rest.dto.ApplicablePriceResponse;
import org.springframework.stereotype.Component;

@Component
public class ApplicablePriceResponseMapper {

    public ApplicablePriceResponse toResponse(Price price) {
        return new ApplicablePriceResponse(
                price.productId(),
                price.brandId(),
                price.priceList(),
                price.startDate(),
                price.endDate(),
                price.price(),
                price.currency()
        );
    }
}
