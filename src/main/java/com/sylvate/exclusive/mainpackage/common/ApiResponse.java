package com.sylvate.exclusive.mainpackage.common;


import com.sylvate.exclusive.mainpackage.common.enums.BusinessEnum;

import java.io.Serializable;

/**
 * 接口统一返回对象
 *
 * @param <T>
 */
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = 2783377098145240357L;
    private Integer code;
    private String msg;
    private T data;

    public ApiResponse() {
        this.code = 200;
        this.msg = "success";
        this.data = null;
    }

    public ApiResponse(Integer code, T data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ApiResponse<T> data(T data) {
        return data(data, "操作成功");
    }

    public static <T> ApiResponse<T> data(T data, String msg) {
        return data(200, data, msg);
    }

    public static <T> ApiResponse<T> data(int code, T data, String msg) {
        return new ApiResponse<>(code, data, data == null ? "暂无承载数据" : msg);
    }

    public static <T> ApiResponse<T> success(String msg) {
        return new ApiResponse<>(200, null, msg);
    }

    public static <T> ApiResponse<T> fail(int code, String msg) {
        return new ApiResponse<>(code, null, msg);
    }

    public static <T> ApiResponse<T> fail(String msg) {
        return new ApiResponse<>(400, null, msg);
    }

    public static <T> ApiResponse<T> fail(BusinessEnum error) {
        return new ApiResponse<>(error.getCode(), null, error.getMessage());
    }

    public static <T> ApiResponse<T> error(int code, String msg) {
        return new ApiResponse<>(code, null, msg);
    }

    public static <T> ApiResponse<T> error(String msg) {
        return new ApiResponse<>(400, null, msg);
    }

    public static <T> ApiResponse<T> error(BusinessEnum error) {
        return new ApiResponse<>(error.getCode(), null, error.getMessage());
    }

    public static <T> ApiResponse<T> judge(int msg) {
        return msg > 0 ? success("操作成功") : fail("操作失败");
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getmsg() {
        return this.msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"msg\":\"" + msg + '\"' +
                ", \"data\":" + data +
                '}';
    }
}

