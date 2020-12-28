package com.yuk.java;

import com.yuk.util.LogUtil;

public class IfTest {

    public static void main(String[] args) {
        test1(100);
        test2(100);
        test2(25);
    }

    public static void test1(int num) {
        LogUtil.info("start, num:{}", num);
        if(num > 10) {
            LogUtil.info("num:{} is large than 10", num);
        }
        if(num > 20) {
            LogUtil.info("num:{} is large than 20", num);
        }
        if(num > 30) {
            LogUtil.info("num:{} is large than 30", num);
        }
        LogUtil.info("end, num:{}", num);
    }

    public static void test2(int num) {
        LogUtil.info("start, num:{}", num);
        if(num > 10) {
            LogUtil.info("num:{} is large than 10", num);
        } else if(num > 20) {
            LogUtil.info("num:{} is large than 20", num);
        } else if(num > 30) {
            LogUtil.info("num:{} is large than 30, num");
        }
        LogUtil.info("end, num:{}", num);
    }
}
