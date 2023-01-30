package com.patika.weatherapi.component;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class DateFormatterComponent {
    private  String  dateFormatter(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
                .format(localDateTime);
    }

    public String getCurrentDay(){
        return dateFormatter(LocalDateTime.now());
    }

    public String getDateOfMinusWeek(){
        return dateFormatter(LocalDateTime.now().minusWeeks(1));
    }

    public String getDateOfMinusMonth(){
        return dateFormatter(LocalDateTime.now().minusMonths(1));
    }
    public String getDateOfPlusDay(){
        return dateFormatter(LocalDateTime.now().plusDays(1));
    }

}
