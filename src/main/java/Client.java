import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ExampleModel;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        List<ExampleModel> exampleModels = client.fetchModels("id ");
        for (ExampleModel exampleModel : exampleModels) {
            System.out.println(exampleModel);
        }
    }

    /*public List<ExampleModel> fetchModels(String... modelAttributes) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();


        StringBuilder attributesBuilder =  new StringBuilder();
        for(String model : modelAttributes) {
            attributesBuilder.append(model + " ");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8080/graphql"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{ \"query\": \"{ models { " + attributesBuilder.toString() + " } }\" }"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        System.out.println("Response Body: " + responseBody);

        ObjectMapper objectMapper = new ObjectMapper();
        var result = objectMapper.readValue( responseBody ,
                new TypeReference<Map>( ) { }
        );

        Map<String, Object> dataMap = (Map<String, Object>) result.get("data");
        List<LinkedHashMap> modelsList = (List<LinkedHashMap>) dataMap.get("models");

        List<ExampleModel> models = new ArrayList<>();
        for(LinkedHashMap modelData: modelsList) {
            ExampleModel model = objectMapper.convertValue(modelData, ExampleModel.class);
            models.add(model);
        }

        return models;
    }*/
    public List<ExampleModel> fetchModels(String... modelAttributes) throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        String attributes = String.join(" ", modelAttributes);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8081/graphql"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "{ \"query\": \"{ models { " + attributes + " } }\" }"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String responseBody = response.body();
        System.out.println("Response Body: " + responseBody);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(responseBody);

        JsonNode modelsNode = rootNode.path("data").path("models");

        return objectMapper.convertValue(modelsNode, new TypeReference<List<ExampleModel>>() {});
    }
}
