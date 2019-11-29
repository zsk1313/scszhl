package org.zhl.scs.service.attendance;

import org.zhl.scs.domain.Attenance;
import org.zhl.scs.domain.AttendanceDetail;
import org.zhl.scs.domain.Student;
import org.zhl.scs.domain.vo.AttenanceVo;
import org.zhl.scs.domain.vo.AttendanceDetailVo;
import org.zhl.scs.domain.vo.CourseVo;
import org.zhl.scs.util.PageModel;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 考勤门禁
 * @author lzs
 * @version v1.1
 */
public interface IAttendanceService {

    //-----------考勤管理----------

    /**
     * 保存考勤表
     *
     * @param attenanceVo 考勤表
     */
    void saveAttendance(AttenanceVo attenanceVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 修改考勤表
     *
     * @param attenanceVo 考勤表
     */
    void updateAttendance(AttenanceVo attenanceVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 删除考勤表
     *
     * @param attenanceVo
     */
    void deleteAttendance(AttenanceVo attenanceVo);

    /**
     * 根据课程ID查询考勤表
     *
     * @param attenanceVo
     * @return count
     */
    List<Attenance> selectAttendances(AttenanceVo attenanceVo) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据学生id查询考勤表（不可以为空）
     *
     * @param  attendanceDetailVo
     *
     */
   List<AttendanceDetail> selectAttendanceDetails(AttendanceDetailVo attendanceDetailVo) throws InvocationTargetException, IllegalAccessException;
    /**发布考勤表，或者设定时间，自动发布考勤表
     *
     *
     * @param courseVo
     *
     */
     Attenance  publishAttendances(CourseVo courseVo);

    //---------门禁管理----------
    /**
     * 记录考勤
     *
     * @param attendanceDetailVo
     */
    void attendance(AttendanceDetailVo attendanceDetailVo);

    /**
     * 记录信息
     *
     * @param attenanceVo
     */
    void note(AttenanceVo attenanceVo);

    /**
     * 门禁安全识别
     *
     * @param item
     */
    void identity(Object item);

    /**根据设备信息决定是否开启门禁
     *
     * @param item
     *
     */
     void entranceGuardByDevice(Object item);

    /**门禁管理
     *
     * @@param item
     *
     */
    void GuardManager(Object item);


}
