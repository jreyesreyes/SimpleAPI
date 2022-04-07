package framework;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Posts extends ApiBase{

    //Method to validate foo API
    public ApiResponse postID(String pNum) throws IOException, InterruptedException {
        String _body = "{ \"id\": " + pNum + " }";
        if (pNum.equals("NOPROPERTY")){
            _body = "{}";
        }
        HttpResponse<String> response = execPost(urlBase() + "/api/foo/",
                _body);

        return new ApiResponse(response, _body);
    }


    //Add more methods according POST APIs
}
