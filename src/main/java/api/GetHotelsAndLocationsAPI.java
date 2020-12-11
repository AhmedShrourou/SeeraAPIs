package api;

import org.hamcrest.core.StringContains;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import static apiHelper.StateHelper.getStoryState;

public class GetHotelsAndLocationsAPI {


    public void assertHotelsListIncludeQuery(String query){

        JSONObject jsonResponse = new JSONObject(getStoryState("Response").toString());
        JSONArray jsonHotels = jsonResponse.getJSONArray("hotels");

        for (int i =0; i<jsonHotels.length(); i++){

            Assert.assertThat(jsonHotels.get(i).toString(), StringContains.containsString(query));

        }
    }

}
