package ottua.cdckafka.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ottua.cdckafka.common.StringToBigDecimal;
import ottua.cdckafka.common.UuidFormatter;
import ottua.cdckafka.dto.SeatTopic;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Getter
@NoArgsConstructor
@Table(name="seat_by_date_inventory")
public class SeatByDateInventory {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName="id")
    private Product product;

    private LocalDateTime date;

    private Integer reservedSeats;

    private Integer totalSeats;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private String currencyCode;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private Status status;

    public SeatByDateInventory (SeatTopic seatTopic, Product product){
        this.id = UUID.fromString(UuidFormatter.replaceUuid(seatTopic.getId()));
        this.product = product;
        this.date = seatTopic.getDate();
        this.reservedSeats = seatTopic.getReservedSeats();
        this.totalSeats = seatTopic.getTotalSeats();
        this.price = StringToBigDecimal.stringToBigDecimal(seatTopic.getPrice());
        this.currencyCode = seatTopic.getCurrencyCode();
        this.createdDate = seatTopic.getCreatedDate();
        this.lastUpdate = seatTopic.getLastUpdate();
        this.status = seatTopic.getStatus();
    }

    public void setFields(SeatTopic seatTopic, Product product){
        this.id = UUID.fromString(UuidFormatter.replaceUuid(seatTopic.getId()));
        this.product = product;
        this.date = seatTopic.getDate();
        this.reservedSeats = seatTopic.getReservedSeats();
        this.totalSeats = seatTopic.getTotalSeats();
        this.price = StringToBigDecimal.stringToBigDecimal(seatTopic.getPrice());
        this.currencyCode = seatTopic.getCurrencyCode();
        this.createdDate = seatTopic.getCreatedDate();
        this.lastUpdate = seatTopic.getLastUpdate();
        this.status = seatTopic.getStatus();
    }
}
