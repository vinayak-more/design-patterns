package com.retro.web.utils;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * @author Vinayak More
 *
 * @date 09-Apr-2017
 */
public class MyDateUtils {

    public static Date getDateWithoutTime(Date date) {
        return DateUtils.truncate(date, Calendar.DATE);
    }

}
