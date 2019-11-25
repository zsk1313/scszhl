package org.zhl.scs.dao;


import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.EDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.domain.Attenance;
import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Course;
import org.zhl.scs.util.PageModel;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AttendanceDaoTest<pbulic> {
    @Autowired
    AttenanceDao attenanceDao;

    @Test
    //测试dao层保存方法
    public void testAttenancesave() {
        Clazz clazz = new Clazz();
        clazz.setId(1);
        Course course = new Course();
        course.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(2);
        attenance.setDate(new Date());
        attenance.setTotal(10);
        attenance.setActual(30);
        attenance.setClazz(clazz);
        attenance.setCourse(course);
        attenanceDao.save(attenance);


    }

    @Test
    //测试跟新方法，该方法只能修改已有记录
    public void testAttenanceupdate() {
        Clazz clazz = new Clazz();
        clazz.setId(1);
        Course course = new Course();
        course.setId(1);
        Attenance attenance = new Attenance();
        attenance.setId(1);
        attenance.setDate(new Date());
        attenance.setTotal(15);
        attenance.setActual(30);
        attenance.setClazz(clazz);
        attenance.setCourse(course);
        attenanceDao.update(attenance);

    }

    @Test
    //根据ID删除考勤表
    public void testdeleteById() {
        Attenance attenance = new Attenance();
        attenance.setId(1);
        attenanceDao.deleteById(1);
    }


    @Test
    //根据ID查询考勤表
    public void testAttenanceselectById() {
        Map<String, Object> params = new HashMap<>();
        Attenance attenance = new Attenance();
        attenance.setId(1);
        params.put("attenance", attenance);
        int count = attenanceDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);


        params.put("pagemodel", pageModel);
        System.out.println(attenance);

    }

    @Test
    //对考勤表进行统计
    public void testAttenancecount() {
        Map<String, Object> params = new HashMap<>();
        Attenance attenance = new Attenance();
        attenance.setId(1);
        // params.put("Id",Id);

        int count = attenanceDao.count(params);
        System.out.println("id为1 共有 " + count + "条记录");


    }

    @Test
    //分页查询
    public void testAttenanceselectByPage() {
        Map<String, Object> params = new HashMap<>();
        Attenance attenance = new Attenance();
        attenance.setId(1);
        params.put("attenance", attenance);
        int count = attenanceDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pagemodel", pageModel);
        for (Attenance attenance1 : attenanceDao.selectByClazzId(1)) {
            System.out.println(attenance1);
        }

    }

    @Test
    //根据课程ID查询考勤表
    public void testAttenanceselectByCourseId() {
        Map<String, Object> params = new HashMap<>();
        Attenance attenance = new Attenance();
        attenance.setId(1);
        params.put("attenance", attenance);
        int count = attenanceDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pagemodel", pageModel);
        for (Attenance attenance1 : attenanceDao.selectByCourseId(1)) {
            System.out.println(attenance1);
        }
    }

    @Test
    //根据ID和考勤信息ID查询考勤表
    public void testAttendanceSelectByIdwithAttenanceId() {
        Map<String, Object> params = new HashMap<>();
        Attenance attenance = new Attenance();
        attenance.setId(1);
        params.put("attenance", attenance);
        int count = attenanceDao.count(params);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pagemodel", pageModel);
        Attenance attenance1 = attenanceDao.selectByIdWithAttenanceId(attenance.getId());
            System.out.println(attenance1);


    }
}



