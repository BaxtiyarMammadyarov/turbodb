package az.mycompany.turbodatabaseservice.dto.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum Valyuta {

    AZN("AZN"),
    USD("USD"),
    EUR("EUR");

    private String code;

    Valyuta(String code) {
        this.code = code;
    }

    @JsonCreator
    public static Valyuta decode(final String code) {
        return Stream.of(Valyuta.values()).filter(targetEnum -> targetEnum.code.equals(code)).findFirst().orElse(null);
    }

    @JsonValue
    public String getCode() {
        return code;
    }
}

