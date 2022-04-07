import framework.ApiResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class General {

    public static void validateResponse(ApiResponse pResponse, int pCode, String pExpected){
        assertEquals(pCode, pResponse._statusCode);
        assertEquals(pExpected, pResponse._body);
    }
}
