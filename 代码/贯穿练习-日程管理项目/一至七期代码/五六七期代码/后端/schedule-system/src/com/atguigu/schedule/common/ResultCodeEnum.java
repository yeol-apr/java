package com.atguigu.schedule.common;

public enum ResultCodeEnum {
    SUCCESS(200,"success"),
    USERNAEM_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notlogin"),
    USERNAME_USED(505,"usernameUsed");



    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code ,String message){
        //不让别的地方随便使用
        this.code= code;
        this.message = message;

    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
