package org.zhl.scs.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zhl.scs.Application;
import org.zhl.scs.domain.Client;
import org.zhl.scs.domain.SensorNode;
import org.zhl.scs.util.PageModel;

import java.util.*;

/**
 * SensorNodeDaoDao单元测试类
 * @author lzs
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class SensorNodeDaoTest {

    @Autowired
    private SensorNodeDao sensorNodeDao;

    //测试dao层 save()方法
    @Test
    public void save(){
        //模拟创建一个实体类
        SensorNode sensorNode = new SensorNode();
        sensorNode.setCode("zhl04002pm25001");
        sensorNode.setTime(new Date());
        sensorNode.setType("PM2.5传感器");
        sensorNode.setStatus("enable");
        sensorNode.setFundescription("监控环境PM2.5");
        sensorNode.setAddress("zhl04002");
        sensorNode.setFlag("xxx");
        Client client = new Client();
        client.setId(1);
        sensorNode.setClient(client);

        //调用dao层方法
        sensorNodeDao.save(sensorNode);

        //返回值
        System.out.println("--插入成功--");
        System.out.println(sensorNode);
    }

    //测试dao层 update()方法
    @Test
    public void update() {
        SensorNode sensorNode = new SensorNode();
        //模拟查询
        sensorNode.setId(1);

        sensorNode.setStatus("disable");

        sensorNodeDao.update(sensorNode);

        System.out.println("--更新成功--");
        System.out.println(sensorNode);
    }

    //测试删除方法（略）
    @Test
    public void delete() {

    }

    //测试dao层 count方法
    @Test
    public void count() {
        Map<String, Object> map = new HashMap<>();
        int i = sensorNodeDao.count(map);

        System.out.println("--查询总记录数--");
        System.out.println("共" + i + "条数据");
    }

    //测试dao层 selectById方法
    @Test
    public void selectById() {
        SensorNode sensorNode = sensorNodeDao.selectById(1);

        System.out.println("--查询成功--");
        System.out.println(sensorNode);
    }

    //测试dao层 selectByPage方法
    @Test
    public void selectByPage() {
        PageModel pageModel = new PageModel();
        Map<String, Object> map = new HashMap<>();

        //设置分页，1页1个数据
        pageModel.setPageIndex(1);
        pageModel.setPageSize(1);
        //设置数据总量
        pageModel.setRecordCount(sensorNodeDao.count(map));

        map.put("pageModel", pageModel);

        List<SensorNode> list = new ArrayList<>();
        list = sensorNodeDao.selectByPage(map);

        System.out.println("--分页查询成功--");
        System.out.println("--第一页--");
        System.out.println(list);

        pageModel.setPageIndex(2);
        map.put("pageModel", pageModel);

        list = sensorNodeDao.selectByPage(map);

        System.out.println("--第二页--");
        System.out.println(list);
    }

    //测试dao层 selectByClientId方法
    @Test
    public void selectByClientId() {
        List<SensorNode> sensorNodes = sensorNodeDao.selectByClientId(1);

        System.out.println("--查询成功--");
        System.out.println(sensorNodes);
    }

    //测试dao层 selectAll方法
    @Test
    public void selectAll() {
        List<SensorNode> sensorNodes = sensorNodeDao.selectAll();

        System.out.println("--查询成功--");
        System.out.println(sensorNodes);
    }

}
