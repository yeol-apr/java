package com.lgc.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgc.common.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebUtil {
    /**
     * 结果响应类
     */
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * 响应json
     * @param resp 响应对象
     * @param result  响应结果
     * @return void
     *
     */
    public static void writeJson(HttpServletResponse resp, Result result) throws IOException {

    resp.setContentType("application/json;charset=utf-8");
    try {
        String json = mapper.writeValueAsString(result);
        resp.getWriter().write(json);
    }catch (Exception e){
        e.printStackTrace();
    }
    }

}
