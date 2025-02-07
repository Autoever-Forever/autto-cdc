package ottua.cdckafka.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ottua.cdckafka.common.UuidFormatter;
import ottua.cdckafka.dto.ProductTopic;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    private String title;

    private String location;

    private String runningTime;

    private Integer ticketingLimit;

    private LocalDateTime ticketingOpenDate;

    private LocalDateTime ticketingCloseDate;

    private LocalDateTime performStartDate;

    private LocalDateTime performEndDate;

    private LocalDateTime createdDate;

    private LocalDateTime lastUpdate;

    private String thumbnailUrl;

    private String posterUrl;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Product (ProductTopic productTopic) {
        this.id = UUID.fromString(UuidFormatter.replaceUuid(productTopic.getId()));
        this.title = productTopic.getTitle();
        this.location = productTopic.getLocation();
        this.runningTime = productTopic.getRunningTime();
        this.ticketingLimit = productTopic.getTicketingLimit();
        this.ticketingOpenDate = productTopic.getTicketingOpenDate();
        this.ticketingCloseDate = productTopic.getTicketingCloseDate();
        this.performStartDate = productTopic.getPerformStartDate();
        this.performEndDate = productTopic.getPerformEndDate();
        this.createdDate = productTopic.getCreatedDate();
        this.lastUpdate = productTopic.getLastUpdate();
        this.thumbnailUrl = productTopic.getThumbnailUrl();
        this.posterUrl = productTopic.getPosterUrl();
        this.status = productTopic.getStatus();
    }

    public void setFields(ProductTopic productTopic) {
        this.id = UUID.fromString(UuidFormatter.replaceUuid(productTopic.getId()));
        this.title = productTopic.getTitle();
        this.location = productTopic.getLocation();
        this.runningTime = productTopic.getRunningTime();
        this.ticketingLimit = productTopic.getTicketingLimit();
        this.ticketingOpenDate = productTopic.getTicketingOpenDate();
        this.ticketingCloseDate = productTopic.getTicketingCloseDate();
        this.performStartDate = productTopic.getPerformStartDate();
        this.performEndDate = productTopic.getPerformEndDate();
        this.createdDate = productTopic.getCreatedDate();
        this.lastUpdate = productTopic.getLastUpdate();
        this.thumbnailUrl = productTopic.getThumbnailUrl();
        this.posterUrl = productTopic.getPosterUrl();
        this.status = productTopic.getStatus();
    }
}

