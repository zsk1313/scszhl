package org.zhl.scs.dao;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Role;
import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.User;
import org.zhl.scs.exception.EntityNotFoundException;
import org.zhl.scs.util.DaoUtil;
import org.zhl.scs.util.PageModel;

import java.lang.instrument.IllegalClassFormatException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 用户Dao测试类
 */
@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {Application.class})
public class UserDaoTests {
    @Autowired
    UserDao userDao;

    @Autowired
    DaoUtil daoUtil;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserSave(){
        User user=new User();
        user.setUsername("ljj");
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode("123"));
        userDao.save(user);
    }

    @Test
    public void testUserUpdate(){
        User user=userDao.selectById(5);
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode("456"));
        user.setEnable(false);
        user.setLocked(false);
        System.out.println(bCryptPasswordEncoder.matches("456",user.getPassword()));
        System.out.println(user.getId());
        userDao.update(user);
    }

    @Test
    public void testUserDelete(){
        userDao.deleteById(6);
    }

    @Test
    public void testUserCount(){
        Map<String,Object> params=new HashMap<>();
        User user=new User();
        user.setUsername("lzs");
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode("456"));
        params.put("user",user);
        int count=userDao.count(params);
        System.out.println(count);
        System.out.println(user.getPassword());

    }

    @Test
    public void testUserPage(){
        Map<String,Object> params=new HashMap<>();
        User user=new User();
        user.setEnable(true);
//        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//        user.setPassword(bCryptPasswordEncoder.encode("456"));
        params.put("user",user);
        int count=userDao.count(params);

        PageModel pageModel=new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);
        params.put("pageModel",pageModel);

        for (User user2:userDao.selectByPage(params)) {
            System.out.println(user2);
        }
    }

    @Test
    public void testInsertRoles(){
        User user=userDao.selectById(12);
        List<Role> roles=new ArrayList<>();
        for (int i=3;i<5;i++){
            Role role=new Role();
            role.setId(i);
            roles.add(role);
        }
        user.setRoles(roles);
        userDao.insertRoles(user);
    }

    @Test
    public void testDeleteRoles(){
        User user=userDao.selectById(12);
        userDao.deleteRoles(user);
    }

    @Test
    public void testDaoUtil(){
        try {
            User user=daoUtil.checkEntityById(UserDao.class,User.class,12);
            user=daoUtil.checkEntityById(UserDao.class,User.class,null);
            user=daoUtil.checkEntityById(UserDao.class,User.class,-1);
            user=daoUtil.checkEntityById(UserDao.class, Student.class,12);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalClassFormatException e) {
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

}
