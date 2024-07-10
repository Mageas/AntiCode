package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginStudentResponse {
    public String getEnpcId() {
        return enpcId;
    }

    @JsonProperty("enpc_id")
    private String enpcId;

}
