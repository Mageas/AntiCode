package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeBResponse {
    public CodeStatsResponse getStats() {
        return stats;
    }

    @JsonProperty("stats")
    CodeStatsResponse stats;

}
