package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.AttendanceDetailDynaSqlProvider;
import org.zhl.scs.domain.AttendanceDetail;

@Mapper
public interface AttendanceDetailDao{

	@InsertProvider(type=AttendanceDetailDynaSqlProvider.class,method="insertAttendanceDetail")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(AttendanceDetail entity);

	@UpdateProvider(type=AttendanceDetailDynaSqlProvider.class,method="updateAttendanceDetail")
	void update(AttendanceDetail entity);

	@Delete(" delete from tb_attendance_detail where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=AttendanceDetailDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_attendance_detail where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="isattendance",property="isattendance"),
        @Result(column="sing_time",property="signtime",javaType=java.util.Date.class),
		@Result(column="student_id",property="student",one=@One(select="org.zhl.scs.dao.StudentDao.selectByIdWithStudentId",fetchType=FetchType.EAGER)),
		@Result(column="attendance_id",property="attenance",one=@One(select="org.zhl.scs.dao.AttenanceDao.selectByIdWithAttenanceId",fetchType=FetchType.EAGER))
	})
	AttendanceDetail selectById(Integer id);

	@SelectProvider(type=AttendanceDetailDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="isattendance",property="isattendance"),
        @Result(column="sing_time",property="signtime",javaType=java.util.Date.class),
		@Result(column="student_id",property="student",one=@One(select="org.zhl.scs.dao.StudentDao.selectByIdWithStudentId",fetchType=FetchType.EAGER)),
		@Result(column="attendance_id",property="attenance",one=@One(select="org.zhl.scs.dao.AttenanceDao.selectByIdWithAttenanceId",fetchType=FetchType.EAGER))
	})
	List<AttendanceDetail> selectByPage(Map<String, Object> params);

	@Select("select * from tb_attendance_detail where student_id = #{id}")
	List<AttendanceDetail> selectByStudentId(Integer id);

	@Select("select * from tb_attendance_detail where attendance_id = #{id}")
	List<AttendanceDetail> selectByAttenanceId(Integer id);

}