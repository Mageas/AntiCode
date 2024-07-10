package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginMessageResponse {
    public LoginConnexionResponse getConnexion() {
        return connexion;
    }

    public LoginClientResponse getClient() {
        return client;
    }

    public LoginStudentResponse getStudent() {
        return student;
    }

    @JsonProperty("connexion")
    private LoginConnexionResponse connexion;

    @JsonProperty("client")
    private LoginClientResponse client;

    @JsonProperty("student")
    private LoginStudentResponse student;
}
