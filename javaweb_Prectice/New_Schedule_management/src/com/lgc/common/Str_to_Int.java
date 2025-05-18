package com.lgc.common;

import javax.servlet.http.HttpServletRequest;

public class Str_to_Int {
    /**
     * @param req
     * @return int
     * 得到字符串调整为整形
     */
    public static int Str_to_Int(String str){
        int num = 0;
        if (str != null && !str.isEmpty()) { // 检查是否为null或空字符串
            num = Integer.parseInt(str);
        }
        return num;
    }

}
