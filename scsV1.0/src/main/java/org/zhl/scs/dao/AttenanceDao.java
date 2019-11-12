package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.AttenanceDynaSqlProvider;
import org.zhl.scs.domain.Attenance;

@Mapper
public interface AttenanceDao{

	@InsertProvider(type=AttenanceDynaSqlProvider.class,method="insertAttenance")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Attenance entity);

	@UpdateProvider(type=AttenanceDynaSqlProvider.class,method="updateAttenance")
	void update(Attenance entity);

	@Delete(" delete from tb_attenance where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=AttenanceDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_attenance where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="date",property="date",javaType=java.util.Date.class),
		@Result(column="total",property="total"),
		@Result(column="actual",property="actual"),
		@Result(column="note",property="note"),
		@Result(column="clazz_id",property="clazz",one=@One(select="org.zhl.scs.dao.ClazzDao.selectByIdWithClazzId",fetchType=FetchType.EAGER)),
		@Result(column="course_id",property="course",one=@One(select="org.zhl.scs.dao.CourseDao.selectByIdWithCourseId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="attendanceDetails",many=@Many(select="org.zhl.scs.dao.AttendanceDetailDao.selectByAttenanceId",fetchType=FetchType.LAZY))
	})
	Attenance selectById(Integer id);

	@SelectProvider(type=AttenanceDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="date",property="date",javaType=java.util.Date.class),
		@Result(column="total",property="total"),
		@Result(column="actual",property="actual"),
		@Result(column="note",property="note"),
		@Result(column="clazz_id",property="clazz",one=@One(select="org.zhl.scs.dao.ClazzDao.selectByIdWithClazzId",fetchType=FetchType.EAGER)),
		@Result(column="course_id",property="course",one=@One(select="org.zhl.scs.dao.CourseDao.selectByIdWithCourseId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="attendanceDetails",many=@Many(select="org.zhl.scs.dao.AttendanceDetailDao.selectByAttenanceId",fetchType=FetchType.LAZY))
	})
	List<Attenance> selectByPage(Map<String, Object> params);

	@Select("select * from tb_attenance where clazz_id = #{id}")
	List<Attenance> selectByClazzId(Integer id);

	@Select("select * from tb_attenance where course_id = #{id}")
	List<Attenance> selectByCourseId(Integer id);

	@Select("select * from tb_attenance where id = #{attendance_id}")
	Attenance selectByIdWithAttenanceId(@Param("attendance_id") Integer id);

}