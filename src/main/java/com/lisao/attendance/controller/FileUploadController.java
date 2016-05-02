package com.lisao.attendance.controller;

import com.lisao.attendance.entity.ErrorCode;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * Created by lisao on 2016/5/2.
 */
@Controller
@RequestMapping("/api")
public class FileUploadController {
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Object fildUpload(@RequestParam("file") MultipartFile multiFile, HttpServletRequest request) throws Exception {
        //获得物理路径webapp所在路径
        String pathRoot = request.getSession().getServletContext().getRealPath("/upload/");
        if (!multiFile.isEmpty()) {
            //生成uuid作为文件名称
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = multiFile.getContentType();
            //获得文件后缀名称
            String type = contentType.substring(contentType.indexOf("/") + 1);
            FileUtils.copyInputStreamToFile(multiFile.getInputStream(), new File(pathRoot + File.pathSeparator + fileName + "." + type));
        }
        System.out.println(pathRoot);
        return new ErrorCode(ErrorCode.SUCCESS, "fileUpload Success");
    }
}
