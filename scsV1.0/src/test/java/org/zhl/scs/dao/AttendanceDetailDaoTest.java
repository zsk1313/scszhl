package org.zhl.scs.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.domain.*;
import org.zhl.scs.util.PageModel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AttendanceDetailDaoTest {
    @Autowired
    AttendanceDetailDao attendanceDetailDao;

    @Test
    //测试dao层保存方法
    public void testAttenancesave() {
        Student student = new Student();
        student.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);

        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(1);
        attendanceDetail.setIsattendance(1);
        attendanceDetail.setStudent(student);
        attendanceDetail.setAttenance(attenance);


        attendanceDetailDao.save(attendanceDetail);


    }

    @Test
    //测试更改方法
    public void testAttendacneupdate() {
        Student student = new Student();
        student.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);

        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(2);
        attendanceDetail.setIsattendance(0);
        attendanceDetail.setStudent(student);
        attendanceDetail.setAttenance(attenance);


        attendanceDetailDao.update(attendanceDetail);


    }

    @Test
    //测试删除方法
    public void testAttendenceDetaildeleteById() {
        Student student = new Student();
        student.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);

        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(2);
        attendanceDetail.setIsattendance(1);
        attendanceDetail.setStudent(student);
        attendanceDetail.setAttenance(attenance);


        attendanceDetailDao.deleteById(1);

    }

    @Test
    public void testAttendanceDetailcount() {
        Map<String, Object> params = new HashMap<>();
        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(2);
        //params.put("Id",Id);

        int count = attendanceDetailDao.count(params);
        System.out.println("id为2 共有 " + count + "条记录");


    }
    @Test
    //测试分页查询
    //存在问题
    public void testAttendanceDetailselectByPage() {
        Map<String, Object> params = new HashMap<>();

        Student student = new Student();
        student.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);

        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(1);
        params.put("attendanceDetail", attendanceDetail);
        int count = attendanceDetailDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pagemodel", pageModel);
        for (AttendanceDetail attendanceDetail1 : attendanceDetailDao.selectByPage(params)) {
            System.out.println(attendanceDetail);
        }


    }
    @Test
    public  void  testAttendanceDetailselectBystudentId(){
        Map<String, Object> params = new HashMap<>();
        Student student = new Student();
        student.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);

        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(1);
        params.put("attendanceDetail", attendanceDetail);
        int count = attendanceDetailDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pagemodel", pageModel);
        for (AttendanceDetail attendanceDetail1 : attendanceDetailDao.selectByStudentId(1)) {
            System.out.println(attendanceDetail);
        }

    }
    @Test
    public  void  testAttendanceDetailselectByAttendanceId(){
        Map<String, Object> params = new HashMap<>();
        Student student = new Student();
        student.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);

        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(1);
        params.put("attendanceDetail", attendanceDetail);
        int count = attendanceDetailDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pagemodel", pageModel);
        for (AttendanceDetail attendanceDetail1 : attendanceDetailDao.selectByAttenanceId(1)) {
            System.out.println(attendanceDetail);
        }

    }
    @Test
    public  void  testAttendanceDetailselectById(){
        Map<String, Object> params = new HashMap<>();
        Student student = new Student();
        student.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);

        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(1);
        params.put("attendanceDetail", attendanceDetail);
        int count = attendanceDetailDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pagemodel", pageModel);
       // for (AttendanceDetail attendanceDetail1 : attendanceDetailDao.selectById(1)) {
            System.out.println(attendanceDetail);
       // }

    }



}