package com.sn.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 可以在连接上携带区域信息
 */

public class MyLocaleResolver  implements LocaleResolver{
    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l = httpServletRequest.getParameter("lan");
        logger.info(l);
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] strings = l.split("_");
           locale = new Locale(strings[0],strings[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
