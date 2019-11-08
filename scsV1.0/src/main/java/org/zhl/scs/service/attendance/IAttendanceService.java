package org.zhl.scs.service.attendance;

import org.zhl.scs.domain.Attenance;

import java.util.Date;
import java.util.List;

/**
 * 考勤门禁
 */
public interface IAttendanceService {

    //-----------考勤管理----------

    /**
     * 保存考勤表
     *
     * @param attendance 考勤表
     */
    void saveAttendance(Attenance attendance);

    /**
     * 修改考勤表
     *
     * @param attendance 考勤表
     */
    void updateAttendance(Attenance attendance);

    /**
     * 删除考勤表
     *
     * @param attendance
     */
    void deleteAttendance(Attenance attendance);

    /**
     * 根据id查询考勤表
     *
     * @param id 考勤表id
     * @return
     */
    Attenance selectAttendanceById(int id);

    /**
     * 根据班级id或课程id查询考勤表（可以为空），判定为空则不加条件
     *
     * @param clazzId  班级id
     * @param courseId 课程id
     * @return
     */
    List<Attenance> selectAttendanceByClazzOrCourse(int clazzId, int courseId);

    /**
     * 根据时间查询考勤表
     *
     * @param date 时间
     * @return
     */
    List<Attenance> selectAttendanceByDate(Date date);

    /**
     * 备用与复杂查询，参数传入枚举类属性来判断条件追加（未实现）
     *
     * @param item
     * @return
     */
    List<Attenance> selectAttendanceByAny(Object item);

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
     * @param item
     */
    void attendance(Object item);

    /**
     * 记录信息
     *
     * @param msg
     */
    void note(Object msg);

}
