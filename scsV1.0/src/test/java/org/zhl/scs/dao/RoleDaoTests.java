package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Menu;
import org.zhl.scs.domain.Role;
import org.zhl.scs.domain.User;
import org.zhl.scs.util.PageModel;

import java.util.*;

/**
 * 角色Dao测试类
 */
@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {Application.class})
public class RoleDaoTests {
    @Autowired
    RoleDao roleDao;

    @Test
    public void contextLoads() {}

    @Test
    public void testRoleSave(){
        Role role=new Role();
        role.setName("Role_test");
        role.setDescription("测试");
        roleDao.save(role);
    }

    @Test
    public void testRoleUpdate(){
        Role role=roleDao.selectById(6);
        role.setDescription("测试2");
        roleDao.update(role);
    }

    @Test
    public void testRoleCount(){
        Map<String,Object> params=new HashMap<>();
        Role role=new Role();
        role.setDescription("测试");
        params.put("role",role);
        int count=roleDao.count(params);
        System.out.println(count);
    }

    @Test
    public void testRolePage(){
        Map<String,Object> params=new HashMap<>();
        Role role=new Role();
        role.setDescription("测试");
        params.put("role",role);
        int count=roleDao.count(params);
        PageModel pageModel=new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);
        params.put("pageModel",pageModel);
        for (Role role2:roleDao.selectByPage(params)) {
            System.out.println(role2);
        }
    }

    @Test
    public void testInsertUsers(){
        Role role=roleDao.selectById(6);
        List<User> users=new ArrayList<>();
        for (int i=3;i<5;i++){
            User user=new User();
            user.setId(i);
            users.add(user);
        }
        role.setUsers(users);
        roleDao.insertUsers(role);
    }

    @Test
    public void testInsertMenus(){
        Role role=roleDao.selectById(6);
        List<Menu> menus=new ArrayList<>();
        for (int i=8;i<10;i++){
            Menu menu=new Menu();
            menu.setId(i);
            menus.add(menu);
        }
        role.setMenus(menus);
        roleDao.insertMenus(role);
    }

    @Test
    public void testSelectByIds(){
        List<Integer> roleIds=new ArrayList<>();
        roleIds.add(1);
        roleIds.add(2);
        Map<String,Object> params=new HashMap<>();
        params.put("roleIds",roleIds);
        roleDao.selectByIds(params);

    }
}
