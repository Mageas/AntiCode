package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeResponse {
    public CodeMessageResponse getMessage() {
        return message;
    }

    @JsonProperty("message")
    private CodeMessageResponse message;

}
