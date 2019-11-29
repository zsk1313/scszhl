package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Job;
import org.zhl.scs.domain.Teacher;
import org.zhl.scs.domain.User;
import org.zhl.scs.util.PageModel;
import org.zhl.scs.util.common.Sex;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 教师Dao测试类
 */
@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {Application.class})
public class TeacherDaoTests {
    @Autowired
    TeacherDao teacherDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testTeacherSave(){
        Teacher teacher=new Teacher();
        teacher.setName("黄艺培");
        teacher.setAddress("广东广州");
        teacher.setEntertime(new Date());
        teacher.setBirthday(new Date());
        teacher.setUid("8");
        teacher.setDescription("软件工程资深专家");
        User user=new User();
        user.setId(8);
        teacher.setUser(user);
        Job job=new Job();
        job.setId(1);
        teacher.setJob(job);
        teacher.setSex(Sex.MALE);
        teacherDao.save(teacher);
    }

    @Test
    public void testTeacherUpdate(){
        Teacher teacher=teacherDao.selectById(2);
        teacher.setSex(Sex.FEMALE);
        teacherDao.update(teacher);
    }

    @Test
    public void testTeacherDelete(){
        teacherDao.deleteById(2);
    }

    @Test
    public void testTeacherCount(){
        Map<String,Object> params=new HashMap<>();
        Teacher teacher=new Teacher();
        teacher.setName("刘");
        params.put("teacher",teacher);
        int count=teacherDao.count(params);
        System.out.println(count);

    }

    @Test
    public void testTeacherPage(){
        Map<String,Object> params=new HashMap<>();
        Teacher teacher=new Teacher();
        teacher.setName("刘");
        params.put("teacher",teacher);
        int count=teacherDao.count(params);
        PageModel pageModel=new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);
        params.put("pageModel",pageModel);
        for (Teacher teacher2:teacherDao.selectByPage(params)) {
            System.out.println(teacher2);
        }
    }

}
