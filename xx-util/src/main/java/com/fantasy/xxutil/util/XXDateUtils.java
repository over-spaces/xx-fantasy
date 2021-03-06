package com.fantasy.xxutil.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author li.fang
 * @sine 17/02/19
 */
public class XXDateUtils {

    private static Logger logger = LoggerFactory.getLogger(XXDateUtils.class);

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Date getDate(String dateString) {
        if (StringUtils.isBlank(dateString)) {
            return null;
        }
        try {
            return org.apache.commons.lang3.time.DateUtils.parseDate(dateString, "yyyy-MM-dd", "yyyy/MM/dd");
        } catch (Exception e1) {
            try {
                return new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.US).parse(dateString);
            } catch (Exception e2) {
                logger.warn("转化日期格式错误: {}, format:yyyy-MM-dd 或 yyyy/MM/dd", dateString);
            }
        }
        return null;
    }

    public static String getStrDate(@NotNull Date date) {
        if (date == null) {
            return null;
        }
        return sdf.format(date);
    }

    public static String getStrDate(@NotNull Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    public static String getNow(){
        return getStrDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }
}
