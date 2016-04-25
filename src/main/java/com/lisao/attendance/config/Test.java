package com.lisao.attendance.config;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lisao on 2016/3/1.
 */
public class Test {
    public static void main(String[] args) {

        String htmlStr = "<p><img alt=\"QQ图片20160301092730\" src=\"http://posts.cdn.wallstcn.com/57/9b/46/qq-20160301092730.png\" />\n" +
                "<img alt=\"QQ图片20160301092730\" src=\"http://posts.cdn.wallstcn.com/57/9b/46/qq-20160301092730.png\" />\n" +
                "<img alt=\"QQ图片20160301092730\" src=\"http://posts.cdn.wallstcn.com/57/9b/46/qq-20160301092730.png\" /></p> ";
        Pattern p_image;
        Matcher m_image;
        ArrayList<String> pics = new ArrayList<String>();
        Pattern p = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");//<img[^<>]*src=[\'\"]([0-9A-Za-z.\\/]*)[\'\"].(.*?)>");
        Matcher m = p.matcher(htmlStr);
        while (m.find()) {
            pics.add(m.group(1));
        }
        System.out.println(pics);

    }


    private void f1()
    {
    }
}
