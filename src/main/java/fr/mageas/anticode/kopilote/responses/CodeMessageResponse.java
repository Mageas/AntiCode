package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeMessageResponse {
    public CodeBResponse getB() {
        return b;
    }

    @JsonProperty("b")
    private CodeBResponse b;

}
