package ottua.cdckafka.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommonSyncTopic {
    @JsonProperty("__deleted")
    private Boolean deleted;
    @JsonProperty("cdc_meta_op")
    private String cdcMetaOp;
    @JsonProperty("cdc_meta_table")
    private String cdcMetaTable;
    @JsonProperty("cdc_meta_source_ts_ms")
    private LocalDateTime cdcMetaSourceTsMs;

    public CdcMetaOperation getCdcMetaOperation() {
        return CdcMetaOperation.fromTopicCode(cdcMetaOp);
    }
}
