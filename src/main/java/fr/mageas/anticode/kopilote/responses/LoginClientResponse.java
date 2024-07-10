package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginClientResponse {
    public String getNumEnpc() {
        return numEnpc;
    }

    @JsonProperty("num_enpc")
    private String numEnpc;

}
