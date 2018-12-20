package com.safi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiefeng
 * Time 2018/12/10
 */
@Component
public class MyExceptionResolver implements HandlerExceptionResolver {
    Logger logger = LoggerFactory.getLogger(MyControllerAdvice.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");

        logger.error("------------------ error", e);
        return modelAndView;

    }
}
