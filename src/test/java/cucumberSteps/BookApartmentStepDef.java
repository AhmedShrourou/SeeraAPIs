package cucumberSteps;

import Base.APIBaseSteps;
import apiHelper.DateTimeHelper;
import apiHelper.HttpServiceResponse;
import apiHelper.HttpServicesBuilder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;
import org.junit.Assert;

import static apiHelper.StateHelper.getStoryState;
import static apiHelper.StateHelper.setStoryState;

public class BookApartmentStepDef extends APIBaseSteps {

    ThreadLocal<HttpServicesBuilder> httpServicesCommonBuilder=null;

    public void beforeStartAPITest(final String fileName){
        apiHelper.StateHelper.clearStoryState();
        httpServicesCommonBuilder= new ThreadLocal<HttpServicesBuilder>() {
            @Override
            public HttpServicesBuilder initialValue() {
                String pathContent = "apiFiles-Json/" +fileName;
                try {
                    return new HttpServicesBuilder(pathContent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }


    @Given("^From Booking API, Set API Body\\.$")
    public void setBookingAPIBody(){

        setStoryState("roomArray",bookApartmentAPI.generateRoomArray());
        setStoryState("checkin", DateTimeHelper.getCurrentDate("dd-MM-yyyy"));
        setStoryState("checkout",DateTimeHelper.getFutureDate("dd-MM-yyyy"));
    }




  @When("^From Booking API, Call Book Rooms API\\.$")
    public void callBookRooms(){
        beforeStartAPITest("seeraAPIs.json");
        HttpServiceResponse response = (httpServicesCommonBuilder
                .get()
                .build("book_room")
                .resolveServiceRequestBody("{checkin}",getStoryState("checkin").toString())
                .resolveServiceRequestBody("{checkout}",getStoryState("checkout").toString())
                .resolveServiceRequestBody("{roomArray}",getStoryState("roomArray").toString())
                .execute());

        setStoryState("Status_Code",response.getResponseResult().getStatusCode());
        JSONObject jsonResponse = new JSONObject(response.getResultAsString());
        setStoryState("Response",jsonResponse);
    }

    @Then("^Verify API (.*) Status Code\\.$")
    public void verifyStatusCode(String statusCode){
        Assert.assertEquals("Invalid Resonse Code",statusCode,getStoryState("Status_Code").toString());
    }


    @Then("^Verify Book Apartment API Response Body\\.$")
    public void verifyBookApartmentAPIResponseBody(){
        bookApartmentAPI.assertResponseBody();
    }

}
