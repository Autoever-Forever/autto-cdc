package ottua.cdckafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ottua.cdckafka.entity.Status;

import java.time.LocalDateTime;

@Getter
public class ProductTopic extends CommonSyncTopic{
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("location")
    private String location;

    @JsonProperty("running_time")
    private String runningTime;

    @JsonProperty("ticketing_limit")
    private Integer ticketingLimit;

    @JsonProperty("ticketing_open_date")
    private LocalDateTime ticketingOpenDate;

    @JsonProperty("ticketing_close_date")
    private LocalDateTime ticketingCloseDate;

    @JsonProperty("perform_start_date")
    private LocalDateTime performStartDate;

    @JsonProperty("perform_end_date")
    private LocalDateTime performEndDate;

    @JsonProperty("created_date")
    private LocalDateTime createdDate;

    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    @JsonProperty("poster_url")
    private String posterUrl;

    @JsonProperty("status")
    private Status status;
}
