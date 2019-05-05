package com.english.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * TODO
 *
 * @author Mwg
 * @version 1.0
 * @date 2019/5/5 21:10
 */
@Slf4j
@Component
public class StatisticService {

    public void getStatistic(int userId){
        Calendar cale = Calendar.getInstance();
        int month = cale.get(Calendar.MONTH) + 1;
        String monthStr = "";
        if(month < 10){
            monthStr = "0" + Integer.toString(month);
        }
        else {
            monthStr = Integer.toString(month);
        }


    }
}
