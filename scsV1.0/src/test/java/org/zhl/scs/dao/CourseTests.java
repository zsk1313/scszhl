package org.zhl.scs.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.domain.*;
import org.zhl.scs.util.PageModel;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseTests {
    @Autowired
    CourseDao courseDao;
    @Test
    public void testCoursesave(){
/*        User user=new User();
        Job job=new Job();
        job.setId(1);
        user.setId(1);
        Teacher teacher=new Teacher();
        teacher.setId(2);
        teacher.setName("刘老师");
        teacher.setUid("0845");
        teacher.setSex("32");
        teacher.setEntertime(new Date());
        teacher.setDescription("被插入的老师");
        teacher.setUser(user);
        teacher.setJob(job);*/


        Teacher teacher =new Teacher();
        teacher.setId(1);

        Course course=new Course();
        course.setId(7);
        course.setName("ljj");
        course.setClassroom("中海楼04002");
        course.setStart_time(new Date());
        course.setEnd_time(new Date());
        course.setScore(59.9);
        course.setCode("23124");
        course.setWeek(3);
        course.setDateorder(4);
        course.setTeacher(teacher);
        courseDao.save(course);
    }
    @Test
    public void testCourseupdate(){
        Teacher teacher =new Teacher();
        teacher.setId(1);
        Course course=new Course();
        course.setId(7);
        course.setClassroom("中海楼04032");
        course.setStart_time(new Date());
        course.setEnd_time(new Date());
        course.setName("ljjpulse");
        course.setScore(99.9);
        course.setCode("32087");
        course.setWeek(3);
        course.setDateorder(4);
        course.setTeacher(teacher);
        courseDao.update(course);
    }
    @Test
    public void testCoursedeleteById(){
           courseDao.deleteById(2);
    }
    @Test
    public  void testCourseCount(){
        Map<String,Object> params=new HashMap<>();//初始化集合对象
        Course course=new Course();
        course.setClassroom("巴拉巴拉");
        params.put("course",course);
        int count =courseDao.count(params);
        System.out.println("有"+count+"名为巴拉巴拉的记录");
    }
    @Test
    public void testCourseselectById(){
        Course course=courseDao.selectById(3);
        System.out.println(course.toString());
    }
    @Test
    public void testCourseselectByPage(){
        Map<String,Object> params=new HashMap<>();
        Course course=new Course();
        course.setWeek(2);
        params.put("course",course);

        int count=courseDao.count(params);

        PageModel pageModel=new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pageModel",pageModel);
        for (Course course1:courseDao.selectByPage(params)){
            System.out.println(course1);
        }
    }
    @Test
    public void testCourseselectByTeacherId(){
        List<Course> list1=courseDao.selectByTeacherId(2);
        for (int i = 0;i < list1.size(); i ++){
            System.out.println(list1.get(i));
        }
    }
    @Test
    public void testCourseinsertStudents(){
/*        Teacher teacher=new Teacher();
        teacher.setId(1);*/
        Course course=new Course();
        course.setId(7);
        List<Student> students=new ArrayList<>();
        Student student=new Student();
        student.setId(2);
        students.add(student);
        course.setStudents(students);
/*        course.setWeek(2);
        course.setName("wwg");
        course.setTeacher(teacher);
        course.setCode("2342");
        course.setScore(23.2);*/
        courseDao.insertStudents(course);

    }
    @Test
    public void testCourseByFilterOfScore(){

        List<Course> list=courseDao.findCourseByFilterOfScore(50.0,90.0);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByGreaterThanScore(){
        List<Course> list=courseDao.findCourseByGreaterThanScore(50.0);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByFilterOfDateorder(){
        List<Course> list=courseDao.findCourseByFilterOfDateorder(2,3);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByLessThanScore(){
        List<Course> list=courseDao.findCourseByLessThanScore(50.0);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByGreaterThanDateorder(){
        List<Course> list=courseDao.findCourseByGreaterThanDateorder(3);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void testfindCourseByLessThanDateorder(){
        List<Course> list=courseDao.findCourseByLessThanDateorder(2);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).toString());
        }
    }
}
