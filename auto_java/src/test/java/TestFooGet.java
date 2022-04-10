//Test to test foo GET endpoint for different scenarios

import framework.ApiResponse;
import framework.Gets;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFooGet {
    static Gets _gets;

    @BeforeAll
    public static void setUp(){
        _gets = new Gets();
    }

    @Test
    public void testIsDivisible() throws IOException, InterruptedException {
        //If X is divisible by 2, it returns 200 code with OK message
        ApiResponse _response = _gets.getDivisibleNum("20");

        //Validate it returns 200 code with OK message
        System.out.println("Scenario 1:" + _response.getApiRequestInfo());
        General.validateResponse(_response, 200, "OK");
    }

    @Test
    public void testNotNumber() throws IOException, InterruptedException {
        //If X is not a number, it returns 400 code with ERROR: Value X is not a number message
        String sInput = "letters";
        ApiResponse _response = _gets.getDivisibleNum(sInput);

        //Validate it returns 400 code with ERROR: Value X is not a number message
        System.out.println("Scenario 2:" + _response.getApiRequestInfo());
        General.validateResponse(_response, 400, "ERROR: Value " + sInput + " is not a number");
    }

    @Test
    public void testOtherwise() throws IOException, InterruptedException {
        String sNum = "1.5";
        //Otherwise, it returns 501 error code
        ApiResponse _response = _gets.getDivisibleNum(sNum);

        //Validate it returns 501 code
        System.out.println("Scenario 3.1:" + _response.getApiRequestInfo());
        General.validateResponse(_response, 501, "ERROR: Number " + sNum + " is not divisible by 2");

        sNum = "12.5";
        //Otherwise, it returns 501 error code
        _response = _gets.getDivisibleNum(sNum);

        //Validate it returns 501 code
        System.out.println("Scenario 3.2:" + _response.getApiRequestInfo());
        General.validateResponse(_response, 501, "ERROR: Number " + sNum + " is not divisible by 2");
    }
}
