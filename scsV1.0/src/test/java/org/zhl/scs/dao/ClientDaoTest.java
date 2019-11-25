package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Client;
import org.zhl.scs.util.PageModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClientDao单元测试
 * @author lzs
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ClientDaoTest {

    @Autowired
    private ClientDao clientDao;

    //测试dao层 save()方法
    @Test
    public void save() {
        Client client = new Client();
        client.setName("zhl04004");

        clientDao.save(client);

        System.out.println("--插入成功--");
        System.out.println(client);
    }

    //测试dao层 update()方法
    @Test
    public void update() {
        Client client = new Client();
        //模拟查询
        client.setId(2);
        client.setName("zhl04017");

        clientDao.update(client);

        System.out.println("--更新成功--");
        System.out.println(client);
    }

    //测试删除方法（略）
    @Test
    public void delete() {

    }

    //测试dao层 count()方法
    @Test
    public void count() {
        Map<String, Object> map = new HashMap<>();
        Integer count = clientDao.count(map);

        System.out.println("--查询总记录数--");
        System.out.println("共" + count + "条数据");
    }

    //测试dao层 selectById()方法
    @Test
    public void selectById() {
        Client client = clientDao.selectById(1);

        System.out.println("--查询成功--");
        System.out.println(client);
    }

    //测试dao层 selectByPage()方法
    @Test
    public void selectByPage() {
        PageModel pageModel = new PageModel();
        Map<String, Object> map = new HashMap<>();

        //设置分页，1页1个数据
        pageModel.setPageIndex(1);
        pageModel.setPageSize(1);
        //设置数据总量
        pageModel.setRecordCount(clientDao.count(map));

        map.put("pageModel", pageModel);

        List<Client> list = new ArrayList<>();
        list = clientDao.selectByPage(map);

        System.out.println("--分页查询成功--");
        System.out.println("--第一页--");
        System.out.println(list);

        pageModel.setPageIndex(2);
        map.put("pageModel", pageModel);

        list = clientDao.selectByPage(map);

        System.out.println("--第二页--");
        System.out.println(list);
    }

    //测试dao层 selectByIdWithClientId()方法
    @Test
    public void selectByIdWithClientId() {
        //略
    }

    //测试dao层 selectAll()方法
    @Test
    public void selectAll() {
        List<Client> clients = clientDao.selectAll();

        System.out.println("--查询成功--");
        System.out.println(clients);
    }

}
