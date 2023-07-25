package com.sylvate.exclusive.mainpackage.common.exception;

import com.sylvate.exclusive.mainpackage.common.enums.ExceptionEnum;

/**
 * 模块：
 * 功能：
 *
 * @author syLvate
 * 2022/7/12 14:18
 * -
 **/


public class BusinessException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
    private int code;
    private String errorMsg;

    public BusinessException() {
        super();
    }

    public BusinessException(ExceptionEnum exceptionEnum) {
        super("{code:" + exceptionEnum.getCode() + ",errorMsg:" + exceptionEnum.getMsg() + "}");
        this.exceptionEnum = exceptionEnum;
        this.code = exceptionEnum.getCode();
        this.errorMsg = exceptionEnum.getMsg();
    }

    public BusinessException(int code, String errorMsg) {
        super("{code:" + code + ",errorMsg:" + errorMsg + "}");
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public BusinessException(int code, String errorMsg, Object... args) {
        super("{code:" + code + ",errorMsg:" + String.format(errorMsg, args) + "}");
        this.code = code;
        this.errorMsg = String.format(errorMsg, args);
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
