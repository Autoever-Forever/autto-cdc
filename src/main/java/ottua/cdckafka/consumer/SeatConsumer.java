package ottua.cdckafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ottua.cdckafka.dto.SeatTopic;
import ottua.cdckafka.service.SeatKafkaService;

@Slf4j
@Component
@RequiredArgsConstructor
public class SeatConsumer {
    private final SeatKafkaService seatKafkaService;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics="db.AuttoDB.seat_by_date_inventory")
    public void seatKafkaListener(ConsumerRecord<String, String> consumerRecord) {
        try {
            String value = consumerRecord.value();
            JsonNode node = objectMapper.readTree(value);

            SeatTopic seatTopic = objectMapper.treeToValue(node, SeatTopic.class);
            handleSeatTopic(seatTopic);
        } catch (JsonProcessingException e) {
            log.error("jsonProcessingException", e);
        }
    }

    private void handleSeatTopic(SeatTopic seatTopic) {
        switch (seatTopic.getCdcMetaOperation()) {
            case CREATE:
                seatKafkaService.create(seatTopic);
                break;
            case UPDATE:
                seatKafkaService.update(seatTopic);
                break;
            case DELETE:
                seatKafkaService.delete(seatTopic);
                break;
        }
    }
}
