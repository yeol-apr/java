package com.lgc.common;

public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public Result() {//    无参构造
         }

     /**
      * build方法的重载
      */
     public static <T> Result<T> build(T data) {
         Result<T> result = new Result<T>();
         if (data != null){
             result.setData(data);
         }
         return result;
     }
    public static <T> Result<T> build(T data, ResultCodeEnum resultCodeEnum) {
        Result<T> result = new Result<T>();
        result.setCode(resultCodeEnum.getCode());
        result.setMsg(resultCodeEnum.getMessage());
        result.setData(data);
        return result;
    }
    public static <T> Result<T> build(T data,int code,String msg) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
