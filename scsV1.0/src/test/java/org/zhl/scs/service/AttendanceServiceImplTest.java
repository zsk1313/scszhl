package org.zhl.scs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Attenance;
import org.zhl.scs.domain.AttendanceDetail;
import org.zhl.scs.domain.vo.AttenanceVo;
import org.zhl.scs.domain.vo.AttendanceDetailVo;
import org.zhl.scs.domain.vo.CourseVo;
import org.zhl.scs.service.attendance.IAttendanceService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class AttendanceServiceImplTest {

    @Autowired
    private IAttendanceService attendanceService;

    @Test
    //测试考勤模块 service层 saveAttendance（）方法
    public void testSaveAttendance()throws InvocationTargetException, IllegalAccessException{
        AttenanceVo attenanceVo = new AttenanceVo();
        attenanceVo.setCourseId(2);
        attenanceVo.setActual(30);
        attenanceVo.setTotal(12);
        attenanceVo.setDate(new Date());
        attendanceService.saveAttendance(attenanceVo);
    }
    @Test
    //测试考勤模块 service层 updateAttendance（）方法
    public void testUpdateAttendance()throws InvocationTargetException, IllegalAccessException{
        AttenanceVo attenanceVo = new AttenanceVo();
        attenanceVo.setId(2);
        attenanceVo.setDate(new Date());
        attenanceVo.setTotal(30);
        attenanceVo.setActual(15);
        attenanceVo.setCourseId(2);
        attendanceService.updateAttendance(attenanceVo);
    }
    @Test
    //测试考勤模块 service层 deleteAttendance（）方法
    public void testDeleteAttendance(){
        AttenanceVo attenanceVo = new AttenanceVo();
        attenanceVo.setId(3);
        attendanceService.deleteAttendance(attenanceVo);

    }
    @Test   //未实现
    //测试考勤模块 service层  selectAttendances（）方法
    public void testSelectAttendances() throws InvocationTargetException, IllegalAccessException {
        AttenanceVo attenanceVo = new AttenanceVo();
        attenanceVo.setCourseId(1);
        List<Attenance>list = attendanceService.selectAttendances(attenanceVo);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }

    }
    @Test  //待修改
    //测试考勤模块 service层 selectAttendances（）方法
    public void testSelectAttendanceDetails() throws InvocationTargetException, IllegalAccessException {
//        Attenance attenance = new Attenance();
//        PageModel pageModel = new PageModel();
//        Course course = new Course();
//        course.setId(2);
//        attenance.setCourse(course);
//        attendanceService.selectAttendances(attenance);
        AttendanceDetailVo attendanceDetailVo = new AttendanceDetailVo();
       attendanceDetailVo.setStudentId(1);
        List<AttendanceDetail>list = attendanceService.selectAttendanceDetails(attendanceDetailVo);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }

    }
    @Test
    //测试考勤模块 service层 publishAttendance（）方法
    public void testPulishAttendance(){
        CourseVo courseVo = new CourseVo();
        List<Integer>couvo = new ArrayList<>();
        couvo.add(1);
        couvo.add(2);
        courseVo.setStudentIds(couvo);
    }
    @Test
    //测试考勤模块 service层 attendance（）方法
    public void testAttendance(){
        AttendanceDetailVo attendanceDetailVo = new AttendanceDetailVo();
        attendanceDetailVo.setSignTime(new Date());
        attendanceDetailVo.setAttenanceId(2);
        attendanceDetailVo.setStudentId(1);
        attendanceService.attendance(attendanceDetailVo);
    }
    @Test
    //测试考勤模块 service层 note（）方法
    public void testNote(){
        AttenanceVo attenanceVo = new AttenanceVo();
        attenanceVo.setNote("good job");
        attenanceVo.setId(2);
        attendanceService.note(attenanceVo);
    }








}
