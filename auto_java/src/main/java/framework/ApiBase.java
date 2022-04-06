package framework;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiBase {

    public String urlBase(){
        return "http://localhost:9999";
    }

    //Execute any GET endpoint according URL by parameter
    public HttpResponse<String> exec_get(String pURL) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(pURL))
                .build();

        return client.send(request,
                HttpResponse.BodyHandlers.ofString());
    }

    //Execute any POST endpoint according URL by parameter
    public HttpResponse<String> exec_post(String pURL, String pBody) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(pURL))
                .POST(HttpRequest.BodyPublishers.ofString(pBody))
                .header("Content-type", "application/json")
                .build();

        return client.send(request,
                HttpResponse.BodyHandlers.ofString());

    }

}
