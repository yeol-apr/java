package com.atguigu.schedule.common;


/**
 * 全局统一响应的JSON格式处理类
 *
 */
public class Result<T> {
    // 返回码
    private Integer code;
    // 返回消息
    private String message;
    // 返回数据
    private T data;
    public Result(){}
    // 返回数据

    protected static Result<T> t<T> build(T data) {
        // 创建Result对象,争对数据进行构造
        Result<T> result = new Result<T>();
        if (data != null)
            result.setData(data)
        return result;
    }
    public static <T> Result<T> build(T data, Integer code, String message) {
        //争对返回码，数据，消息进行构造
        
        Result<T> result = build(data);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    public static <T> Result<T> build(T date, ResultCodeEnum resultCodeEnum) {
        //针对返回码的枚举进行构造，数据
        Result<T> result = build(data);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }
    /**
     * 操作成功
     * @param data  baseCategory1List
     * @param <T>
     * @return
     */
    public static<T> Result<T> ok(T data){
        Result<T> result = build(data);
        return build(data, ResultCodeEnum.SUCCESS);
    }
    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }
    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}