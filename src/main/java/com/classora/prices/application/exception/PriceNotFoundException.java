package com.classora.prices.application.exception;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {

    public PriceNotFoundException(Long brandId, Long productId, LocalDateTime applicationDate) {
        super("No applicable price found for brandId=%d, productId=%d and applicationDate=%s."
                .formatted(brandId, productId, applicationDate));
    }
}
