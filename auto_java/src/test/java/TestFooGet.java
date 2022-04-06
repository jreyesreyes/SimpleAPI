//Test to test foo GET endpoint for different scenarios

import framework.ApiResponse;
import framework.Gets;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFooGet {
    static Gets oGets;

    @BeforeClass
    public static void setUp(){
        oGets = new Gets();
    }

    @Test
    public void testIsDivisible() throws IOException, InterruptedException {
        //If X is divisible by 2, it returns 200 code with OK message
        ApiResponse response = oGets.getDivisibleNum("20");

        //Validate it returns 200 code with OK message
        validateResponse(response, 200, "OK");
    }

    @Test
    public void testNotNumber() throws IOException, InterruptedException {
        //If X is not a number, it returns 400 code with ERROR: Value X is not a number message
        String sInput = "letters";
        ApiResponse response = oGets.getDivisibleNum(sInput);

        //Validate it returns 400 code with ERROR: Value X is not a number message
        validateResponse(response, 400, "ERROR: Value " + sInput + " is not a number");
    }

    @Test
    public void testOtherwise() throws IOException, InterruptedException {
        String sNum = "1.5";
        //Otherwise, it returns 501 error code
        ApiResponse response = oGets.getDivisibleNum(sNum);

        //Validate it returns 501 code
        validateResponse(response, 501, "ERROR: Number " + sNum + " is not divisible by 2");

        sNum = "12.5";
        //Otherwise, it returns 501 error code
        response = oGets.getDivisibleNum(sNum);

        //Validate it returns 501 code
        validateResponse(response, 501, "ERROR: Number " + sNum + " is not divisible by 2");
    }

    private void validateResponse(ApiResponse pResponse, int pCode, String pExpected){
        Assert.assertEquals(pCode, pResponse.StatusCode);
        Assert.assertEquals(pExpected, pResponse.Body);
    }

}
