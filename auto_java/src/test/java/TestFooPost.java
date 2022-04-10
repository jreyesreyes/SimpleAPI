//Test to test foo POST endpoint for different scenarios

import framework.ApiResponse;
import framework.Posts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.io.IOException;
import java.util.Random;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFooPost {
    static Posts _posts;
    Random _rand = new Random();

    @BeforeAll
    public static void setUp(){
        _posts = new Posts();
    }

    @Test
    public void testNum1() throws IOException, InterruptedException {
        ApiResponse _response = _posts.postID("1");

        //Validate If body { id: 1 }, it returns 200 code with 'bar' message
        System.out.println("Scenario 1: " + _response.getApiRequestInfo());
        General.validateResponse(_response, 200, "bar");
    }

    @Test
    public void testNum2() throws IOException, InterruptedException {
        ApiResponse _response = _posts.postID("2");

        //Validate If body { id: 2 }, it returns 200 code with 'bass' message
        System.out.println("Scenario 2: " + _response.getApiRequestInfo());
        General.validateResponse(_response, 200, "bass");
    }

    @Test
    public void testAnyNum() throws IOException, InterruptedException {
        int _randInt = _rand.nextInt();

        //Testing any int random as id
        ApiResponse response = _posts.postID(String.valueOf(_randInt));

        //Validate If body { id: anynumber }, it returns 200 code with 'unmatched' message
        System.out.println("Scenario 3: " + response.getApiRequestInfo());
        General.validateResponse(response, 200, "unmatched");
    }

    @Test
    public void testAnyDouble() throws IOException, InterruptedException {
        double _randDouble = _rand.nextDouble();

        //Testing any double random as id
        ApiResponse _response = _posts.postID(String.valueOf(_randDouble));

        //Validate If body { id: any double number }, it returns 200 code with 'unmatched' message
        System.out.println("Scenario 4: " + _response.getApiRequestInfo());
        General.validateResponse(_response, 200, "unmatched");
    }

    @Test
    public void testNegativeNum() throws IOException, InterruptedException {
        //Testing any int random as id
        ApiResponse _response = _posts.postID("-10");

        //Validate If body { id: any negative number }, it returns 200 code with 'unmatched' message
        System.out.println("Scenario 5: " + _response.getApiRequestInfo());
        General.validateResponse(_response, 200, "unmatched");
    }

    @Test
    public void testNoPropertyID() throws IOException, InterruptedException {
        //Testing no property ID on body request
        ApiResponse _response = _posts.postID("NOPROPERTY");

        //Validate If body does not contain property id, it returns 400 code with ERROR: JSON body must contain id property message
        System.out.println("Scenario 6: " + _response.getApiRequestInfo());
        General.validateResponse(_response, 400, "ERROR: JSON body must contain id property");
    }

}
