package ottua.cdckafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import ottua.cdckafka.entity.Status;

import java.time.LocalDateTime;

@Getter
public class SeatTopic extends CommonSyncTopic {
    @JsonProperty("id")
    private String id;

    @JsonProperty("product_id")
    private String product_id;

    @JsonProperty("date")
    private LocalDateTime date;

    @JsonProperty("reserved_seats")
    private Integer reservedSeats;

    @JsonProperty("total_seats")
    private Integer totalSeats;

    @JsonProperty("price")
    private String price;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @JsonProperty("status")
    private Status status;
}
