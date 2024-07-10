package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeHistoryResponse {
    @JsonProperty("score")
    private int score;

    public int getScore() {
        return score;
    }

    public String getDate() {
        return date;
    }

    public boolean isFini() {
        return fini;
    }

    @JsonProperty("date")
    private String date;

    @JsonProperty("fini")
    private boolean fini;

}
