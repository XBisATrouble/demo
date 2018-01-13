package com.cqupt.domain.result;

public enum ExceptionMsg {
    SUCCESS("200", "操作成功"),
    SUCCESSINSERT("200","插入成功"),
    SUCCESSUPDATE("200","更新成功"),
    SUCCESSDELETE("200","删除成功"),
    SUCCESSLOGIN("200","登陆成功"),
    SUCCESSUPDATEPWD("200","密码更新成功"),
    NOTFOUNDED("404","找不到相关页面"),
    NOTFOUNDANYUSER("404","找不到任何站点"),
    NOTFOUNDUSER("404","找不到相关站点信息"),
    PASSWORDERROR("401","密码输入错误"),
    DBERROR("501", "数据库操作出错！"),
    ERROR("500","服务器出错!"),
    ;

    private ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }


}