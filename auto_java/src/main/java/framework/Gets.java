package framework;

import java.io.IOException;
import java.net.http.HttpResponse;

public class Gets extends ApiBase {

    //API to validate if number is divisible by 2
    public ApiResponse getDivisibleNum(String pNum)
            throws IOException, InterruptedException {
        HttpResponse<String> _response = execGet(urlBase() + "/api/foo/" + pNum);

        return new ApiResponse(_response);
    }


    //Add more methods according GET APIs
}
