package fr.mageas.anticode.kopilote.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeStatsResponse {
    public List<CodeHistoryResponse> getHistory() {
        return history;
    }

    @JsonProperty("historiqueSeries")
    private List<CodeHistoryResponse> history;

}
