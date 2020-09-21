package com.yuk.util;

public class NumberUtil {
    public static void main(String[] args) {
        test_toLong();
    }

    /**
     * 运行结果:
     * spring-uidStr:,error
     * hutool-uidStr:,uid:0
     * apache-uidStr:,uid:0
     * spring-uidStr:null,error
     * hutool-uidStr:null,uid:0
     * apache-uidStr:null,uid:0
     * spring-uidStr:null,error
     * hutool-uidStr:null,error
     * apache-uidStr:null,uid:0
     * spring-uidStr:3,uid:3
     * hutool-uidStr:3,uid:3
     * apache-uidStr:3,uid:3
     * spring-uidStr:3asdf,error
     * hutool-uidStr:3asdf,error
     * apache-uidStr:3asdf,uid:0
     *
     * 结论:
     * 转数字这个, 还是apache的功能强
     */
    public static void test_toLong(){
        String uidStr = "";
        toLong(uidStr);
        uidStr = null;
        toLong(uidStr);
        uidStr = "null";
        toLong(uidStr);
        uidStr = "3";
        toLong(uidStr);
        uidStr = "3asdf";
        toLong(uidStr);
        uidStr = "-1";
        toLong(uidStr);
        Long uid = org.apache.commons.lang3.math.NumberUtils.toLong("-1", 0L);
        if(uid<0L){
            System.out.println(uid + "<0");
        } else {
            System.out.println(uid + ">0");
        }

    }

    public static void toLong(String uidStr){
        Long uid = 3L;
        try {
            uid = org.springframework.util.NumberUtils.parseNumber(uidStr, Long.class);
            System.out.println("spring-uidStr:"+uidStr + ",uid:" + uid);
        } catch (IllegalArgumentException e) {
            System.out.println("spring-uidStr:"+uidStr + ",error");
//            e.printStackTrace();
        }

        try {
            uid = cn.hutool.core.util.NumberUtil.parseLong(uidStr);
            System.out.println("hutool-uidStr:"+uidStr + ",uid:" + uid);
        } catch (Exception e) {
            System.out.println("hutool-uidStr:"+uidStr + ",error");
//            e.printStackTrace();
        }

        uid = org.apache.commons.lang3.math.NumberUtils.toLong(uidStr, 0L);
        System.out.println("apache-uidStr:"+uidStr + ",uid:" + uid);
    }
}
