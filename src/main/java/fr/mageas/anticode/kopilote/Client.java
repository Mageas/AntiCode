package fr.mageas.anticode.kopilote;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import fr.mageas.anticode.kopilote.responses.CodeHistoryResponse;
import fr.mageas.anticode.kopilote.responses.CodeResponse;
import fr.mageas.anticode.kopilote.responses.LoginResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    private static final String API_URL = "https://api.ediser.com/api/v2/students/connexion/product/secure";

    private final String accessToken;
    private final String state;
    private final String numEnpc;
    private final String enpcId;

    public Client(String login, String password) throws KopiloteException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(getLoginBody(login, password)))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new KopiloteException();
            }

            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            LoginResponse responseMessage = objectMapper.readValue(responseBody, LoginResponse.class);

            this.accessToken = responseMessage.getMessage().getConnexion().getAccessToken();
            this.state = responseMessage.getMessage().getConnexion().getState();
            this.numEnpc = responseMessage.getMessage().getClient().getNumEnpc();
            this.enpcId = responseMessage.getMessage().getStudent().getEnpcId();
        } catch (Exception e) {
            throw new KopiloteException();
        }
    }

    private static String getLoginBody(String login, String password) {
        JsonObject payload = new JsonObject();
        payload.addProperty("info_connexion", "{\"deviceInfo\":{\"userAgent\":\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:127.0) Gecko/20100101 Firefox/127.0\",\"os\":\"Mac\",\"browser\":\"Firefox\",\"device\":\"Macintosh\",\"os_version\":\"mac-os-x-15\",\"browser_version\":\"127.0\",\"deviceType\":\"desktop\",\"orientation\":\"landscape\"},\"support\":{\"isMobile\":false,\"isTablet\":false,\"isDesktopDevice\":true}}");
        payload.addProperty("login", login);
        payload.addProperty("password", password);
        payload.addProperty("produit_id", 1661);

        Gson gson = new Gson();
        return gson.toJson(payload);
    }

    public List<CodeHistoryResponse> retrieveCodeSessions() throws KopiloteException {
        String apiUrl = String.format("https://api.ediser.com/api/enpc/center/%s/prepacode/%s/stats", numEnpc, enpcId);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl))
            .header("Authorization", "Bearer " + accessToken)
            .header("Content-Type", "application/json")
            .header("X-Csrf-Token", state)
            .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:127.0) Gecko/20100101 Firefox/127.0")
            .GET()
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new KopiloteException();
            }

            String responseBody = response.body();

            ObjectMapper objectMapper = new ObjectMapper();
            CodeResponse responseMessage = objectMapper.readValue(responseBody, CodeResponse.class);

            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

            return responseMessage.getMessage().getB().getStats().getHistory().stream().filter(history -> LocalDate.parse(history.getDate(), formatter).isEqual(today) || LocalDate.parse(history.getDate(), formatter).isAfter(today)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new KopiloteException();
        }
    }

}
