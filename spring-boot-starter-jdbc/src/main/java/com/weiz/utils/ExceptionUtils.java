package com.weiz.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtils{
    /**
     * 打印异常信息
     */
    public static String getMessage(Exception e) {
        String swStr = null;
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
            swStr = sw.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return swStr;
    }
}
