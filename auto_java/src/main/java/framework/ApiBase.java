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
    public HttpResponse<String> execGet(String pURL) throws IOException, InterruptedException {
        HttpClient _client = HttpClient.newHttpClient();
        HttpRequest _request = HttpRequest.newBuilder(URI.create(pURL))
                .build();

        return _client.send(_request,
                HttpResponse.BodyHandlers.ofString());
    }

    //Execute any POST endpoint according URL by parameter
    public HttpResponse<String> execPost(String pURL, String pBody) throws IOException, InterruptedException {
        HttpClient _client = HttpClient.newHttpClient();
        HttpRequest _request = HttpRequest.newBuilder(URI.create(pURL))
                .POST(HttpRequest.BodyPublishers.ofString(pBody))
                .header("Content-type", "application/json")
                .build();

        return _client.send(_request,
                HttpResponse.BodyHandlers.ofString());

    }

}
