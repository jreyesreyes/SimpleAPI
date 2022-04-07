package framework;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Posts extends ApiBase{

    //Method to validate foo API
    public ApiResponse postID(String pNum) throws IOException, InterruptedException {
        String sBody = "{ \"id\": " + pNum + " }";
        if (pNum.equals("NOPROPERTY")){
            sBody = "{}";
        }
        HttpResponse<String> response = exec_post(urlBase() + "/api/foo/",
                sBody);

        return new ApiResponse(response);
    }


    //Add more methods according POST APIs
}
