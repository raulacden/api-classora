package com.classora.prices.infrastructure.persistence;

import com.classora.prices.domain.model.Price;
import com.classora.prices.domain.port.PriceRepositoryPort;
import com.classora.prices.infrastructure.persistence.mapper.PricePersistenceMapper;
import com.classora.prices.infrastructure.persistence.repository.SpringDataPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaPriceRepositoryAdapter implements PriceRepositoryPort {

    private final SpringDataPriceRepository springDataPriceRepository;
    private final PricePersistenceMapper pricePersistenceMapper;

    @Override
    public Optional<Price> findApplicablePrice(Long brandId, Long productId, LocalDateTime applicationDate) {
        return springDataPriceRepository.findApplicablePrices(brandId, productId, applicationDate)
                .stream()
                .findFirst()
                .map(pricePersistenceMapper::toDomain);
    }
}
