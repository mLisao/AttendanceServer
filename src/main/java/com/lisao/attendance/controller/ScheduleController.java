package com.lisao.attendance.controller;

import com.alibaba.fastjson.JSON;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;
import com.lisao.attendance.dao.ScheduleDao;
import com.lisao.attendance.entity.Schedule;
import com.lisao.attendance.entity.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by lisao on 2016/5/22.
 */
@Controller
@RequestMapping(value = "/api/schedule")
public class ScheduleController {

    @Resource
    private ScheduleDao scheduleDao;

    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllSchedule() {
        return scheduleDao.getAllSchedule();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Object addSchedule(Schedule schedule) {
        scheduleDao.addSchedule(schedule);
        return schedule;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllScheduleById(@PathVariable("id") int id) {
        return scheduleDao.getScheduleById(id);
    }

    @RequestMapping(value = "web/{id}", method = RequestMethod.GET)
    public Object getScheduleById(ModelMap model, @PathVariable("id") int id) {
        Schedule schedule = scheduleDao.getScheduleById(id);
        model.addAttribute("id", id);
        model.addAttribute("name", schedule.getName());
        model.addAttribute("address", schedule.getAddress());
        model.addAttribute("endAttendTime", schedule.getEndAttendTime());
        return "schedule";
    }


    @RequestMapping(value = "/getQ", method = {RequestMethod.POST, RequestMethod.GET})
    public void getqcode(HttpServletResponse resp, int id) throws IOException {
        Schedule schedule = scheduleDao.getScheduleById(id);
        String obj = JSON.toJSONString(schedule);
        if (obj != null && !"".equals(obj)) {
            ServletOutputStream stream = null;
            try {

                int width = 300;//图片的宽度
                int height = 300;//高度
                stream = resp.getOutputStream();
                QRCodeWriter writer = new QRCodeWriter();
                BitMatrix m = writer.encode(obj, BarcodeFormat.QR_CODE, height, width);
                MatrixToImageWriter.writeToStream(m, "png", stream);
            } catch (WriterException e) {
                e.printStackTrace();
            } finally {
                if (stream != null) {
                    stream.flush();
                    stream.close();
                }
            }
        }
    }
}
