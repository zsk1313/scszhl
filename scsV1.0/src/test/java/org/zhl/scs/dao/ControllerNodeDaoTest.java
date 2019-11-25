package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.ControllerNode;
import org.zhl.scs.util.PageModel;

import java.util.*;

/**
 * ControllerNodeDao单元测试类
 * @author lzs
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ControllerNodeDaoTest {

    @Autowired
    private ControllerNodeDao controllerNodeDao;

    //测试dao层 save()方法
    @Test
    public void save() {
        ControllerNode controllerNode = new ControllerNode();
        Client client = new Client();

        client.setId(1);
        controllerNode.setCode("zhl04002kt003");
        controllerNode.setTime(new Date());
        controllerNode.setType("风扇");
        controllerNode.setStatus("enable");
        controllerNode.setValue("25");
        controllerNode.setAddress("zhl04002");
        controllerNode.setFlag("xxx");
        controllerNode.setClient(client);

        controllerNodeDao.save(controllerNode);

        System.out.println("--插入成功--");
        System.out.println(controllerNode);
    }

    //测试dao层 update()方法
    @Test
    public void update() {
        ControllerNode controllerNode = new ControllerNode();
        controllerNode.setId(1);

        controllerNode.setValue("20");

        controllerNodeDao.update(controllerNode);

        System.out.println("--更新成功--");
        System.out.println(controllerNode);
    }

    //测试删除方法（略）
    @Test
    public void delete() {

    }

    //测试dao层 count()方法
    @Test
    public void count() {
        Map<String, Object> map = new HashMap<>();
        Integer count = controllerNodeDao.count(map);

        System.out.println("--查询总记录数--");
        System.out.println("共" + count + "条数据");
    }

    //测试dao层 selectById()方法
    @Test
    public void selectById() {
        ControllerNode controllerNode = controllerNodeDao.selectById(1);

        System.out.println("--查询成功--");
        System.out.println(controllerNode);
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
        pageModel.setRecordCount(controllerNodeDao.count(map));

        map.put("pageModel", pageModel);

        List<ControllerNode> list = new ArrayList<>();
        list = controllerNodeDao.selectByPage(map);

        System.out.println("--分页查询成功--");
        System.out.println("--第一页--");
        System.out.println(list);

        pageModel.setPageIndex(2);
        map.put("pageModel", pageModel);

        list = controllerNodeDao.selectByPage(map);

        System.out.println("--第二页--");
        System.out.println(list);

        pageModel.setPageIndex(3);
        map.put("pageModel", pageModel);

        list = controllerNodeDao.selectByPage(map);

        System.out.println("--第三页--");
        System.out.println(list);
    }

    //测试dao层 selectByClientId()方法
    @Test
    public void selectByClientId() {
        List<ControllerNode> controllerNodes = controllerNodeDao.selectByClientId(1);

        System.out.println("--查询成功--");
        System.out.println(controllerNodes);
    }

    //测试dao层 selectAll()方法
    @Test
    public void selectAll() {
        List<ControllerNode> controllerNodes = controllerNodeDao.selectAll();

        System.out.println("--查询成功--");
        System.out.println(controllerNodes);
    }

}
