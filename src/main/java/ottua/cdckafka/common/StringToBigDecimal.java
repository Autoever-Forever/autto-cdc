package ottua.cdckafka.common;

import java.math.BigDecimal;

public class StringToBigDecimal {
    public static BigDecimal stringToBigDecimal(String value) {
        if(value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }

        return new BigDecimal(value);
    }
}
