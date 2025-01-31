package ottua.cdckafka.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ottua.cdckafka.common.UuidFormatter;
import ottua.cdckafka.dto.ProductTopic;
import ottua.cdckafka.dto.SeatTopic;
import ottua.cdckafka.entity.Product;
import ottua.cdckafka.entity.SeatByDateInventory;
import ottua.cdckafka.repository.*;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SeatKafkaService {
    private final ProductRepository productRepository;
    private final SeatRepository seatRepository;

    public void create(SeatTopic seatTopic) {
        Product product = productRepository.findById(UUID.fromString(UuidFormatter.replaceUuid(seatTopic.getProduct_id())))
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        SeatByDateInventory seatByDateInventory = new SeatByDateInventory(seatTopic, product);
        seatRepository.save(seatByDateInventory);
    }

    public void update(SeatTopic seatTopic) {
        seatRepository.findById(UUID.fromString(UuidFormatter.replaceUuid(seatTopic.getId()))).ifPresent(
                seatByDateInventory -> {
                    Product product = productRepository.findById(UUID.fromString(UuidFormatter.replaceUuid(seatTopic.getProduct_id())))
                            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
                    seatByDateInventory.setFields(seatTopic, product);
                }
        );
    }

    public void delete(SeatTopic seatTopic) {
        SeatByDateInventory seat = seatRepository.findById(UUID.fromString(UuidFormatter.replaceUuid(seatTopic.getId())))
                .orElseThrow(() -> new EntityNotFoundException("SeatId not found"));
        seatRepository.delete(seat);

        seatRepository.findById(UUID.fromString(UuidFormatter.replaceUuid(seatTopic.getId()))).ifPresent(seatRepository::delete);
    }
}
