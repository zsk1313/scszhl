package org.zhl.scs.service.attendance.Impl;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhl.scs.dao.AttenanceDao;
import org.zhl.scs.dao.AttendanceDetailDao;
import org.zhl.scs.dao.ClazzDao;
import org.zhl.scs.dao.CourseDao;
import org.zhl.scs.domain.*;
import org.zhl.scs.domain.vo.AttenanceVo;
import org.zhl.scs.domain.vo.AttendanceDetailVo;
import org.zhl.scs.domain.vo.CourseVo;
import org.zhl.scs.service.attendance.IAttendanceService;
import org.zhl.scs.util.AssignByFieldName;
import org.zhl.scs.util.PageModel;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.UIManager.*;

/**IAttendanceService的实现类
 * @author hyp
 *
 *
 */


@Service("IAttendanceService")
public class AttendanceServiceImpl implements IAttendanceService {
    //自动注入持久层对象
    @Autowired
    private AttenanceDao attenanceDao;
    @Autowired
    private AttendanceDetailDao attendanceDetailDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ClazzDao clazzDao;

    @Override
    //@Transactional(rollbackFor = Exception.class)
    /**保存考勤表
     *
     * @param attenanceVo
     *
     */
    public void saveAttendance(AttenanceVo attenanceVo) throws InvocationTargetException, IllegalAccessException {
        //获取vo里面的数据并转化为save方法所使用的实体
        Attenance attenance= new Attenance();
        AssignByFieldName.getInstance().Assign(attenanceVo,attenance);

        Course course = courseDao.selectById(attenanceVo.getCourseId());
        attenance.setCourse(course);
        Clazz clazz = clazzDao.selectById(attenanceVo.getClazzId());
        attenance.setClazz(clazz);
        attenance.setId(attenanceVo.getId());
        attenance.setDate(attenanceVo.getDate());
        attenance.setTotal(attenanceVo.getTotal());
        attenance.setNote(attenanceVo.getNote());
        attenanceDao.save(attenance);
        System.out.println("考勤表已保存，请刷新后查看");
    }

    @Override
  //  @Transactional(rollbackFor = Exception.class)
    /**根据id更改考勤表
     *
     * @param attenanceVo
     *
     */
    public void updateAttendance(AttenanceVo attenanceVo) {
        //获取vo里面的数据并转化为save方法所使用的实体
        Attenance attenance=attenanceDao.selectById(attenanceVo.getId());
        Course course = courseDao.selectById(attenanceVo.getCourseId());
        attenance.setCourse(course);
        Clazz clazz = clazzDao.selectById(attenanceVo.getClazzId());

        attenance.setId(attenanceVo.getId());
        attenance.setDate(attenanceVo.getDate());
        attenance.setTotal(attenanceVo.getTotal());
        attenance.setNote(attenanceVo.getNote());
        attenanceDao.update(attenance);


    }

    @Override
   // @Transactional(rollbackFor = Exception.class)
    /**根据id删除考勤表
     *
     * @param attenanceVo
     *
     */
    public void deleteAttendance(AttenanceVo attenanceVo) {
        attenanceDao.deleteById(attenanceVo.getId());
        System.out.println("删除完成");

    }

    @Override
    /**查询考勤表
     *统计考勤表数量
     * @param attenance
     *
     */
   public Attenance selectAttendance(Attenance attenance, PageModel pageModel) {
       Map<String,Object>params = new HashMap<>();

        params.put("Attendance1",attenance);
        /**开始分页查询：查询第几页数据
         *
         *
         */

        int recordCount = attenanceDao.count(params);
        System.out.println("recordCount-->>"+recordCount);
        pageModel.setRecordCount(recordCount);
        if(recordCount  > 0){

            params.put("pageModel",pageModel);

        }
       List<Attenance> attenances = attenanceDao.selectByPage(params);


        return (Attenance) attenances;//返回查询结果
    }

    @Override

    /**
     * 根据班级id或课程id查询考勤表（可以为空），判定为空则不加条件
     *
     * @param attenance   pageModel
     * @return attenances
     */
    public List<Attenance> selectAttendances(Attenance attenance, PageModel pageModel) {
        /**判断过来的数据是课程id或者班级id是否为空
         *
         *
         *
         */
        Map<String,Object>params = new HashMap<>();
           Course course = new Course();
           int courseId =  course.getId();
           Clazz clazz =new Clazz();
           int clazzId = clazz.getId();
           List<Attenance> attenances;

           if(clazzId == 0){
             attenances = attenanceDao.selectByCourseId(courseId );
           }else {
               attenances = attenanceDao.selectByClazzId(courseId );
           }

        return attenances;
    }

    @Override
    // 发布考勤表
    /**每天查询课程表，获取第二天应该考勤的教室和时间
     * 首先要确定这张考勤表所对应的课程，并根据课程寻找到对应的教室
     * 考勤开始时间由课程数courseVo中的start_time进行判断
     *需要考勤的教室由courseVo中对应的classroom进行判断
     *
     *
     * 考勤表中的时间纪录的是考勤表的保存时间
     *
     */
    public Attenance publishAttendances(CourseVo courseVo) {
        AttenanceVo attenanceVo = new AttenanceVo();

//        //获取课程ID和班级ID
//        Clazz clazz = clazzDao.selectById(courseVo.)
//        attenance.setClazz(clazz);
//
//        Attenance course = attenanceDao.selectById(courseVo.getId());
//        attenance.setCourse(course);
//        //应到人数,查询学生选课表
//        //遍历  学生课程表 ，把和选该门课程的学生数量统计出来
//
//
//        List<Integer> students = courseVo.getStudentIds();
//        int totalnum = students.size();
//        attenance.setTotal(totalnum);
//
//        //实到人数
//
//        List<Integer> acstudents = attenanceVo.getAttendanceDetailIds();
//        int actualnum = acstudents.size();
//        attenance.setActual(actualnum);
//
//        //发布时间
//        Date df = new Date("yyyy-MM-dd HH:mm:ss");
//        attenance.setDate(df);
//
//        //考勤时间,只有在考勤时间内打卡才能算是有效考勤
//      //Date Starttime = courseVo.getStart_time();
//      //long attime = 15*60*1000;
//      //Date Endtime = new Date(Starttime.getTime()+attime);
//
//
//        //考勤表发放到的教室
//        //根据courseVo中的classroom属性寻找到对应的教室
//        //在对应教室的考勤设备中发布考勤消息
//
//
//
//        attenanceDao.save(attenance);
        return null;
    }

    @Override
    /**门禁识别
     *调用设备管理的方法进行处理
     *
     */
    public void identity(Object item) {
        //接收设备传输的信息，决定操作



        //调用设备管理模块进行操作
        //  device.void();



        //




    }

    @Override
    /**考勤记录
     *
     *
     * @param attendanceDetailVo
     *
     */
    public void attendance(AttendanceDetailVo attendanceDetailVo) {
        //接收设备传感器信息


        //当传感器信息传输到这里，自动记录时间，
        //如果不在考勤时间内，返回消息"超过时间，考勤失败"
        //否则返回“考勤成功”
//        Date sitime = attendanceDetailVo.getSigntime();
//        Date attime = attenance.getDate();
//
//
//        if(sitime.getTime()<attime.getTime()) {
//            AttendanceDetail attendanceDetail = attendanceDetailDao.selectById(attendanceDetailVo.getAttenanceId());
//            attendanceDetail.setAttenance(attendanceDetail);
//            attendanceDetailDao.save(attendanceDetail);
//            System.out.println("考勤成功");
//        }else {
//            System.out.println("考勤失败");
//        }

    }

    @Override

    /**填写考勤表备注信息
     *
     * @param attenanceVo
     */
    public void note(AttenanceVo attenanceVo) {
//        //根据课程号寻找需要写入的考勤表
//        attenance.setId(attenanceVo.getId());
//
//        //写入备注信息
//        String message = attenanceVo.getNote();
//        attenance.setNote(message);
//        attenanceDao.save(attenance);
    }

    @Override
    /**根据设备传来的权限信息管理门禁
     *
     * @param item
     *
     *
     *
     */



    public void entranceGuardByDevice(Object item) {


        //开启门禁


        //关闭门禁

    }
}