package com.classora.prices.application.usecase;

import com.classora.prices.application.exception.PriceNotFoundException;
import com.classora.prices.domain.model.Price;
import com.classora.prices.domain.port.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FindApplicablePriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public Price execute(Long brandId, Long productId, LocalDateTime applicationDate) {
        return priceRepositoryPort.findApplicablePrice(brandId, productId, applicationDate)
                .orElseThrow(() -> new PriceNotFoundException(brandId, productId, applicationDate));
    }
}
