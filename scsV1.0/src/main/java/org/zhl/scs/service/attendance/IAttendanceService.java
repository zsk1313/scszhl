package org.zhl.scs.service.attendance;

import org.zhl.scs.domain.Attenance;
import org.zhl.scs.domain.AttendanceDetail;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.vo.AttenanceVo;
import org.zhl.scs.domain.vo.AttendanceDetailVo;
import org.zhl.scs.domain.vo.CourseVo;
import org.zhl.scs.util.PageModel;

import java.util.List;

/**
 * 考勤门禁
 */
public interface IAttendanceService {

    //-----------考勤管理----------

    /**
     * 保存考勤表
     *
     * @param attenanceVo 考勤表
     */
    void saveAttendance(AttenanceVo attenanceVo);

    /**
     * 修改考勤表
     *
     * @param attenanceVo 考勤表
     */
    void updateAttendance(AttenanceVo attenanceVo);

    /**
     * 删除考勤表
     *
     * @param attenanceVo
     */
    void deleteAttendance(AttenanceVo attenanceVo);

    /**
     * 查询考勤表
     *
     * @param attenance   pageModel
     * @return count
     */
    Attenance selectAttendance(Attenance attenance, PageModel pageModel);

    /**
     * 根据班级id或课程id查询考勤表（可以为空），判定为空则不加条件
     *
     * @param attenance   pageModel
     * @return attenances
     */
    List<Attenance> selectAttendances(Attenance attenance, PageModel pageModel);
    /**发布考勤表，或者设定时间，自动发布考勤表
     *
     *
     * @param courseVo
     *
     */
     Attenance  publishAttendances(CourseVo courseVo);

    //---------门禁管理----------

    /**
     * 门禁安全识别
     *
     * @param item
     */
    void identity(Object item);

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

    /**根据设备信息决定是否开启门禁
     *
     * @param
     *
     */
     void entranceGuardByDevice(Object item);
}
