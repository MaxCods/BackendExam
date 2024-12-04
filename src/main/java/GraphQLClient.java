import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.ExampleModel;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GraphQLClient {
    public static void main(String[] args) throws Exception {
        List<ExampleModel> result = fetchPersons("id name");
        for(ExampleModel person : result){
            System.out.println(person.getName());
        }
    }

    public static List<ExampleModel> fetchPersons(String personAttributes) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();




        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8081/graphql"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString( "{ \"query\": \"{ models { " + personAttributes + " } }\" }"))
                .build();


        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.body();
        System.out.println("Response Body: " + responseBody);

        ObjectMapper objectMapper = new ObjectMapper();
        var result = objectMapper.readValue( responseBody ,
                new TypeReference<Map>( ) { }
        );

        Map<String, Object> dataMap = (Map<String, Object>) result.get("data");
        List<LinkedHashMap> personsList = (List<LinkedHashMap>) dataMap.get("models");

        List<ExampleModel> persons = new ArrayList<>();
        for(LinkedHashMap personData: personsList) {
            ExampleModel person = objectMapper.convertValue(personData, ExampleModel.class);
            persons.add(person);
        }

        return persons;
    }
}
