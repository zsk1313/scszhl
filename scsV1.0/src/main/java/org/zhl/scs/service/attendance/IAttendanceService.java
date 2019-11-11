package org.zhl.scs.service.attendance;

import org.zhl.scs.domain.Attenance;
import org.zhl.scs.domain.vo.AttenanceVo;

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
     * @param attenance 考勤表
     */
    void saveAttendance(AttenanceVo attenance);

    /**
     * 修改考勤表
     *
     * @param attenance 考勤表
     */
    void updateAttendance(AttenanceVo attenance);

    /**
     * 删除考勤表
     *
     * @param attenance
     */
    void deleteAttendance(AttenanceVo attenance);

    /**
     * 查询考勤表
     *
     * @param item
     * @return
     */
    Attenance selectAttendance(Object item);

    /**
     * 根据班级id或课程id查询考勤表（可以为空），判定为空则不加条件
     *
     * @param item
     * @return
     */
    List<Attenance> selectAttendances(Object item);


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
