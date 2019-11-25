package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.domain.Clazz;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.Teacher;
import org.zhl.scs.util.PageModel;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClazzDaoTests {
    @Autowired ClazzDao clazzDao;
    @Test
    public void testClazzsave(){
        Teacher teacher=new Teacher();
        teacher.setId(1);
        Clazz clazz=new Clazz();
        clazz.setId(2);
        clazz.setClazzNum("3421");
        clazz.setDescription("你奶奶个腿");
        clazz.setTeacher(teacher);
        clazzDao.save(clazz);
    }
    @Test
    public void testClazzupdate(){
        Teacher teacher=new Teacher();
        teacher.setId(2);
        Clazz clazz=new Clazz();
        clazz.setId(2);
        clazz.setClazzNum("321312");
        clazz.setDescription("666");
        clazz.setTeacher(teacher);
        clazzDao.update(clazz);
    }
    @Test
    public void testClazzdeleteById(){
           clazzDao.deleteById(2);
    }
    @Test
    public void testClazzcount(){
        Map<String,Object> params=new HashMap<>();
        Clazz clazz=new Clazz();
        clazz.setDescription("wu");
        params.put("clazz",clazz);

        int count=clazzDao.count(params);
        System.out.println("描述为wu的记录一共有"+count+"条");
    }
    @Test
    public void testClazzselectById(){
        Clazz clazz=clazzDao.selectById(2);
        System.out.println(clazz.toString());

    }
    @Test
    public void testClazzselectByPage() {
        Map<String, Object> params = new HashMap<>();
        Clazz clazz = new Clazz();
        clazz.setDescription("wu");
        params.put("clazz", clazz);
        int count = clazzDao.count(params);

        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);

        params.put("pageModel", pageModel);
        for (Clazz clazz1 : clazzDao.selectByPage(params)) {
            System.out.println(clazz1);
        }
    }
}
