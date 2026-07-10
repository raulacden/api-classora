package com.classora.prices.application.usecase;

import com.classora.prices.application.exception.PriceNotFoundException;
import com.classora.prices.domain.model.Price;
import com.classora.prices.domain.port.PriceRepositoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class FindApplicablePriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public Price execute(Long brandId, Long productId, LocalDateTime applicationDate) {
        Price price = priceRepositoryPort.findApplicablePrice(brandId, productId, applicationDate)
                .orElseThrow(() -> {
                    log.warn(
                            "No applicable price found: brandId={}, productId={}, applicationDate={}",
                            brandId,
                            productId,
                            applicationDate
                    );
                    return new PriceNotFoundException(brandId, productId, applicationDate);
                });

        log.info(
                "Applicable price found: brandId={}, productId={}, applicationDate={}, priceList={}, price={}, currency={}",
                brandId,
                productId,
                applicationDate,
                price.priceList(),
                price.price(),
                price.currency()
        );
        return price;
    }
}
