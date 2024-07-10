package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginConnexionResponse {
    public String getAccessToken() {
        return accessToken;
    }

    public String getState() {
        return state;
    }

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("state")
    private String state;

}
