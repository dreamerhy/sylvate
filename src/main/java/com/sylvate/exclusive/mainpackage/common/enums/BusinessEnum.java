package com.sylvate.exclusive.mainpackage.common.enums;

/**
 * 业务请求响应状态枚举类
 *
 * @author syLvate
 */

public enum BusinessEnum {
    HTTP_SUCCESS(200, "操作成功"),
    HTTP_BAD_REQUEST(400, "请求错误"),
    HTTP_NOT_FOUND(404, "资源未找到"),
    HTTP_METHOD_NOT_ALLOWED(405, "请求方式不被允许"),
    HTTP_SERVER_ERROR(500, "服务器内部错误"),

    /*=====================导出与导入======================*/
    EXPORT_ERROR(30001, "导出文件下载失败"),
    EXPORT_COLUMN_ERROR(30002, "导出字段不能为空"),
    IMPORT_ERROR(30003, "导入失败"),
    /*=====================文件相关======================*/
    FILE_UPLOAD_ERROR(50001, "上传文件失败"),
    FILE_DELETE_ERROR(50002, "删除文件失败"),
    /*=====================流程相关======================*/
    START_PROCESS_ERROR(60001, "开启流程失败");
    private Integer code;
    private String message;

    BusinessEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
