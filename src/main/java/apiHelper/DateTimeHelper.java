package apiHelper;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DateTimeHelper {

    public static String getCurrentDate(String DateFormate){

        SimpleDateFormat formatter = new SimpleDateFormat(DateFormate);
        Date date = new Date();
        return formatter.format(date);
    }


    public static String getFutureDate(String DateFormate){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(DateFormate);
        int plusDays = ThreadLocalRandom.current().nextInt(1, 5 + 1);

        calendar.add(Calendar.DATE, plusDays);
        Date date = calendar.getTime();

        String result = formatter.format(date);
        return result;
    }


}
