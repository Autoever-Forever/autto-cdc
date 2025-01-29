package ottua.cdckafka.dto;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum CdcMetaOperation {
    CREATE("c", "생성"),
    READ("r", "읽기"),
    UPDATE("u", "수정"),
    DELETE("d", "삭제"),
    ;

    private final String code;
    private final String topicCode;
    private final String displayValue;

    CdcMetaOperation(String topicCode, String displayValue) {
        this.code = this.name();
        this.topicCode = topicCode;
        this.displayValue = displayValue;
    }

    public static CdcMetaOperation fromTopicCode(String topicCode) {
        return Stream.of(values())
                .filter(enumTopicCode -> topicCode.equalsIgnoreCase(enumTopicCode.topicCode))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("해당 코드에 대한 정의가 없습니다.: " + topicCode)
                );
    }
}
