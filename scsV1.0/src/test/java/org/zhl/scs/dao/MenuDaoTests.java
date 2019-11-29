package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Menu;
import org.zhl.scs.domain.Role;
import org.zhl.scs.util.PageModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色Dao测试类
 */
@RunWith(SpringRunner.class)
//使用随机端口启动测试服务
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = {Application.class})
public class MenuDaoTests {
    @Autowired
    MenuDao menuDao;

    @Test
    public void contextLoads() {}

    @Test
    public void testMenuSave(){
        Menu menu=new Menu();
        menu.setPattern("/test3/**");
        menuDao.save(menu);
    }

    @Test
    public void testMenuUpdate(){
        Menu menu=menuDao.selectById(10);
        menu.setPattern("/test4/**");
        menuDao.update(menu);
    }

    @Test
    public void testMenuCount(){
        Map<String,Object> params=new HashMap<>();
        Menu menu=new Menu();
        menu.setPattern("/test4/**");
        params.put("menu",menu);
        int count=menuDao.count(params);
        System.out.println(count);
    }

    @Test
    public void testMenuPage(){
        Map<String,Object> params=new HashMap<>();
        Menu menu=new Menu();
        menu.setPattern("/");
        params.put("menu",menu);
        int count=menuDao.count(params);
        PageModel pageModel=new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(1);
        params.put("pageModel",pageModel);
        for (Menu menu2:menuDao.selectByPage(params)) {
            System.out.println(menu2);
        }
    }

    @Test
    public void testInsertRoles(){
        Menu menu=menuDao.selectById(10);
        List<Role> roles=new ArrayList<>();
        for (int i=6;i<8;i++){
            Role role=new Role();
            role.setId(i);
            roles.add(role);
        }
        menu.setRoles(roles);
        menuDao.insertRoles(menu);
    }

    @Test
    public void testGetAllMenu(){
        for(Menu menu:menuDao.getAllMenus()){
            System.out.println(menu);
        }
    }

}
