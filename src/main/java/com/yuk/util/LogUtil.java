package com.yuk.util;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogUtil {
    private final static String source = "\\{\\}";
    private final static Pattern pattern = Pattern.compile(source);

    private static String print(String format, Object... arguments) {
        Matcher m = pattern.matcher(format);

        int i = 0; // arguments
        while (m.find() && i < arguments.length) {
            format = format.replaceFirst(source, String.valueOf(arguments[i++]));
        }

        return format;
    }

    private static String prefix(String msg) {
        try {
            StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[3];
            String[] classNameSplit = StringUtils.split(stackTrace.getClassName(), '.');
            String shortClassName = classNameSplit[classNameSplit.length - 1];
            return MessageFormat.format("[{0}.{1}]{2}",
                    shortClassName, stackTrace.getMethodName(),
                    StringUtils.defaultIfBlank(msg, ""));
        } catch (Exception e) {
            return MessageFormat.format("[unknow]{0}", StringUtils.defaultIfBlank(msg, ""));
        }
    }

    public static void info(String msg){
        System.out.println(prefix(msg));
    }

    public static void info(String format, Object arg) {
        System.out.println(print(prefix(format), arg));
    }

    public static void info(String format, Object... arguments) {
        System.out.println(print(prefix(format), arguments));
    }

    public static void info(String msg, Throwable t) {
        System.out.println(print(prefix(msg), t));
    }

}

