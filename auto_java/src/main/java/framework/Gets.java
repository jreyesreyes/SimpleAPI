package framework;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Gets extends ApiBase {

    //API to validate if number is divisible by 2
    public ApiResponse getDivisibleNum(String pNum)
            throws IOException, InterruptedException {
        HttpResponse<String> response = exec_get(urlBase() + "/api/foo/" + pNum);

        return new ApiResponse(response);
    }


    //Add more methods according GET APIs
}
