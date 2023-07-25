package com.sylvate.exclusive.mainpackage.common.exception;

import com.sylvate.exclusive.mainpackage.common.ApiResponse;
import com.sylvate.exclusive.mainpackage.common.enums.ExceptionEnum;
import com.sylvate.exclusive.mainpackage.common.utils.ErrorUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 模块：
 * 功能：
 *
 * @author syLvate
 * 2022/7/12 14:20
 * -
 **/

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerConfig {
    /**
     * 业务异常处理
     *
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ApiResponse exceptionHandler(BusinessException e) {
        log.error(ErrorUtil.errorInfoToString(e));
        return ApiResponse.error(e.getCode(), e.getErrorMsg());
    }

    /**
     * 未知异常处理
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse exceptionHandler(Exception e) {
        // 把错误信息输入到日志中
        log.error(ErrorUtil.errorInfoToString(e));
        return ApiResponse.error(ExceptionEnum.UNKNOWN.getCode(),
                ExceptionEnum.UNKNOWN.getMsg());
    }

    /**
     * 错误页面异常
     */
    @ExceptionHandler(value = ErrorPageException.class)
    @ResponseBody
    public ApiResponse exceptionHandler(ErrorPageException e) {
        log.error(ErrorUtil.errorInfoToString(e));
        return ApiResponse.error(e.getCode(), e.getErrorMsg());
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ApiResponse exceptionHandler(NullPointerException e) {
        log.error(ErrorUtil.errorInfoToString(e));
        return ApiResponse.error(ExceptionEnum.INTERNAL_SERVER_ERROR.getCode(),
                ExceptionEnum.INTERNAL_SERVER_ERROR.getMsg());
    }
}
