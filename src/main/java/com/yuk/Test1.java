package com.yuk;

import com.alibaba.fastjson.JSON;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Test1 {
    public static void main(String[] args) {
        try {
            XpAd item = new XpAd();
            item.setDisplayType(null);
            Integer groupId = 2;
            System.out.println(JSON.toJSONString(item));
            if (item.getDisplayType().equals(0) || groupId.equals(item.getDisplayType())) {

            }
        } catch (Throwable t) {
            System.out.println("---=:" +
                    ""+getStackTrace(t));
        }
    }

    public static String getStackTrace(final Throwable throwable) {
        final StringWriter sw = new StringWriter();
        final PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.getBuffer().toString();
    }
}
