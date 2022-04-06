package framework;

import java.net.URI;
import java.net.http.HttpResponse;

public class ApiResponse {
    public int StatusCode;
    public String Body;
    public URI Uri;

    public ApiResponse(HttpResponse<String> pResponse){
        this.StatusCode = pResponse.statusCode();
        this.Body = pResponse.body();
        this.Uri = pResponse.uri();
    }

}
