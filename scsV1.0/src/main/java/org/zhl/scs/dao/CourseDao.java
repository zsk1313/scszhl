package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.CourseDynaSqlProvider;
import org.zhl.scs.domain.Course;

@Mapper
public interface CourseDao{

	@InsertProvider(type=CourseDynaSqlProvider.class,method="insertCourse")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Course entity);

	@UpdateProvider(type=CourseDynaSqlProvider.class,method="updateCourse")
	void update(Course entity);

	@Delete(" delete from tb_course where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=CourseDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_course where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="score",property="score"),
		@Result(column="code",property="code"),
		@Result(column="week",property="week"),
		@Result(column="dateorder",property="dateorder"),
		@Result(column="classroom",property="classroom"),
		@Result(column="start_time",property="startTime",javaType=java.util.Date.class),
		@Result(column="end_time",property="endTime",javaType=java.util.Date.class),
		@Result(column="teacher_id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByIdWithTeacherId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="attenances",many=@Many(select="org.zhl.scs.dao.AttenanceDao.selectByCourseId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="students",many=@Many(select="org.zhl.scs.dao.StudentDao.selectByCourseId",fetchType=FetchType.LAZY))
	})
	Course selectById(Integer id);

	@SelectProvider(type=CourseDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="score",property="score"),
		@Result(column="code",property="code"),
		@Result(column="end_time",property="endTime"),
		@Result(column="start_time",property="startTime"),
		@Result(column="week",property="week"),
		@Result(column="dateorder",property="dateorder"),
		@Result(column="teacher_id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByIdWithTeacherId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="attenances",many=@Many(select="org.zhl.scs.dao.AttenanceDao.selectByCourseId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="students",many=@Many(select="org.zhl.scs.dao.StudentDao.selectByCourseId",fetchType=FetchType.LAZY))
	})
	List<Course> selectByPage(Map<String, Object> params);

	@Select("select * from tb_course where teacher_id = #{id}")
	List<Course> selectByTeacherId(Integer id);

	@Select("select * from tb_course where id = #{course_id}")
	Course selectByIdWithCourseId(@Param("course_id") Integer id);

	@Select("select * from tb_course where id in (select course_id from student_course where student_id = #{id} )")
	List<Course> selectByStudentId(Integer id);

	@InsertProvider(type=CourseDynaSqlProvider.class,method="insertStudents")
	void insertStudents(Course entity);


	//ljj
	@Select("select * from tb_course where score>=#{score1} and score <=#{score2}")
	List<Course> findCourseByFilterOfScore(Double score1,Double score2);
	@Select("select * from tb_course where score>=#{score}")
	List<Course> findCourseByGreaterThanScore(Double score);
	@Select("select * from tb_course where score<=#{score}")
    List<Course> findCourseByLessThanScore(Double score);
	@Select("select * from tb_course where dateorder>=#{dateorder1} and dateorder<=#{dateorder2}")
	List<Course> findCourseByFilterOfDateorder(Integer dateorder1,Integer dateorder2);
	@Select("select * from tb_course where dateorder>=#{dateorder}")
	List<Course> findCourseByGreaterThanDateorder(Integer dateorder);
	@Select("select * from tb_course where dateorder<=#{dateorder}")
	List<Course> findCourseByLessThanDateorder(Integer dateorder);

}