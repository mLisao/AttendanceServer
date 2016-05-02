package com.lisao.attendance.controller;

import com.lisao.attendance.service.FaceCoreHttp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Created by lisao on 2016/5/2.
 */
@Controller
public class FaceController {

    public static final String FACE_HELLO = "/api/hello";//服务器测试接口，返回服务器当前时间。
    public static final String FACEPOINTSDETECT = "/api/facepointsdetect";//根据参数faceImage，获取图像中的人脸轮廓和特征点。
    public static final String FACEANGLESDETECT = "/api/faceanglesdetect";//根据参数faceImage，获取图像中的人脸角度。
    public static final String FACEDATECT = "/api/facedatect";//根据参数faceImage，获取图像中的人脸位置和特征。
    public static final String FACECOMPARE = "/api/facecompare";//根据参数facefeature1，facefeature2获取两个人脸的相似度。
    public static final String FACEDETECTANDCOMPARE = "/api/facedetectandcompare";//根据参数faceimage1,faceimage2获取两个人脸的相似度。
    public static final String FACEDETECTCOUNT = "/api/facedetectcount";//根据参数faceImage，获取图像中的人脸数量。
    public static final String URLFACEDETECT = "/api/urlfacedetect";//根据参数Url，获取图像中的人脸位置和特征。
    public static final String URLFACEDETECTANDCOMPARE = "/api/urlfacedetectandcompare";//根据参数url1,url2获取两个人脸的相似度。
    public static final String FACEDETECTAGEANDSEX = "/api/facedetectageandsex";//根据参数faceimage，获取图像中的人脸、眼睛位置和特征、年龄性别。


    /**
     * @return 服务器测试接口，返回服务器当前时间。
     * @throws IOException
     */
    @RequestMapping(value = FACE_HELLO, method = RequestMethod.GET)
    @ResponseBody
    public String faceHello() throws IOException {
        String result = FaceCoreHttp.getInstance().get(FACE_HELLO);
        return result;
    }

    /**
     * @param param
     * @return //根据参数faceImage，获取图像中的人脸轮廓和特征点。
     * @throws IOException
     */
    @RequestMapping(value = FACEPOINTSDETECT, method = RequestMethod.POST)
    @ResponseBody
    public String facepointsdetect(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(FACEPOINTSDETECT, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数faceImage，获取图像中的人脸角度。
     * @throws IOException
     */
    @RequestMapping(value = FACEANGLESDETECT, method = RequestMethod.POST)
    @ResponseBody
    public String faceanglesdetect(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(FACEANGLESDETECT, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数faceImage，获取图像中的人脸位置和特征。
     * @throws IOException
     */
    @RequestMapping(value = FACEDATECT, method = RequestMethod.POST)
    @ResponseBody
    public String facedatect(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(FACEDATECT, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数facefeature1，facefeature2获取两个人脸的相似度。
     * @throws IOException
     */
    @RequestMapping(value = FACECOMPARE, method = RequestMethod.POST)
    @ResponseBody
    public String facecompare(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(FACECOMPARE, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数faceimage1,faceimage2获取两个人脸的相似度。
     * @throws IOException
     */
    @RequestMapping(value = FACEDETECTANDCOMPARE, method = RequestMethod.POST)
    @ResponseBody
    public String facedetectandcompare(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(FACEDETECTANDCOMPARE, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数faceImage，获取图像中的人脸数量。
     * @throws IOException
     */
    @RequestMapping(value = FACEDETECTCOUNT, method = RequestMethod.POST)
    @ResponseBody
    public String facedetectcount(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(FACEDETECTCOUNT, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数Url，获取图像中的人脸位置和特征。
     * @throws IOException
     */
    @RequestMapping(value = URLFACEDETECT, method = RequestMethod.POST)
    @ResponseBody
    public String urlfacedetect(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(URLFACEDETECT, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数url1,url2获取两个人脸的相似度。
     * @throws IOException
     */
    @RequestMapping(value = URLFACEDETECTANDCOMPARE, method = RequestMethod.POST)
    @ResponseBody
    public String urlfacedetectandcompare(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(URLFACEDETECTANDCOMPARE, param);
        return result;
    }

    /**
     * @param param
     * @return 根据参数faceimage，获取图像中的人脸、眼睛位置和特征、年龄性别。
     * @throws IOException
     */
    @RequestMapping(value = FACEDETECTAGEANDSEX, method = RequestMethod.POST)
    @ResponseBody
    public String facedetectageandsex(@RequestBody String param) throws IOException {
        String result = FaceCoreHttp.getInstance().post(FACEDETECTAGEANDSEX, param);
        return result;
    }

}
