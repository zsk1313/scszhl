package org.zhl.scs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.domain.Attenance;
import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.vo.ClazzVo;
import org.zhl.scs.domain.vo.CourseVo;
import org.zhl.scs.service.teaching.impl.TeachingServiceImpl;
import org.zhl.scs.util.PageModel;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ITeachingServiceTests {
    @Autowired
    TeachingServiceImpl teachingService;
    /**
     * service层实现类测试
     * @author ljj
     * @version 1.0
     * Great on 2019/11/15
     */
    /**
     * saveClazz();方法测试
     */
    @Test
    public void testsaveClazz(){
        ClazzVo clazzVo=new ClazzVo();
//        clazzVo.setId(3);
        clazzVo.setClazzNum("123");
        clazzVo.setDescription("软件1163班");
        clazzVo.setTeacherId(2);
        teachingService.saveClazz(clazzVo);
    }
    //test of updateClazz()
    @Test
    public void testupdateClazz() throws InvocationTargetException, IllegalAccessException {
        ClazzVo clazzVo=new ClazzVo();
        clazzVo.setId(3);
        clazzVo.setClazzNum("321");
        clazzVo.setDescription("软件1164班");
        clazzVo.setTeacherId(2);
        teachingService.updateClazz(clazzVo);
    }
    //test of deleteClazz()
    @Test
    public void testdeleteClazz(){
        ClazzVo clazzVo=new ClazzVo();
        clazzVo.setId(4);
        teachingService.deleteClazz(clazzVo);
    }
    //test of selectClazzById()
    @Test
    public void testselectClazzById(){
        Clazz clazz=new Clazz();
        clazz=teachingService.selectClazzById(3);
        System.out.println(clazz);
    }

    /**
     * 分页查询测试
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void testselectClazzs() throws InvocationTargetException, IllegalAccessException {
//        List<Clazz> list=new ArrayList<>();
        ClazzVo clazzVo=new ClazzVo();
        clazzVo.setDescription("软件1164班");
        PageModel pageModel=new PageModel();
        List<Clazz> list=teachingService.selectClazzs(clazzVo,pageModel);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }

    /**
     * 保存客户信息测试方法
     */
    @Test
    public void testsaveCourse() throws InvocationTargetException, IllegalAccessException {
        CourseVo courseVo=new CourseVo();
//        courseVo.setId(1);
        courseVo.setCode("2532");
        courseVo.setName("林梓燊的产后护理");
        courseVo.setScore(1.2);
        courseVo.setClassroom("科技楼");
        courseVo.setStartTime(new Date());
        courseVo.setEndTime(new Date());
        courseVo.setTeacherId(3);
        courseVo.setWeek(2);
        courseVo.setDateorder(2);
        teachingService.saveCourse(courseVo);
    }
    @Test
    public void testupdateCourse() throws InvocationTargetException, IllegalAccessException {
        CourseVo courseVo=new CourseVo();
        courseVo.setId(2);
        courseVo.setCode("2122");
        courseVo.setName("母猪的产后护理");
        courseVo.setScore(87.2);
        courseVo.setTeacherId(3);
        courseVo.setWeek(2);
        courseVo.setDateorder(2);
        teachingService.updateCourse(courseVo);
    }
    @Test
    public void testdeleteCourse(){
        CourseVo courseVo=new CourseVo();
        courseVo.setId(4);
        teachingService.deleteCourse(courseVo);
    }
    @Test
    public void testselectCourseById(){

        Course course=teachingService.selectCourseById(2);
        System.out.println(course.toString());
    }
    @Test
    public void  testselectCourses() throws InvocationTargetException, IllegalAccessException {
//        List<Course> list=new ArrayList<>();
        CourseVo courseVo=new CourseVo();
        PageModel pageModel=new PageModel();
        List<Course> list=teachingService.selectCourses(courseVo,pageModel);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void testfindAllStudentByClazzId(){
        List<Student> students=teachingService.findAllStudentByClazzId(1);
        /*for (int i=0;i<students.size();i++){
            System.out.println(students.get(i).toString());
        }*/
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testfindAllStudentByCoursersid() {
        List<Student> students = teachingService.findAllStudentByCoursersid(3);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
    }
    @Test
    public void testfindAllAttenanceByCoursersid(){
        List<Attenance> attenances=teachingService.findAllAttenanceByCoursersid(2);
        for (int i=0;i<attenances.size();i++){
            System.out.println(attenances.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByFilterOfScore(){
        List<Course> courses=teachingService.findCourseByFilterOfScore(50.0,90.0);
        for (int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByGreaterThanScore(){
        List<Course> courses=teachingService.findCourseByGreaterThanScore(40.0);
        for (int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByLessThanScore(){
        List<Course> courses=teachingService.findCourseByLessThanScore(70.0);
        for (int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByFilterOfDateorder(){
        List<Course> courses=teachingService.findCourseByFilterOfDateorder(2,2);
        for (int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByGreaterThanDateorder(){
        List<Course> courses=teachingService.findCourseByGreaterThanDateorder(3);
        for (int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByLessThanDateorder(){
        List<Course> courses=teachingService.findCourseByLessThanDateorder(3);
        for (int i=0;i<courses.size();i++){
            System.out.println(courses.get(i).toString());
        }
    }
    @Test
    public void testDate() throws ParseException {
        Date date=new Date();
        int  nocourse=0;
        int[] weekDays = { 7, 1, 2, 3, 4, 5,6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String dateString=formatter.format(date);
        int courseNum=Integer.parseInt(dateString);
        if (courseNum<10&&courseNum>=8){
            nocourse=1;
        }else if (courseNum>=10&&courseNum<12){
            nocourse=2;
        }else if (courseNum>=14&&courseNum<16){
            nocourse=3;
        }
        else if (courseNum>=16&&courseNum<18){
            nocourse=4;
        }
        else if (courseNum>=19&&courseNum<=21){
            nocourse=5;
        }
        System.out.println(date);
        System.out.println(nocourse);
        System.out.println(courseNum);
        System.out.println(dateString);
        System.out.println(weekDays[w]);

    }
    @Test
    public void testfindCurrentCourse() throws InvocationTargetException, IllegalAccessException {
        Date date=new Date();
        Course course=teachingService.findCurrentCourse(date);
        System.out.println("当前课程为："+course.getName());
    }
}
