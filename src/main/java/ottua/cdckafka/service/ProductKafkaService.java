package ottua.cdckafka.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ottua.cdckafka.common.UuidFormatter;
import ottua.cdckafka.dto.ProductTopic;
import ottua.cdckafka.entity.Product;
import ottua.cdckafka.repository.ProductRepository;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductKafkaService {
    private final ProductRepository productRepository;

    public void create(ProductTopic productTopic) {
        productRepository.save(new Product(productTopic));
    }

    public void update(ProductTopic productTopic) {
        productRepository.findById(UUID.fromString(UuidFormatter.replaceUuid(productTopic.getId()))).ifPresent(
                productInfo -> productInfo.setFields(productTopic)
        );
    }

    public void delete(ProductTopic productTopic) {
        Product product = productRepository.findById(UUID.fromString(UuidFormatter.replaceUuid(productTopic.getId())))
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productRepository.delete(product);
    }
}
