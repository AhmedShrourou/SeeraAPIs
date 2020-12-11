package cucumberSteps;

import Base.APIBaseSteps;
import apiHelper.HttpServiceResponse;
import apiHelper.HttpServicesBuilder;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONObject;

import static apiHelper.StateHelper.getStoryState;
import static apiHelper.StateHelper.setStoryState;

public class GetHotelsAndLocationsStepDef extends APIBaseSteps {

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

    @Given("^From Hotels API, Set (.*) For Query\\.$")
    public void setQueryValue(String queryValue){
        setStoryState("queryValue",queryValue);
    }

    @When("^From Hotels API, Call Get Hotels API\\.$")
    public void callGetHotelsAPI(){
        beforeStartAPITest("seeraAPIs.json");
        HttpServiceResponse response = (httpServicesCommonBuilder
                .get()
                .build("get_hotels")
                .resolveServiceRequestUrl("{queryValue}",getStoryState("queryValue").toString(),false)
                .execute());
        setStoryState("Status_Code",response.getResponseResult().getStatusCode());
        JSONObject jsonResponse = new JSONObject(response.getResultAsString());
        setStoryState("Response",jsonResponse);
    }


    @Then("^Verify That (.*) Returned Under Hotels List\\.$")
    public void verifyQuery(String query){
        getHotelsAndLocationsAPI.assertHotelsListIncludeQuery(query);
    }


}
