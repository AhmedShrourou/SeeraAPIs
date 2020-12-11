package api;

import org.hamcrest.core.StringContains;
import org.json.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static apiHelper.StateHelper.getStoryState;

public class BookApartmentAPI {


    public String generateRoomArray(){

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder room = new StringBuilder();
        List<String> rooms = new ArrayList<>();
        int roomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);

        stringBuilder.append("\"room\": [");

        for (int size=0;size<roomNum; size++) {
            room.append("{").append(generateGuestArray()).append("}");
            rooms.add(room.toString());
            room.setLength(0);
        }

        stringBuilder.append(String.join(", ", rooms)).append("]");

        return stringBuilder.toString();
    }


    private String generateGuestArray(){

        StringBuilder stringBuilder = new StringBuilder();
        List<String> guests = new ArrayList<>();
        int guestNum = ThreadLocalRandom.current().nextInt(2, 4 + 1);

        stringBuilder.append("\"guest\": [");

        for (int size=0;size<guestNum; size++)
            guests.add(getRandomGuest());

        stringBuilder.append(String.join(", ", guests)).append("]");

        return stringBuilder.toString();
    }


    private String getRandomGuest(){

        StringBuilder stringBuilder = new StringBuilder();
        String[] guestType = {"ADT", "CHD"};

        Random rand = new Random();
        String s_ran = guestType[rand.nextInt(guestType.length)];
        stringBuilder.append("{\"type\": \"").append(s_ran).append("\"");

        if("CHD".equalsIgnoreCase(s_ran))
            stringBuilder.append(",\"age\": ").append(rand.nextInt((8 - 3) + 1) + 3);

        stringBuilder.append("}");

        return stringBuilder.toString();

    }

    public void assertResponseBody(){

        JSONObject jsonResponse = new JSONObject(getStoryState("Response").toString());
        Assert.assertEquals(jsonResponse.get("type").toString(),"hotel");
        Assert.assertThat(jsonResponse.get("queryParameters").toString(), StringContains.containsString("placeId"));

    }
}
