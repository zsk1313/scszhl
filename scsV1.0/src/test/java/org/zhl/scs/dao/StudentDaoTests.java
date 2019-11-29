package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.User;
import org.zhl.scs.util.PageModel;
import org.zhl.scs.util.common.Sex;

import java.util.*;

/**
 * 学生Dao测试类
 */
@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {Application.class})
public class StudentDaoTests {
    @Autowired
    StudentDao studentDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testStudentSave(){
        Student student=new Student();
        student.setUid("201611701323");
        student.setName("ljj宫本哥");
        student.setAddress("广东广州");
        student.setBirthday(new Date());
        Clazz clazz=new Clazz();
        clazz.setId(1);
        student.setClazz(clazz);
        student.setNativeplace("广东广州");
        student.setAdmissiontime(new Date());
        student.setProfession("软件工程");
        User user=new User();
        user.setId(7);
        student.setUser(user);
        student.setPostcode("528200");
        studentDao.save(student);
    }

    @Test
    public void testStudentUpdate(){
        Student student=studentDao.selectById(2);
        System.out.println(student.getSex());
        student.setSex(Sex.MALE);
        studentDao.update(student);
    }

    @Test
    public void testStudentDelete(){
        studentDao.deleteById(4);
    }

    @Test
    public void testStudentCount(){
        Map<String,Object> params=new HashMap<>();
        Student student=new Student();
        student.setName("lzs");
        params.put("student",student);
        int count=studentDao.count(params);
        System.out.println(count);

    }

    @Test
    public void testStudentPage(){
        Map<String,Object> params=new HashMap<>();
        Student student=new Student();
        student.setName("lzs");
        params.put("student",student);
        int count=studentDao.count(params);
        PageModel pageModel=new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);
        params.put("pageModel",pageModel);
        for (Student Student2:studentDao.selectByPage(params)) {
            System.out.println(Student2);
        }
    }

    @Test
    public void testInsertCourses(){
        Student student=studentDao.selectById(5);
        List<Course> courses=new ArrayList<>();
        for (int i=1;i<3;i++){
            Course course=new Course();
            course.setId(i);
            courses.add(course);
        }
        student.setCourses(courses);
        studentDao.insertCourses(student);
    }
}
