//Test to test foo POST endpoint for different scenarios

import framework.ApiResponse;
import framework.Posts;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.io.IOException;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFooPost {
    static Posts oPosts;
    Random rand = new Random();

    @BeforeClass
    public static void setUp(){
        oPosts = new Posts();
    }

    @Test
    public void testNum1() throws IOException, InterruptedException {
        ApiResponse response = oPosts.postID("1");

        //Validate If body { id: 1 }, it returns 200 code with 'bar' message
        validateResponse(response, 200, "bar");
    }

    @Test
    public void testNum2() throws IOException, InterruptedException {
        ApiResponse response = oPosts.postID("2");

        //Validate If body { id: 2 }, it returns 200 code with 'bass' message
        validateResponse(response, 200, "bass");
    }

    @Test
    public void testAnyNum() throws IOException, InterruptedException {
        int iRand = rand.nextInt();

        //Testing any int random as id
        ApiResponse response = oPosts.postID(String.valueOf(iRand));

        //Validate If body { id: anynumber }, it returns 200 code with 'unmatched' message
        validateResponse(response, 200, "unmatched");
    }

    @Test
    public void testAnyDouble() throws IOException, InterruptedException {
        double dRand = rand.nextDouble();

        //Testing any double random as id
        ApiResponse response = oPosts.postID(String.valueOf(dRand));

        //Validate If body { id: any double number }, it returns 200 code with 'unmatched' message
        validateResponse(response, 200, "unmatched");
    }

    @Test
    public void testNegativeNum() throws IOException, InterruptedException {
        //Testing any int random as id
        ApiResponse response = oPosts.postID("-10");

        //Validate If body { id: any negative number }, it returns 200 code with 'unmatched' message
        validateResponse(response, 200, "unmatched");
    }

    @Test
    public void testNoPropertyID() throws IOException, InterruptedException {
        ApiResponse response = oPosts.postID("NOPROPERTY");

        //Validate /If body does not contain property id, it returns 400 code with ERROR: JSON body must contain id property message
        validateResponse(response, 400, "JSON body must contain id property");
    }


    private void validateResponse(ApiResponse pResponse, int pCode, String pExpected){
        Assert.assertEquals(pCode, pResponse.StatusCode);
        Assert.assertTrue(pResponse.Body.contains(pExpected));
    }

}
