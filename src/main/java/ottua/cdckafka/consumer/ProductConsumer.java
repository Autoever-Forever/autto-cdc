package ottua.cdckafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ottua.cdckafka.dto.ProductTopic;
import ottua.cdckafka.service.ProductKafkaService;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductConsumer {
    private final ProductKafkaService productKafkaService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics="db.ProductDB.product")
    public void productKafkaListener(ConsumerRecord<String, String> consumerRecord) {
        try {
            String value = consumerRecord.value();
            JsonNode node = objectMapper.readTree(value);
            ProductTopic productTopic = objectMapper.treeToValue(node, ProductTopic.class);
            handleProductTopic(productTopic);
        } catch (JsonProcessingException e) {
            log.error("jsonProcessingException", e);
        }
    }

    private void handleProductTopic(ProductTopic productTopic) {
        switch (productTopic.getCdcMetaOperation()) {
            case CREATE:
                productKafkaService.create(productTopic);
                break;
            case UPDATE:
                productKafkaService.update(productTopic);
                break;
            case DELETE:
                productKafkaService.delete(productTopic);
                break;
        }
    }
}
