package org.zhl.scs.service.attendance.Impl;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhl.scs.dao.*;
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
import java.util.*;

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
    @Autowired
    private StudentDao studentDao;

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
    public void updateAttendance(AttenanceVo attenanceVo) throws InvocationTargetException, IllegalAccessException {
        //获取vo里面的数据并转化为save方法所使用的实体
        Attenance attenance=attenanceDao.selectById(attenanceVo.getId());
        Course course = courseDao.selectById(attenanceVo.getCourseId());
        attenance.setCourse(course);
        Clazz clazz = clazzDao.selectById(attenanceVo.getClazzId());

        AssignByFieldName.getInstance().Assign(attenanceVo,attenance);
        attenanceDao.update(attenance);
        System.out.println("考勤表已更新，请刷新后查看");

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
    /**根据课程ID查询考勤表
     *统计考勤表数量
     * @param attenanceVo
     *
     */
   public List<Attenance> selectAttendances(AttenanceVo attenanceVo) throws InvocationTargetException, IllegalAccessException {


      Map<String, Object> params = new HashMap<>();
        List<Attenance> attenanceList = new ArrayList<>();
        Attenance attenance = new Attenance();
        AssignByFieldName.getInstance().Assign(attenance,attenanceVo);
        params.put("attenance",attenance);
        int count = attenanceDao.count(params);
        System.out.println(count);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(2);
        params.put("pageModel", pageModel);
        for (Attenance attenance1 : attenanceDao.selectByPage(params)) {
            attenanceList.add(attenance1);
        }

            return attenanceList;

    }

    @Override

    /**
     * 根据学生ID查询考勤表（不可以为空）
     *
     * @param  attendanceDetailVo
     *
     */
    public List<AttendanceDetail> selectAttendanceDetails(AttendanceDetailVo attendanceDetailVo) throws InvocationTargetException, IllegalAccessException {
        /**
         *根据学生ID查询
         *
         *
         */

        Map<String, Object> params = new HashMap<>();
        List<AttendanceDetail> attendanceDetailList = new ArrayList<>();
        AttendanceDetail attendanceDetail = new AttendanceDetail();
        AssignByFieldName.getInstance().Assign(attendanceDetail,attendanceDetailVo);
        params.put("attendanceDetail",attendanceDetail);
        int count = attendanceDetailDao.count(params);
        System.out.println(count);
        PageModel pageModel = new PageModel();
        pageModel.setRecordCount(count);
        pageModel.setPageIndex(2);
        params.put("pageModel", pageModel);
        for (AttendanceDetail attendanceDetail1 : attendanceDetailDao.selectByPage(params)) {
            attendanceDetailList.add(attendanceDetail1);
        }

        return attendanceDetailList;

    }

    @Override
    // 发布考勤表
    /**每天查询课程表，获取第二天应该考勤的教室和时间
     * 首先要确定这张考勤表所对应的教室,由course表中的classroom属性进判断
     * 考勤开始时间由课程数courseVo中的start_time进行判断
     *需要考勤的教室由courseVo中对应的classroom进行判断
     *
     *
     * 考勤表中的时间纪录的是考勤表的保存时间
     *
     */
    public Attenance publishAttendances(CourseVo courseVo) {
        AttenanceVo attenanceVo = new AttenanceVo();
        Attenance attenance = new Attenance();
        //发布时间为每天的00:00
        //使用线程池scheduleAtFixedRate方法
        /**待实现
         *
         *
         */


        //考勤表id是自动生成


        //应到人数,查询学生选课表
        //选该门课程的学生数量统计出来
       List<Integer> students = courseVo.getStudentIds();
       int totalnum = students.size();
        attenance.setTotal(totalnum);
//     //实到人数 ,等待考勤时间结束后进行统计
//     //根据考勤表ID外键查询考勤信息表，列成数组并计算长度，获得实到人数
        List<AttendanceDetail> studentsnum = attendanceDetailDao.selectByAttenanceId(attenance.getId());
        int actualnum = studentsnum.size();
//        int actualnum =0 ;
//        for(AttendanceDetail list:studentsnum){
//            if(list.getIsattendance()==1){ actualnum++;}
//        }
       attenance.setActual(actualnum);
       attenanceDao.update(attenance);




        //考勤表发放到的教室
        //根据courseVo中的classroom属性寻找到对应的教室
        //在对应教室的考勤设备中发布考勤消息
        String clazzroom = courseVo.getClassroom();
        System.out.println("考勤表发放到的教室有："+clazzroom);


        String Message = attenance.toString();
        System.out.println(Message);
        return null;
    }

    @Override
    /**门禁识别(未实现)
     *调用设备管理的方法进行处理
     *
     */
    public void identity(Object item) {
        //接收设备传输的信息，决定操作
       int message = (int) item;
       switch (message){
           case 0:
               System.out.print("欢迎管理员进行使用");
               break;
           case 1:
               System.out.print("欢迎教师进行使用");
               break;
           case 2:
               System.out.print("您没有相关权限！");
               break;
           case 3:
               System.out.print("您没有相关权限！");
               break;


       }



    }

    @Override
    /**考勤记录
     *
     *
     * @param attendanceDetailVo
     *
     */
    public void attendance(AttendanceDetailVo attendanceDetailVo) {
        Attenance attenance = new Attenance();
        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attenance = attenanceDao.selectById(attendanceDetailVo.getAttenanceId());
        //接收设备传感器信息
        //当传感器信息传输到这里，自动记录时间，
        //如果不在考勤时间内，返回消息"考勤超时"
        //否则返回“考勤成功”
        Date sitime = attendanceDetailVo.getSignTime();
        //迟到时间设置为上课开始时间
        Course course = attenance.getCourse();
        Date attime = course.getStart_time();
        System.out.println(sitime);

         //考勤后，将考勤结果记录到考勤信息表和考勤表
        if(sitime.getTime()<=attime.getTime()) {
            //保存学生
            Student student = studentDao.selectById(attendanceDetailVo.getStudentId());
            attendanceDetail.setStudent(student);
            //保存为已考勤
            attendanceDetail.setIsattendance(1);
            //保存考勤时间
            attendanceDetail.setSignTime(sitime);
            //保存对应的考勤表id
            attendanceDetail.setAttenance(attenance);
            //保存考勤信息
            attendanceDetailDao.save(attendanceDetail);
            System.out.println("考勤成功");
        }else {
            //保存学生
            Student student = studentDao.selectById(attendanceDetailVo.getStudentId());
            attendanceDetail.setStudent(student);
            //保存为已考勤
            attendanceDetail.setIsattendance(0);
            //保存考勤时间
            attendanceDetail.setSignTime(sitime);
            //保存对应的考勤表id
            attendanceDetail.setAttenance(attenance);
            //保存考勤信息
            attendanceDetailDao.save(attendanceDetail);
            System.out.println("考勤超时");
        }

    }

    @Override

    /**填写考勤表备注信息
     *
     * @param attenanceVo
     */
    public void note(AttenanceVo attenanceVo) {
        //寻找需要写入的考勤表,值传给attenance
        Attenance attenance = attenanceDao.selectById(attenanceVo.getId());
        //写入备注信息,更新考勤表
        attenance.setNote(attenanceVo.getNote());
        attenanceDao.update(attenance);
        System.out.println("It's updated,refresh please!");
    }

    @Override
    /**根据设备传来的权限信息管理门禁（未实现）
     *
     * @param item
     *
     *
     *
     */

    public void entranceGuardByDevice(Object item) {
//用户在门禁设备登录，根据用户权限判断是否开启门禁和设备，并显示该教室课表
        //查询当前教室

        int ctrl = (int) item;
        switch (ctrl){
            case 0:
                //根据教室编号打开当前教室内的设备，按照默认设置设定
                System.out.println("打开设备，显示课表");
        }

        //关闭门禁

    }

    @Override
    /**门禁管理，只有管理员能够进行增删改查，教师进行使用，其他人不具备权限
     *
     *
     *
     */
    public void GuardManager(Object item) {

    }
}