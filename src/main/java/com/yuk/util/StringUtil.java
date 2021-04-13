package com.yuk.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
    public static String getFileSuffix(String file) {
        return file.substring(file.lastIndexOf(".")+1);
    }

    public static void test_substringAfter() {
        String originUrl = "https://hd1-dragon.oss-cn-hangzhou.aliyuncs.com/storage/prod/uploads/video/20210209/4c5dc704-60c5-4475-8f58-b31603e91de5.mp4";
        if (StringUtils.contains(originUrl, "hd1-dragon.oss-cn-hangzhou.aliyuncs.com")) {
            String videoOssPath = StringUtils.substringAfter(originUrl, "video");
            String newUrl =  "content/commompic/2021" + videoOssPath;
            // content/commompic/2021/20210209/4c5dc704-60c5-4475-8f58-b31603e91de5.mp4
            System.out.println(newUrl);
        }
    }

    public static void test_getFileSuffix() {
        String file = "文件管理.pdf";
        System.out.println(getFileSuffix(file));
        file = "https://s.xiaopeng.com/bbs/uploaded/20210412/media_202104121123_5834_file_w_1440@h_3216.jpeg";
        System.out.println(getFileSuffix(file));
    }

    public static void main(String[] args) {
        test_getFileSuffix();
        test_substringAfter();
    }
}
