package com.english.service;

import com.english.entity.StatisticEntity;
import com.english.mapper.LogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
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
    @Autowired
    private LogMapper logMapper;


    /**
     * 根据用户Id，获取用户本月的统计信息。
     * @author Mwg
     * @date 2019/5/8 11:09
     * @param userId
     * @return com.english.entity.StatisticEntity
     */
    public StatisticEntity getStatistic(int userId){
        DecimalFormat df = new DecimalFormat("#######.00");
        StatisticEntity statisticEntity = new StatisticEntity();
        String monthStr = CommonService.getMonth();
        statisticEntity.setUserId(userId);
        statisticEntity.setCountArticle(logMapper.getCountArticle(userId, monthStr));
        statisticEntity.setAvgReadTime(logMapper.getAvgReadTime(userId, monthStr));
        statisticEntity.setSumReadTime(logMapper.getsumReadTime(userId, monthStr));
        statisticEntity.setSumReadWord(logMapper.getSumReadWord(userId, monthStr));
        statisticEntity.setCountQues(logMapper.getCountQusetion(userId, monthStr));
        statisticEntity.setErrorOnce(logMapper.getErrorOnce(userId,monthStr));
        statisticEntity.setErrorTwice(logMapper.getErrorTwice(userId,monthStr));
        statisticEntity.setErrorMuch(logMapper.getErrorMuch(userId,monthStr));
        int countRight = logMapper.getCountRight(userId, monthStr);
        int countError = logMapper.getCountError(userId, monthStr);
        double rightRate = (double) countRight / (countError + countRight) * 100;
        statisticEntity.setCountRight(countRight);
        statisticEntity.setCountError(countError);
        statisticEntity.setWordSearch(logMapper.getWordSearch(userId, monthStr));
        statisticEntity.setRightRate(df.format(rightRate) + "%");
        return statisticEntity;

    }
}
