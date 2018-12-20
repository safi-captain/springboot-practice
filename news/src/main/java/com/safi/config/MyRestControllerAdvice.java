package com.safi.config;

import com.safi.common.CommonData;
import com.safi.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by xiefeng
 * Time 2018/11/30
 */
//@RestControllerAdvice
public class MyRestControllerAdvice {
    Logger logger = LoggerFactory.getLogger(MyRestControllerAdvice.class);

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     *
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "safi");
    }

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public JsonData runtimeExceptionHandler(Exception ex) {
        logger.error("exception", ex);
        JsonData result = new JsonData(CommonData.statusCode.statusCode100.getCode(), ex.getMessage(), null);
        return result;
    }
}
