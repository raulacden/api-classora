package com.classora.prices.infrastructure.rest;

import com.classora.prices.application.usecase.FindApplicablePriceUseCase;
import com.classora.prices.domain.model.Price;
import com.classora.prices.infrastructure.rest.dto.ApplicablePriceResponse;
import com.classora.prices.infrastructure.rest.mapper.ApplicablePriceResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/api/v1/prices")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PriceController {

    private final FindApplicablePriceUseCase findApplicablePriceUseCase;
    private final ApplicablePriceResponseMapper responseMapper;

    @GetMapping
    public ResponseEntity<ApplicablePriceResponse> findApplicablePrice(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate,
            @RequestParam Long productId,
            @RequestParam Long brandId
    ) {
        log.info(
                "Received price request: brandId={}, productId={}, applicationDate={}",
                brandId,
                productId,
                applicationDate
        );
        Price price = findApplicablePriceUseCase.execute(brandId, productId, applicationDate);
        return ResponseEntity.ok(responseMapper.toResponse(price));
    }
}
